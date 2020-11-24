package com.generic.file.parser.encoder.impl;

import com.generic.file.parser.encoder.Encoder;

import java.io.UnsupportedEncodingException;

import static com.generic.file.parser.constants.FileParserConstants.ISO_FORMAT;

public class ISOCharacterEncoder  implements Encoder {
    public byte[] encode(String text) throws UnsupportedEncodingException {
        System.out.println("Encoded data in "+ ISO_FORMAT +" format" );
        return text.getBytes(ISO_FORMAT);
    }

    public String decode(byte[] textInBytes) throws UnsupportedEncodingException {
        System.out.println("Decoded data in "+ ISO_FORMAT +" format" );
        return new String (textInBytes);
    }
}
