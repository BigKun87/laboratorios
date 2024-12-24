package com.lp.service;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

public class AES256EncryptionService {

    private static final String ALGORITHM = "AES";
    private SecretKeySpec secretKeySpec;

    public AES256EncryptionService(String secret) {
        byte[] key = secret.getBytes();
        secretKeySpec = new SecretKeySpec(key, ALGORITHM);
    }

    public String encrypt(String data) throws Exception {
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec);
        byte[] encrypted = cipher.doFinal(data.getBytes());
        return Base64.getEncoder().encodeToString(encrypted);
    }

    public String decrypt(String encryptedData) throws Exception {
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.DECRYPT_MODE, secretKeySpec);
        byte[] decodedBytes = Base64.getDecoder().decode(encryptedData);
        byte[] decrypted = cipher.doFinal(decodedBytes);
        return new String(decrypted);
    }
}

