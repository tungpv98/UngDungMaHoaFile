/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import client.TCPClient;
import common.FileInfo;
import java.io.File;
import javax.swing.JFileChooser;

/**
 *
 * @author tungphan
 */
public class ClientGUI extends javax.swing.JFrame {

    /**
     * Creates new form ClientGUI
     */
    String log = "", sourceFilePath;
    static public File opened_file, save_file;

    public ClientGUI() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jButton_ChooseFile = new javax.swing.JButton();
        jTextField_FileInputDir = new javax.swing.JTextField();
        jButton_Zip = new javax.swing.JButton();
        jButton_UnZip = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea_ThongBao = new javax.swing.JTextArea();
        jLabel_SizeInput = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        jLabel3.setText("jLabel3");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        setResizable(false);

        jLabel1.setText("DỊCH VỤ MÃ HÓA VÀ GIẢI MÃ FILE SỬ DỤNG THUẬT TOÁN HUFFMAN");

        jButton_ChooseFile.setText("Chọn File ");
        jButton_ChooseFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_ChooseFileActionPerformed(evt);
            }
        });

        jButton_Zip.setText("NÉN FILE");
        jButton_Zip.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_ZipActionPerformed(evt);
            }
        });

        jButton_UnZip.setText("GIẢI NÉN FILE");
        jButton_UnZip.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_UnZipActionPerformed(evt);
            }
        });

        jTextArea_ThongBao.setColumns(20);
        jTextArea_ThongBao.setRows(5);
        jScrollPane1.setViewportView(jTextArea_ThongBao);

        jLabel2.setText("HỌC VIỆN KỸ THUẬT MẬT MÃ");

        jLabel4.setText("BAN CƠ YẾU CHÍNH PHỦ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButton_Zip, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton_UnZip, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jTextField_FileInputDir, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 61, Short.MAX_VALUE)
                        .addComponent(jButton_ChooseFile, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel_SizeInput, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addGap(10, 10, 10)
                .addComponent(jLabel_SizeInput)
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField_FileInputDir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton_ChooseFile))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton_UnZip)
                    .addComponent(jButton_Zip))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_ChooseFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_ChooseFileActionPerformed
        // TODO add your handling code here:
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        int result = fileChooser.showOpenDialog(null);
        opened_file = fileChooser.getSelectedFile();
        jTextField_FileInputDir.setText(opened_file.getPath());
        sourceFilePath = opened_file.getPath();
        log = "--- FILE ĐÃ CHỌN : " + sourceFilePath + "\n";
        jTextArea_ThongBao.append(log);
        log = "--- DUNG LƯỢNG : " + opened_file.length() + " bytes\n";
        jTextArea_ThongBao.append(log);
    }//GEN-LAST:event_jButton_ChooseFileActionPerformed

    private void jButton_ZipActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_ZipActionPerformed
        // TODO add your handling code here:
        FileInfo fileInfo = new FileInfo();
        TCPClient tcpClient = new TCPClient();
        tcpClient.connectServer();
        log = "--- SERVER SẴN SÀNG!\n";
        jTextArea_ThongBao.append(log);
        fileInfo = tcpClient.sendFile(sourceFilePath);
        if ("success".equals(fileInfo.getStatus())) {
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
            int result = fileChooser.showOpenDialog(null);
            save_file = fileChooser.getSelectedFile();
            fileInfo.setDestinationDirectory(save_file.getPath() + "\\");
            tcpClient.createFile(fileInfo);
            log = "---------------------------------------------------------------------------------------------------------------------------------------------\n";
            jTextArea_ThongBao.append(log);
            log = "--- ĐÃ NÉN FILE THÀNH CÔNG!\n";
            jTextArea_ThongBao.append(log);
            log = "--- FILE ĐÃ NÉN : " + fileInfo.getDestinationDirectory() + fileInfo.getFilename() + "\n";
            jTextArea_ThongBao.append(log);
            log = "--- DUNG LƯỢNG : " + fileInfo.getDataBytes().length + " bytes\n";
            jTextArea_ThongBao.append(log);

        }
        tcpClient.closeSocket(tcpClient.client);
        log = "--- CẢM ƠN BẠN ĐÃ SỬ DỤNG DỊCH VỤ NÉN FILE TRỰC TUYẾN\n";
        jTextArea_ThongBao.append(log);
        log = "---------------------------------------------------------------------------------------------------------------------------------------------\n";
        jTextArea_ThongBao.append(log);
    }//GEN-LAST:event_jButton_ZipActionPerformed

    private void jButton_UnZipActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_UnZipActionPerformed
        // TODO add your handling code here:
        FileInfo fileInfo = new FileInfo();
        TCPClient tcpClient = new TCPClient();
        tcpClient.connectServer();
        log = "--- SERVER SẴN SÀNG!\n";
        jTextArea_ThongBao.append(log);
        fileInfo = tcpClient.sendFile(sourceFilePath);
        if ("success".equals(fileInfo.getStatus())) {
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
            int result = fileChooser.showOpenDialog(null);
            save_file = fileChooser.getSelectedFile();
            fileInfo.setDestinationDirectory(save_file.getPath() + "\\");
            tcpClient.createFile(fileInfo);
            log = "---------------------------------------------------------------------------------------------------------------------------------------------\n";
            jTextArea_ThongBao.append(log);
            log = "--- ĐÃ NÉN FILE THÀNH CÔNG!\n";
            jTextArea_ThongBao.append(log);
            log = "---------------------------------------------------------------------------------------------------------------------------------------------\n";
            jTextArea_ThongBao.append(log);
            log = "--- FILE ĐÃ GIẢI NÉN : " + fileInfo.getDestinationDirectory() + "\n";
            jTextArea_ThongBao.append(log);
            log = "--- DUNG LƯỢNG : " + fileInfo.getDataBytes().length + " bytes\n";
            jTextArea_ThongBao.append(log);

        }
        tcpClient.closeSocket(tcpClient.client);
        log = "--- CẢM ƠN BẠN ĐÃ SỬ DỤNG DỊCH VỤ GIẢI NÉN FILE TRỰC TUYẾN\n";
        jTextArea_ThongBao.append(log);
        log = "---------------------------------------------------------------------------------------------------------------------------------------------\n";
        jTextArea_ThongBao.append(log);

    }//GEN-LAST:event_jButton_UnZipActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ClientGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ClientGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ClientGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ClientGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ClientGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_ChooseFile;
    private javax.swing.JButton jButton_UnZip;
    private javax.swing.JButton jButton_Zip;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel_SizeInput;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea_ThongBao;
    private javax.swing.JTextField jTextField_FileInputDir;
    // End of variables declaration//GEN-END:variables
}
