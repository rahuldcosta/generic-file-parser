package com.generic.file.parser;

import com.generic.file.parser.encoder.Encoder;
import com.generic.file.parser.encoder.impl.ISOCharacterEncoder;
import com.generic.file.parser.encoder.impl.UTFCharacterEncoder;

import static com.generic.file.parser.constants.FileParserConstants.ISO_FORMAT;
import static com.generic.file.parser.constants.FileParserConstants.UTF_8_FORMAT;

public class EncoderFactory {

    public Encoder createInstance(String type) {

        switch (type) {
            case ISO_FORMAT:
                return new ISOCharacterEncoder();
            case UTF_8_FORMAT:
                return new UTFCharacterEncoder();
            default:
                return null;
        }
    }
}
