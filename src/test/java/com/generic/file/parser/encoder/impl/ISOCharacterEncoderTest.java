package com.generic.file.parser.encoder.impl;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;

import static com.generic.file.parser.constants.FileParserConstants.ISO_FORMAT;

public class ISOCharacterEncoderTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final PrintStream originalErr = System.err;

    ISOCharacterEncoder isoCharacterEncoder;
    String fileName = "abc.txt";

    @BeforeMethod
    public void setUp() {
        isoCharacterEncoder = new ISOCharacterEncoder();
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
        Assert.assertEquals(fileName.getBytes(ISO_FORMAT),isoCharacterEncoder.encode(fileName));
        Assert.assertEquals(outContent.toString(), "Encoded data in "+ ISO_FORMAT +" format\r\n");
    }

    @Test
    public void testDecode() throws UnsupportedEncodingException {
        outContent.reset();
        Assert.assertEquals(fileName,isoCharacterEncoder.decode(fileName.getBytes(ISO_FORMAT)));
        Assert.assertEquals(outContent.toString(), "Decoded data in "+ ISO_FORMAT +" format\r\n");
    }
}
