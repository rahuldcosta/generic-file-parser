package com.generic.file.parser;

import com.generic.file.parser.encryptor.Encryptor;
import com.generic.file.parser.encryptor.impl.AES128Encrypter;
import com.generic.file.parser.encryptor.impl.AES256Encrypter;
import com.generic.file.parser.encryptor.impl.RSAEncrypter;

import static com.generic.file.parser.constants.FileParserConstants.*;

public class EncryptorFactory {
    public Encryptor createInstance(String type) {

        switch (type) {
            case AES_128:
                return new AES128Encrypter();
            case AES_256:
                return new AES256Encrypter();
            case RSA:
                return new RSAEncrypter();
            default:
                return null;
        }

    }
}
