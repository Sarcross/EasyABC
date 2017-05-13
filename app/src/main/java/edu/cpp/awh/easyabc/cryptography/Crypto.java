package edu.cpp.awh.easyabc.cryptography;

import android.util.Base64;

import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;

public abstract class Crypto {
    public static final String AES = "AES";
    public static final int KEY_SIZE = 128;

    public static String encrypt(String plainText, String k) {

        try
        {
            KeyGenerator keyGenerator =  KeyGenerator.getInstance(AES);
            keyGenerator.init(KEY_SIZE);
            Key key = keyGenerator.generateKey();
            Cipher aesCipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            aesCipher.init(Cipher.ENCRYPT_MODE, key);
            byte[] plainTextBytes = plainText.getBytes(StandardCharsets.UTF_8);
            byte[] cipherText = aesCipher.doFinal(Base64.encode(plainTextBytes, Base64.DEFAULT));
            return new String(cipherText, StandardCharsets.UTF_8);
        }
        catch (NoSuchAlgorithmException e)
        {
            e.printStackTrace();
        }
        catch (BadPaddingException e)
        {
            e.printStackTrace();
        }
        catch (IllegalBlockSizeException e)
        {
            e.printStackTrace();
        }
        catch (NoSuchPaddingException e)
        {
            e.printStackTrace();
        }
        catch (InvalidKeyException e)
        {
            e.printStackTrace();
        }
        return "";
    }

    public static String decrypt(String cipherText, String k) {
        try
        {
            KeyGenerator keyGenerator =  KeyGenerator.getInstance(AES);
            keyGenerator.init(KEY_SIZE);
            Key key = keyGenerator.generateKey();
            Cipher aesCipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            aesCipher.init(Cipher.DECRYPT_MODE, key);
            byte[] cipherTextBytes = cipherText.getBytes(StandardCharsets.UTF_8);
            byte[] plainText = aesCipher.doFinal(Base64.decode(cipherTextBytes, Base64.DEFAULT));
            return new String(plainText, StandardCharsets.UTF_8);
        }
        catch (NoSuchAlgorithmException e)
        {
            e.printStackTrace();
        }
        catch (BadPaddingException e)
        {
            e.printStackTrace();
        }
        catch (IllegalBlockSizeException e)
        {
            e.printStackTrace();
        }
        catch (NoSuchPaddingException e)
        {
            e.printStackTrace();
        }
        catch (InvalidKeyException e)
        {
            e.printStackTrace();
        }
        return "";
    }
}
