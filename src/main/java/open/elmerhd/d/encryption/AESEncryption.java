package open.elmerhd.d.encryption;

import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;

/**
 * AES128 Encryption , AES/CBC/PKCS5PADDING
 * @author elmerhd
 */
public class AESEncryption {

    /**
     * Encrypts a string
     *
     * @param str the string 
     * @param IV the 16 bytes IV String
     * @param  secretKey the 16 bytes secrectKey String
     * @return encrypted String
     */
    public static String encrypt(String str,String IV,String secretKey) throws IllegalBlockSizeException, NoSuchAlgorithmException, InvalidKeyException, NoSuchPaddingException, InvalidAlgorithmParameterException, UnsupportedEncodingException, BadPaddingException {

        IvParameterSpec iv = new IvParameterSpec(IV.getBytes("UTF-8"));
        SecretKeySpec skeySpec = new SecretKeySpec(secretKey.getBytes("UTF-8"), "AES");

        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
        cipher.init(Cipher.ENCRYPT_MODE, skeySpec, iv);

        byte[] encrypted = cipher.doFinal(str.getBytes());
        return DatatypeConverter.printBase64Binary(encrypted);

    }

    /**
     * Decrypts an encrypted string
     *
     * @param encrypted‌​String the encrypted string 
     * @param IV the 16 bytes IV String
     * @param  secretKey the 16 bytes secrectKey String
     * @return decrypted String
     */
    public static String decrypt(String encrypted‌​String,String IV,String secretKey) throws UnsupportedEncodingException, NoSuchAlgorithmException, InvalidKeyException, NoSuchPaddingException, InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException {

        IvParameterSpec iv = new IvParameterSpec(IV.getBytes("UTF-8"));
        SecretKeySpec skeySpec = new SecretKeySpec(secretKey.getBytes("UTF-8"), "AES");

        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
        cipher.init(Cipher.DECRYPT_MODE, skeySpec, iv);

        byte[] original = cipher.doFinal(DatatypeConverter.parseBase64Binary(encrypted‌​String));
        return new String(original);
    }
    
}