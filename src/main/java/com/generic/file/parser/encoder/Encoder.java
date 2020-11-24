package com.generic.file.parser.encoder;

import java.io.UnsupportedEncodingException;

public interface Encoder {
    public byte[] encode(String text) throws UnsupportedEncodingException;
    public String decode(byte[] textInBytes) throws UnsupportedEncodingException;
}
