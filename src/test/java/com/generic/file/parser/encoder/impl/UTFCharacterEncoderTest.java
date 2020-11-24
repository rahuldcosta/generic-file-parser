package com.generic.file.parser.encoder.impl;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;

import static com.generic.file.parser.constants.FileParserConstants.ISO_FORMAT;
import static com.generic.file.parser.constants.FileParserConstants.UTF_8_FORMAT;

public class UTFCharacterEncoderTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final PrintStream originalErr = System.err;

    UTFCharacterEncoder utfCharacterEncoder;
    String fileName = "abc.txt";

    @BeforeMethod
    public void setUp() {
        utfCharacterEncoder = new UTFCharacterEncoder();
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    @AfterMethod
    public void tearDown() {
        System.setOut(originalOut);
        System.setErr(originalErr);
    }
    @Test
    public void testEncode() throws UnsupportedEncodingException {
        outContent.reset();
        Assert.assertEquals(fileName.getBytes(UTF_8_FORMAT), utfCharacterEncoder.encode(fileName));
        Assert.assertEquals(outContent.toString(), "Encoded data in "+ UTF_8_FORMAT +" format\r\n");
    }

    @Test
    public void testDecode() throws UnsupportedEncodingException {
        outContent.reset();
        Assert.assertEquals(fileName, utfCharacterEncoder.decode(fileName.getBytes(UTF_8_FORMAT)));
        Assert.assertEquals(outContent.toString(), "Decoded data in "+ UTF_8_FORMAT +" format\r\n");
    }
}
