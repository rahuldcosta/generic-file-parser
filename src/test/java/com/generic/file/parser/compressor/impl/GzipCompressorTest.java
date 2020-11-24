package com.generic.file.parser.compressor.impl;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class GzipCompressorTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final PrintStream originalErr = System.err;

    GzipCompressor gzipCompressor;
    String fileName = "abc.txt";

    @BeforeMethod
    public void setUp() {
        gzipCompressor = new GzipCompressor();
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    @AfterMethod
    public void tearDown() {
        System.setOut(originalOut);
        System.setErr(originalErr);
    }

    @Test
    public void testCompress() {
        outContent.reset();
        gzipCompressor.compress(fileName);
        Assert.assertEquals(outContent.toString(), "File:- " + fileName + " compressed to gzip format:- " + fileName + ".gzip\r\n");
    }

    @Test
    public void testDeCompress() {
        outContent.reset();
        gzipCompressor.deCompress(fileName);
        Assert.assertEquals(outContent.toString(), "File:- abc.txt De-Compressed from gzip format \r\n");
    }
}
