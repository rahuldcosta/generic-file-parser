package com.generic.file.parser.encoder.impl;

import com.generic.file.parser.encoder.Encoder;

import java.io.UnsupportedEncodingException;

import static com.generic.file.parser.constants.FileParserConstants.UTF_8_FORMAT;

public class UTFCharacterEncoder implements Encoder {
    public byte[] encode(String text) throws UnsupportedEncodingException {
        System.out.println("Encoded data in "+ UTF_8_FORMAT +" format" );
        return text.getBytes(UTF_8_FORMAT);
    }

    public String decode(byte[] textInBytes) throws UnsupportedEncodingException {
        System.out.println("Decoded data in "+ UTF_8_FORMAT +" format" );
        return new String(textInBytes);
    }
}
