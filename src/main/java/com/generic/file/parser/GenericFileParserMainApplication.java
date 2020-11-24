package com.generic.file.parser;

import com.generic.file.parser.compressor.Compressor;
import com.generic.file.parser.encoder.Encoder;
import com.generic.file.parser.encryptor.Encryptor;
import com.generic.file.parser.loader.FileClassLoader;
import com.generic.file.parser.parser.CSVFileParser;
import com.generic.file.parser.parser.processor.CSVFileParserProcessor;

import java.io.UnsupportedEncodingException;
import java.util.Objects;

import static com.generic.file.parser.constants.FileParserConstants.*;

public class GenericFileParserMainApplication {
    public static void main(String[] args) {
        CSVFileParser CSVFileParser = getGenericFileParser(args);

        if (Objects.nonNull(CSVFileParser)) {
            try {
                System.out.println("********Executing ReadFileOperation*******");
                System.out.println("For Filename :- " + CSVFileParser.getFileName() + " Located at :- " + CSVFileParser.getFilePath());
                CSVFileParser.readFile(args);
                System.out.println();
                System.out.println("********Executing WriteFileOperation*******");
                System.out.println("For Filename :- " + CSVFileParser.getFileName() + " Located at :- " + CSVFileParser.getFilePath());
                CSVFileParser.writeFile(args);
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }

    }

    private static CSVFileParser getGenericFileParser(String[] args) {
        if (args.length == 0) {
            System.out.println("[ERROR]:- Command line parameters cannot be empty");
            System.out.println("Please refer to below example");
            System.out.println("[EXAMPLE]:- java -jar GenericFileParserMainApplication.jar file=foo.zzz path=C:\\\\Data encoding=UTF8 compression=gzip encryption=AES128");
            System.out.println("[NOTE] :- File name and path is mandatory");
            System.out.println("Supported encoding format:-     [" + UTF_8_FORMAT + "," + ISO_FORMAT + "]");
            System.out.println("Supported Compression format:-  [" + B_ZIP + "," + ZIP + "," + BZ + "," + G_ZIP + "]");
            System.out.println("Supported Encryption format:-   [" + AES_128 + "," + AES_256 + "," + RSA + "]");
            return null;
        }
        FileClassLoader javaClassLoader = new FileClassLoader();
        String fileName = null;
        String filePath = null;
        Compressor compressor = null;
        Encryptor encryptor = null;
        Encoder encoder = null;
        for (int i = 0; i < args.length; i++) {
            if (args[i].contains("file="))
                fileName = args[i].split("=")[1];
            if (args[i].contains("path="))
                filePath = args[i].split("=")[1];
            else if (args[i].contains("compression="))
                compressor = (Compressor) javaClassLoader.invokeClassMethod("com.generic.file.parser.CompressorFactory", "createInstance", args[i].split("=")[1]);
            else if (args[i].contains("encryption="))
                encryptor = (Encryptor) javaClassLoader.invokeClassMethod("com.generic.file.parser.EncryptorFactory", "createInstance", args[i].split("=")[1]);
            else if (args[i].contains("encoding="))
                encoder = (Encoder) javaClassLoader.invokeClassMethod("com.generic.file.parser.EncoderFactory", "createInstance", args[i].split("=")[1]);

        }
        if (Objects.isNull(fileName) || fileName.isEmpty()) {
            System.out.println("[ERROR] :- Please enter filename :- eg:- file=fileName.txt");
            return null;
        }
        if (Objects.isNull(filePath) || filePath.isEmpty()) {
            System.out.println("[ERROR] :- Please enter filepath :- eg:- path=C:\\Data");
            return null;
        }


        if (Objects.isNull(encoder))
            encoder = (Encoder) javaClassLoader.invokeClassMethod("com.generic.file.parser.EncoderFactory", "createInstance", UTF_8_FORMAT);

        CSVFileParserProcessor csvFileParserProcessor = new CSVFileParserProcessor();
        return csvFileParserProcessor.getParser(fileName, filePath, compressor, encryptor, encoder);
    }
}
