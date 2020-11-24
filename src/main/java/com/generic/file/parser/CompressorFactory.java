package com.generic.file.parser;

import com.generic.file.parser.compressor.Compressor;
import com.generic.file.parser.compressor.impl.BzCompressor;
import com.generic.file.parser.compressor.impl.BzipCompressor;
import com.generic.file.parser.compressor.impl.GzipCompressor;
import com.generic.file.parser.compressor.impl.ZipCompressor;

import static com.generic.file.parser.constants.FileParserConstants.*;

public class CompressorFactory {

    public Compressor createInstance(String type) {

        switch (type) {
            case B_ZIP:
                return new BzipCompressor();
            case BZ:
                return new BzCompressor();
            case G_ZIP:
                return new GzipCompressor();
            case ZIP:
                return new ZipCompressor();
            default:
                return null;
        }
    }
}
