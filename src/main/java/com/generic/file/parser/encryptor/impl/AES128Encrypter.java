package com.generic.file.parser.encryptor.impl;

import com.generic.file.parser.encryptor.Encryptor;

public class AES128Encrypter implements Encryptor {
    public void encrypt(String text) {
        System.out.println("Encrypted text using AES128 Encryption");
    }

    public void decrypt(String text) {
        System.out.println("Decrypted text using AES128 Encryption");
    }
}
