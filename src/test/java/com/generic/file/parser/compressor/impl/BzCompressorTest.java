package com.generic.file.parser.compressor.impl;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class BzCompressorTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final PrintStream originalErr = System.err;

    BzCompressor bzCompressor;
    String fileName = "abc.txt";

    @BeforeMethod
    public void setUp() {
        bzCompressor = new BzCompressor();
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
        bzCompressor.compress(fileName);
        Assert.assertEquals(outContent.toString(), "File:- " + fileName + " compressed to bz format:- " + fileName + ".bz\r\n");
    }

    @Test
    public void testDeCompress() {
        outContent.reset();
        bzCompressor.deCompress(fileName);
        Assert.assertEquals(outContent.toString(), "File:- " + fileName + " De-Compressed from bz format\r\n");
    }
}
