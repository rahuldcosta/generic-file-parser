package com.generic.file.parser.encryptor.impl;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class AES128EncrypterTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final PrintStream originalErr = System.err;

    AES128Encrypter aes128Encrypter;
    String fileName = "abc.txt";

    @BeforeMethod
    public void setUp() {
        aes128Encrypter = new AES128Encrypter();
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    @AfterMethod
    public void tearDown() {
        System.setOut(originalOut);
        System.setErr(originalErr);
    }

    @Test
    public void testEncrypt() {
        outContent.reset();
        aes128Encrypter.encrypt(fileName);
        Assert.assertEquals(outContent.toString(), "Encrypted text using AES128 Encryption\r\n");
    }

    @Test
    public void testDecrypt() {
        outContent.reset();
        aes128Encrypter.decrypt(fileName);
        Assert.assertEquals(outContent.toString(), "Decrypted text using AES128 Encryption\r\n");
    }
}
