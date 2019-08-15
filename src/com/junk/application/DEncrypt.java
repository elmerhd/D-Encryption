package com.junk.application;

import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper;

/**
 *
 * @author Elmer
 */
public class DEncrypt {
    public static void main(String[] args) {
        try {
            BeautyEyeLNFHelper.launchBeautyEyeLNF();
            UIManager.put("RootPane.setupButtonVisible", false);
            CommonUtils.createDBFile();
            CommonUtils.createEncryptedFolder();
            SwingUtilities.invokeLater(() -> {
                MainForm main = new MainForm();
                main.setVisible(true);
                main.setLocationRelativeTo(null);
            });
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getCause(), "Unable to launch Application", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
    }
}
