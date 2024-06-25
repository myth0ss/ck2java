
package com.hieuthao.security;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import javax.crypto.Cipher;

/**
 *
 * @author MinhHieu
 */
public class EncryptionUtil {
    private static final String ALGORITHM = "RSA";
    private static final int KEY_SIZE = 2048;

    public static KeyPair generateKeyPair() throws Exception {
        KeyPairGenerator keyGen = KeyPairGenerator.getInstance(ALGORITHM);
        keyGen.initialize(KEY_SIZE);
        return keyGen.generateKeyPair();
    }

    public static byte[] encrypt(String text, int publicKey) throws Exception {
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        return cipher.doFinal(text.getBytes());
    }

    public static String decrypt(byte[] text, PrivateKey privateKey) throws Exception {
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.DECRYPT_MODE, privateKey);
        return new String(cipher.doFinal(text));
    }

}
