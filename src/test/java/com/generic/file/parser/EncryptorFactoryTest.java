package com.generic.file.parser;

import com.generic.file.parser.encryptor.impl.AES128Encrypter;
import com.generic.file.parser.encryptor.impl.AES256Encrypter;
import com.generic.file.parser.encryptor.impl.RSAEncrypter;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.generic.file.parser.constants.FileParserConstants.*;

public class EncryptorFactoryTest {

    EncryptorFactory encryptorFactory = new EncryptorFactory();
    @Test
    public void testCreateInstanceGZip() {
        Assert.assertTrue(encryptorFactory.createInstance(AES_128) instanceof AES128Encrypter);
    }
    @Test
    public void testCreateInstanceZip() {
        Assert.assertTrue(encryptorFactory.createInstance(RSA) instanceof RSAEncrypter);
    }
    @Test
    public void testCreateInstanceBz() {
        Assert.assertTrue(encryptorFactory.createInstance(AES_256) instanceof AES256Encrypter);
    }
}
