package com.generic.file.parser.parser;

import com.generic.file.parser.CompressorFactory;
import com.generic.file.parser.EncoderFactory;
import com.generic.file.parser.EncryptorFactory;
import com.generic.file.parser.compressor.Compressor;
import com.generic.file.parser.encoder.Encoder;
import com.generic.file.parser.encryptor.Encryptor;
import com.generic.file.parser.parser.processor.CSVFileParserProcessor;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.UnsupportedEncodingException;

import static com.generic.file.parser.constants.FileParserConstants.*;

public class CSVFileParserTest {

    CSVFileParser CSVFileParser;
    Compressor compressor = null;
    Encryptor encryptor = null;
    Encoder encoder = null;
    String fileName = "abc.txt";
    String filePath = "C:\\Data";
    String[] args = {"file=foo.zzz", "path=C:\\Data", "encoding=UTF8", "compression=gzip", "encryption=AES128"};


    @Test
    public void testReadAndWriteFile() throws UnsupportedEncodingException {
        compressor = new CompressorFactory().createInstance(G_ZIP);
        encoder = new EncoderFactory().createInstance(UTF_8_FORMAT);
        encryptor = new EncryptorFactory().createInstance(AES_128);
        CSVFileParserProcessor csvFileParserProcessor = new CSVFileParserProcessor();
        CSVFileParser =  csvFileParserProcessor.getParser(fileName, filePath, compressor, encryptor, encoder);
        CSVFileParser.readFile(args);
        CSVFileParser.writeFile(args);
    }

    @Test
    public void testReadAndWriteFileWithoutParams() throws UnsupportedEncodingException {
        encryptor = new EncryptorFactory().createInstance(AES_128);
        CSVFileParserProcessor csvFileParserProcessor = new CSVFileParserProcessor();
        CSVFileParser =  csvFileParserProcessor.getParser(fileName, filePath, compressor, encryptor, encoder);
        CSVFileParser.readFile(args);
        CSVFileParser.writeFile(args);
    }

    @Test
    public void testReadAndWriteFileWithMissingFileNameParam() throws UnsupportedEncodingException {
        compressor = new CompressorFactory().createInstance(G_ZIP);
        encoder = new EncoderFactory().createInstance(UTF_8_FORMAT);
        encryptor = new EncryptorFactory().createInstance(AES_128);
        CSVFileParserProcessor csvFileParserProcessor = new CSVFileParserProcessor();
        CSVFileParser =  csvFileParserProcessor.getParser(fileName, filePath, compressor, encryptor, encoder);
        CSVFileParser.readFile(args);
        CSVFileParser.writeFile(args);
    }


    @Test
    public void testReadAndWriteFileWithMissingFilePathParam() throws UnsupportedEncodingException {
        compressor = new CompressorFactory().createInstance(G_ZIP);
        encoder = new EncoderFactory().createInstance(UTF_8_FORMAT);
        encryptor = new EncryptorFactory().createInstance(AES_128);
        CSVFileParserProcessor csvFileParserProcessor = new CSVFileParserProcessor();
        CSVFileParser =  csvFileParserProcessor.getParser(fileName, filePath, compressor, encryptor, encoder);
        CSVFileParser.readFile(args);
        CSVFileParser.writeFile(args);
    }


    @Test
    public void testReadAndWriteFileWithMissingEncodingParam() throws UnsupportedEncodingException {
        compressor = new CompressorFactory().createInstance(G_ZIP);
        encryptor = new EncryptorFactory().createInstance(AES_128);
        CSVFileParserProcessor csvFileParserProcessor = new CSVFileParserProcessor();
        CSVFileParser =  csvFileParserProcessor.getParser(fileName, filePath, compressor, encryptor, encoder);
        CSVFileParser.readFile(args);
        CSVFileParser.writeFile(args);
    }

    @Test
    public void testReadAndWriteFileWithMissingEncrpytionParam() throws UnsupportedEncodingException {
        compressor = new CompressorFactory().createInstance(G_ZIP);
        encoder = new EncoderFactory().createInstance(UTF_8_FORMAT);
        CSVFileParserProcessor csvFileParserProcessor = new CSVFileParserProcessor();
        CSVFileParser =  csvFileParserProcessor.getParser(fileName, filePath, compressor, encryptor, encoder);
        CSVFileParser.readFile(args);
        CSVFileParser.writeFile(args);
    }

    @Test
    public void testReadAndWriteFileWithMissingCompressionParam() throws UnsupportedEncodingException {
        encoder = new EncoderFactory().createInstance(UTF_8_FORMAT);
        encryptor = new EncryptorFactory().createInstance(AES_128);
        CSVFileParserProcessor csvFileParserProcessor = new CSVFileParserProcessor();
        CSVFileParser =  csvFileParserProcessor.getParser(fileName, filePath, compressor, encryptor, encoder);
        CSVFileParser.readFile(args);
        CSVFileParser.writeFile(args);
    }

    @Test
    public void testGetFileName() throws UnsupportedEncodingException {
        compressor = new CompressorFactory().createInstance(G_ZIP);
        encoder = new EncoderFactory().createInstance(UTF_8_FORMAT);
        encryptor = new EncryptorFactory().createInstance(AES_128);
        CSVFileParserProcessor csvFileParserProcessor = new CSVFileParserProcessor();
        CSVFileParser =  csvFileParserProcessor.getParser(fileName, filePath, compressor, encryptor, encoder);
        Assert.assertEquals(fileName, CSVFileParser.getFileName());
    }

    @Test
    public void testGetFilePath() {
        compressor = new CompressorFactory().createInstance(G_ZIP);
        encoder = new EncoderFactory().createInstance(UTF_8_FORMAT);
        encryptor = new EncryptorFactory().createInstance(AES_128);
        CSVFileParserProcessor csvFileParserProcessor = new CSVFileParserProcessor();
        CSVFileParser =  csvFileParserProcessor.getParser(fileName, filePath, compressor, encryptor, encoder);
        Assert.assertEquals(filePath, CSVFileParser.getFilePath());
    }
}
