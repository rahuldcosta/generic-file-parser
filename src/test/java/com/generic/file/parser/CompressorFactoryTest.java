package com.generic.file.parser;

import com.generic.file.parser.compressor.impl.BzCompressor;
import com.generic.file.parser.compressor.impl.BzipCompressor;
import com.generic.file.parser.compressor.impl.GzipCompressor;
import com.generic.file.parser.compressor.impl.ZipCompressor;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.generic.file.parser.constants.FileParserConstants.*;
import static org.testng.Assert.*;

public class CompressorFactoryTest {

    CompressorFactory compressorFactory = new CompressorFactory();
    @Test
    public void testCreateInstanceGZip() {
        Assert.assertTrue(compressorFactory.createInstance(G_ZIP) instanceof GzipCompressor);
    }
    @Test
    public void testCreateInstanceZip() {
        Assert.assertTrue(compressorFactory.createInstance(ZIP) instanceof ZipCompressor);
    }
    @Test
    public void testCreateInstanceBz() {
        Assert.assertTrue(compressorFactory.createInstance(BZ) instanceof BzCompressor);
    }
    @Test
    public void testCreateInstanceBZip() {
        Assert.assertTrue(compressorFactory.createInstance(B_ZIP) instanceof BzipCompressor);
    }
}
