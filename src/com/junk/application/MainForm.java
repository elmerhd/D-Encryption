/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.junk.application;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.security.auth.callback.ConfirmationCallback;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Elmer
 */
public class MainForm extends javax.swing.JFrame {
    private DecimalFormat df = new DecimalFormat("#,##0.00");
    public HashMap<String,DencFile> dataMap;
    /**
     * Creates new form MainForm
     */
    public MainForm() {
        initComponents();
        readData();
    }
    private DefaultTableModel model = null;
    
    public void readData(){
        try {
            model = (DefaultTableModel) encryptedTable.getModel();
            model.setRowCount(0);
            dataMap = CommonUtils.readData();
            for (DencFile file : dataMap.values()) {
                String originalFileName = file.getOriginalFileName();
                String fileSize = df.format(CommonUtils.getFileSize(Long.parseLong(file.getFileSize())))  + " Mb";
                String encryptedFileName = file.getTempFileName();
                String password = file.getPassword();
                model.addRow(new String [] { originalFileName, fileSize, password, encryptedFileName });
            }
            encryptedTable.setModel(model);
        } catch (Exception ex) {
            Logger.getLogger(MainForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnEncrypt = new javax.swing.JButton();
        btnDecrypt = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        encryptedTable = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("DEncryption");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        btnEncrypt.setFont(new java.awt.Font("Courier New", 1, 24)); // NOI18N
        btnEncrypt.setText("New Encryption");
        btnEncrypt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEncryptActionPerformed(evt);
            }
        });

        btnDecrypt.setFont(new java.awt.Font("Courier New", 1, 24)); // NOI18N
        btnDecrypt.setText("Decryption");
        btnDecrypt.setEnabled(false);
        btnDecrypt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDecryptActionPerformed(evt);
            }
        });

        encryptedTable.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N
        encryptedTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "<html><font face=\"Courier New\" color=\"green\" size=\"6\">File Name</font></html>", "<html><font face=\"Courier New\" color=\"green\" size=\"6\">File Size</font></html>", "<html><font face=\"Courier New\" color=\"green\" size=\"6\">Password</font></html>", "<html><font face=\"Courier New\" color=\"green\" size=\"6\">Encrypted File</font></html>"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        encryptedTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        encryptedTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                encryptedTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(encryptedTable);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1020, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnEncrypt, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDecrypt, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEncrypt)
                    .addComponent(btnDecrypt))
                .addGap(10, 10, 10)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 468, Short.MAX_VALUE)
                .addGap(10, 10, 10))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEncryptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEncryptActionPerformed
        EncryptDialog ed = new EncryptDialog(this,this, true);
        ed.setLocationRelativeTo(this);
        ed.setVisible(true);
    }//GEN-LAST:event_btnEncryptActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        int closingOption = JOptionPane.showConfirmDialog(this, "Sure to close app?", "Confirmation", JOptionPane.YES_NO_OPTION);
        if (closingOption == ConfirmationCallback.YES) {
            System.exit(0);
        }
    }//GEN-LAST:event_formWindowClosing

    private void encryptedTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_encryptedTableMouseClicked
        btnDecrypt.setEnabled(true);
    }//GEN-LAST:event_encryptedTableMouseClicked

    private void btnDecryptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDecryptActionPerformed
        int row = encryptedTable.getSelectedRow();
        String encryptedFileName = encryptedTable.getValueAt(row, 2).toString();
        DecryptedDialog dd = new DecryptedDialog(this, this, true, dataMap, encryptedFileName);
        dd.setLocationRelativeTo(this);
        dd.setVisible(true);
    }//GEN-LAST:event_btnDecryptActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDecrypt;
    private javax.swing.JButton btnEncrypt;
    private javax.swing.JTable encryptedTable;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}