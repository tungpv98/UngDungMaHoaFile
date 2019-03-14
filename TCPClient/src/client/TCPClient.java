/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import common.FileInfo;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 *
 * @author tungphan
 */
public class TCPClient {
    // create socket object
    public Socket client;
    private String serverHost = "localhost";
    private int serverPort = 9900;
    String destinationDir = "D:\\BTL\\Server\\"; 
    
    // run program
    /*public void main(String[] args) {
        String sourceFilePath = "D:\\BTL\\Client\\data1.txt";
        
        TCPClient tcpClient = new TCPClient();
        tcpClient.connectServer();
        tcpClient.sendFile(sourceFilePath, destinationDir);
        tcpClient.closeSocket(tcpClient.client);

    }
*/
    
    
    // conect to server
    public void connectServer(){
        try {
            client = new Socket(serverHost, serverPort);
            System.out.println("conected to server");
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    
    // send file to server
    public FileInfo sendFile(String sourceFilePath){
        DataOutputStream outToServer = null;
        ObjectOutputStream oos = null;
        ObjectInputStream ois = null;
        
        try {
            // make greeting
            outToServer = new DataOutputStream(
            client.getOutputStream());
            outToServer.writeUTF("Hello from "+client.getLocalSocketAddress());
            // get file info
            FileInfo fileInfo = getFileInfo(sourceFilePath);
            
            // send file
            oos = new ObjectOutputStream(client.getOutputStream());
            oos.writeObject(fileInfo);

            // get confirmation
            ois = new ObjectInputStream(client.getInputStream());
            fileInfo = (FileInfo) ois.readObject();
            if (fileInfo != null) {
                System.out.println(fileInfo.getStatus());
                return fileInfo;
            }
           
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            // close all stream
            closeStream(oos);
            closeStream(ois);
            closeStream(outToServer);
        }
        return null;

       
    }
    
    // create file with fileInfor
    public boolean createFile(FileInfo fileInfo) {

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
    
    // get source file info
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
            fileInfo.setDestinationDirectory(destinationDir);
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            closeStream(bis);
        }
        return fileInfo;
    }
    
    // colse socket
    public void closeSocket(Socket socket) {
        try {
            if (socket != null) {
                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // close input stream
    public void closeStream(InputStream inputStream) {
        try {
            if (inputStream != null) {
                inputStream.close();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
 
    // close output Stream 
    public void closeStream(OutputStream outputStream) {
        try {
            if (outputStream != null) {
                outputStream.close();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }


}
