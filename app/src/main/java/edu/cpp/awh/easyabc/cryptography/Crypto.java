package edu.cpp.awh.easyabc.cryptography;

import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;

public abstract class Crypto {
    public static final String AES = "AES";

    public static String getHash(String plain) {
        try
        {
            MessageDigest md  = MessageDigest.getInstance("MD5");
            md.update(plain.getBytes(StandardCharsets.UTF_8));
            return new String(md.digest(), StandardCharsets.UTF_8);
        }
        catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return "";
        }

    }

    public static String encrypt(String plain, String k) {
        try
        {
            byte[] key = k.getBytes();
            byte[] ciph = plain.getBytes();

            Cipher c = Cipher.getInstance(AES);
            SecretKeySpec spec = new SecretKeySpec(key, AES);
            c.init(Cipher.ENCRYPT_MODE, spec);
            byte[] encryptedData = c.doFinal(ciph);

            return encryptedData.toString();
        }
        catch(NoSuchPaddingException e)
        {
            e.printStackTrace();
            return "";
        }
        catch(InvalidKeyException e)
        {
            e.printStackTrace();
            return "";
        } catch (BadPaddingException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (IllegalBlockSizeException e) {
            e.printStackTrace();
        }
        return "";
    }

    public static String decrypt(String cipher, String key) {
        try
        {
            Cipher c = Cipher.getInstance(AES);
            SecretKeySpec k = new SecretKeySpec(key.getBytes(), AES);
            c.init(Cipher.DECRYPT_MODE, k);
            return c.doFinal(cipher.getBytes()).toString();
        }
        catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return "";
        }
        catch (NoSuchPaddingException e) {
            e.printStackTrace();
            return "";
        }
        catch (BadPaddingException e) {
            e.printStackTrace();
        }
        catch (IllegalBlockSizeException e) {
            e.printStackTrace();
        }
        catch (InvalidKeyException e) {
            e.printStackTrace();
        }

        return "";
    }

    public static void clearCharArray(char[] arr) {
        for(int ndx = 0; ndx < arr.length; ndx++) {
            arr[ndx] = '\0';
        }
    }
}
