package com.generic.file.parser.parser.processor;

import com.generic.file.parser.compressor.Compressor;
import com.generic.file.parser.encoder.Encoder;
import com.generic.file.parser.encryptor.Encryptor;
import com.generic.file.parser.parser.CSVFileParser;
import com.generic.file.parser.parser.Parser;

public class CSVFileParserProcessor implements Parser<CSVFileParser> {
    @Override
    public CSVFileParser getParser(String fileName, String filePath, Compressor compressor, Encryptor encryptor, Encoder encoder) {
        return CSVFileParser.Builder.newInstance(fileName, filePath)
                .withCompressor(compressor)
                .withEncoder(encoder)
                .withEncryptor(encryptor)
                .build();
    }
}
