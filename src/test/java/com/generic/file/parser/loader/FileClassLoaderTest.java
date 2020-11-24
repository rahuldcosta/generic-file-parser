package com.generic.file.parser.loader;

import com.generic.file.parser.compressor.Compressor;
import org.testng.annotations.Test;

import java.util.Objects;

import static com.generic.file.parser.constants.FileParserConstants.G_ZIP;
import static org.testng.Assert.*;

public class FileClassLoaderTest {

    FileClassLoader javaClassLoader = new FileClassLoader();
    @Test
    public void testInvokeClassMethod() {
        Compressor compressor = compressor = (Compressor) javaClassLoader.invokeClassMethod("com.generic.file.parser.CompressorFactory", "createInstance", G_ZIP);
        Objects.nonNull(compressor);
    }

    @Test
    public void testInvokeClassMethodWithClassNotFound() {
        Compressor compressor = compressor = (Compressor) javaClassLoader.invokeClassMethod("com.generic.file.parser.CompressorFactoryNotFound", "createInstance", G_ZIP);
        Objects.nonNull(compressor);
    }
}
