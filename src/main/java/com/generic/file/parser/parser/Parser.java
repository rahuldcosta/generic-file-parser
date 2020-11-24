package com.generic.file.parser.parser;

import com.generic.file.parser.compressor.Compressor;
import com.generic.file.parser.encoder.Encoder;
import com.generic.file.parser.encryptor.Encryptor;

public interface Parser<T> {
    public T getParser(String fileName, String filePath, Compressor compressor, Encryptor encryptor, Encoder encoder);
}
