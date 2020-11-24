package com.generic.file.parser.encryptor.impl;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class RSAEncrypterTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final PrintStream originalErr = System.err;

    RSAEncrypter rsaEncrypter;
    String fileName = "abc.txt";

    @BeforeMethod
    public void setUp() {
        rsaEncrypter = new RSAEncrypter();
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
        rsaEncrypter.encrypt(fileName);
        Assert.assertEquals(outContent.toString(), "Encrypted text using RSA Encryption\r\n");
    }

    @Test
    public void testDecrypt() {
        outContent.reset();
        rsaEncrypter.decrypt(fileName);
        Assert.assertEquals(outContent.toString(), "Decrypted text using RSA Encryption\r\n");
    }
}
