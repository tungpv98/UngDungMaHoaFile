/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import Compression.Hunzipping;
import Compression.Hzipping;
import common.FileInfo;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.file.Files;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author tungphan
 */
public class TCPServer extends Thread {

    // create serverSocket object
    private ServerSocket serverSocket;
    private int port = 9900;

    public static void main(String[] args) throws IOException {
        TCPServer tCPServer = new TCPServer();
        tCPServer.open();
        tCPServer.start();

    }

    // open server
    public void open() throws IOException {
        serverSocket = new ServerSocket(port);
        System.out.println("Server is open on port : " + port);
    }

    // handle event
    public void run() {
        while (true) {
            Socket server = null;
            DataInputStream inFromClient = null;
            ObjectInputStream ois = null;
            ObjectOutputStream oos = null;
            BufferedInputStream bis = null;
            try {
                // accept conect from client and create Socket object
                server = serverSocket.accept();
                System.out.println("Connected to " + server.getRemoteSocketAddress());

                // get greeting from client
                inFromClient = new DataInputStream(server.getInputStream());
                System.out.println(inFromClient.readUTF());

                // receive file infor
                ois = new ObjectInputStream(server.getInputStream());
                FileInfo fileInfo = (FileInfo) ois.readObject();
                if (fileInfo != null) {

                    // luu file da nhan vao server
                    createFile(fileInfo);
                    String filePart = fileInfo.getDestinationDirectory()
                            + fileInfo.getFilename();
                    int len = fileInfo.getFilename().length();
                    // kiểm tra định dạng
                    String format = fileInfo.getFilename().substring(len-6, len);
                    System.out.println(format);
                    if (!".huffz".equals(format)) {
                        // nen file bang thuat toan huffman
                        Hzipping.beginHzipping(filePart);

                        // tao file infor gui tra ve client
                        filePart = filePart + ".huffz";
                        fileInfo = getFileInfo(filePart);
                    } else {
                        // giai nen file bang thuat toan huffman
                        Hunzipping.beginHunzipping(filePart);
                        
                        // tao file infor gui tra ve client
                        filePart = filePart.substring(0, filePart.length()-6);
                        System.out.println(filePart);
                        fileInfo = getFileInfo(filePart);
                    }

                }

                // confirm that file is received
                oos = new ObjectOutputStream(server.getOutputStream());
                fileInfo.setStatus("success");
                //fileInfo.setDataBytes(null);
                oos.writeObject(fileInfo);

            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } finally {
                // close all stream
                closeStream(ois);
                closeStream(oos);
                closeStream(inFromClient);
                // close session
                closeSocket(server);
            }

        }
    }

    private FileInfo getFileInfo(String sourceFilePath) {
        FileInfo fileInfo = null;
        BufferedInputStream bis = null;
        try {
            File sourceFile = new File(sourceFilePath);
            bis = new BufferedInputStream(new FileInputStream(sourceFile));
            fileInfo = new FileInfo();
            System.out.println(sourceFile.length());

            byte[] fileBytes = new byte[(int) sourceFile.length()];
            // get file info
            bis.read(fileBytes, 0, fileBytes.length);
            fileInfo.setFilename(sourceFile.getName());
            fileInfo.setDataBytes(fileBytes);
            fileInfo.setDestinationDirectory("null");
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            closeStream(bis);
        }
        return fileInfo;
    }

    // create file with fileInfor
    private boolean createFile(FileInfo fileInfo) {

        BufferedOutputStream bos = null;

        try {
            if (fileInfo != null) {
                File fileReceive = new File(fileInfo.getDestinationDirectory()
                        + fileInfo.getFilename());
                bos = new BufferedOutputStream(new FileOutputStream(fileReceive));
                // write file content
                bos.write(fileInfo.getDataBytes());
                bos.flush();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
            return false;
        } finally {
            closeStream(bos);
        }

        return true;

    }

    // close socket
    public void closeSocket(Socket socket) {

        try {
            if (socket != null) {
                socket.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // close input stream
    public void closeStream(InputStream inputStream) {
        try {
            if (inputStream != null) {
                inputStream.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // close output stream
    public void closeStream(OutputStream outputStream) {
        try {
            if (outputStream != null) {
                outputStream.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
