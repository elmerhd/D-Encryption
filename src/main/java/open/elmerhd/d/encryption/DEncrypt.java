package open.elmerhd.d.encryption;

import com.alee.laf.WebLookAndFeel;
import com.alee.skin.dark.WebDarkSkin;
import java.io.IOException;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

/**
 *
 * @author elmerhd
 */
public class DEncrypt {

    public static void main(String[] args) {
        WebLookAndFeel.install(WebDarkSkin.class);
        try {
            CommonUtils.createDBFile();
            CommonUtils.createEncryptedFolder();
            SwingUtilities.invokeLater(() -> {
                MainForm main = new MainForm();
                main.setVisible(true);
                main.setLocationRelativeTo(null);
            });
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
