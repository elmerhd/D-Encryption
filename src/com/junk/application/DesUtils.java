package com.junk.application;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.CipherOutputStream;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.swing.JProgressBar;

public class DesUtils {

    public static void encrypt(String key, InputStream is, OutputStream os, File src, JProgressBar progressBar) throws InvalidKeyException, NoSuchAlgorithmException, InvalidKeySpecException, NoSuchPaddingException, IOException {
        encryptOrDecrypt(key, Cipher.ENCRYPT_MODE, is, os, src, progressBar);
    }

    public static void decrypt(String key, InputStream is, OutputStream os, File src, JProgressBar progressBar) throws InvalidKeyException, NoSuchAlgorithmException, InvalidKeySpecException, NoSuchPaddingException, IOException {
        encryptOrDecrypt(key, Cipher.DECRYPT_MODE, is, os, src, progressBar);
    }

    private static void encryptOrDecrypt(String key, int mode, InputStream is, OutputStream os, File src, JProgressBar progressBar) throws InvalidKeyException, NoSuchAlgorithmException, InvalidKeySpecException, NoSuchPaddingException, IOException {
        DESKeySpec dks = new DESKeySpec(key.getBytes());
        SecretKeyFactory skf = SecretKeyFactory.getInstance("DES");
        SecretKey desKey = skf.generateSecret(dks);
        Cipher cipher = Cipher.getInstance("DES");
        if (mode == Cipher.ENCRYPT_MODE) {
            cipher.init(Cipher.ENCRYPT_MODE, desKey);
            CipherInputStream cis = new CipherInputStream(is, cipher);
            doCopy(cis, os, src, progressBar);
        } else if (mode == Cipher.DECRYPT_MODE) {
            cipher.init(Cipher.DECRYPT_MODE, desKey);
            CipherOutputStream cos = new CipherOutputStream(os, cipher);
            doCopy(is, cos, src, progressBar);
        }
    }

    /**
     * Copy input stream to output stream
     *
     * @param is the input stream
     * @param os the output stream
     * @throws IOException
     */
    private static void doCopy(InputStream is, OutputStream os, File src, JProgressBar progressBar) throws IOException {
        byte[] bytes = new byte[64];
        long expectedBytes = src.length(); // This is the number of bytes we expected to copy..
        long totalBytesCopied = 0; // This will track the total number of bytes we've copied
        int numBytes; // This is the number of bytes currently copying
        int progress = 0;
        while ((numBytes = is.read(bytes)) != -1) {
            os.write(bytes, 0, numBytes);
            totalBytesCopied += numBytes;
            progress = (int) Math.round(((double) totalBytesCopied / (double) expectedBytes) * 100);
            progressBar.setValue(progress);
        }
        os.flush();
        os.close();
        is.close();
    }

}
