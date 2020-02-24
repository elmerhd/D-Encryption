package open.elmerhd.d.encryption;

import com.sun.java.swing.plaf.windows.WindowsLookAndFeel;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

/**
 *
 * @author elmerhd
 */
public class DEncrypt {
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(new WindowsLookAndFeel());
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
