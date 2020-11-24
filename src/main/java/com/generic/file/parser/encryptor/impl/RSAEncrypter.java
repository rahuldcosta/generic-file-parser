package com.generic.file.parser.encryptor.impl;

import com.generic.file.parser.encryptor.Encryptor;

public class RSAEncrypter implements Encryptor {
    public void encrypt(String text) {
        System.out.println("Encrypted text using RSA Encryption");
    }

    public void decrypt(String text) {
        System.out.println("Decrypted text using RSA Encryption");
    }
}
