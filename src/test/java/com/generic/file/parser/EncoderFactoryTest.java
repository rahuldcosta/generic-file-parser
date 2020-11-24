package com.generic.file.parser;

import com.generic.file.parser.encoder.impl.ISOCharacterEncoder;
import com.generic.file.parser.encoder.impl.UTFCharacterEncoder;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.generic.file.parser.constants.FileParserConstants.ISO_FORMAT;
import static com.generic.file.parser.constants.FileParserConstants.UTF_8_FORMAT;

public class EncoderFactoryTest {

    EncoderFactory encoderFactory = new EncoderFactory();
    @Test
    public void testCreateInstanceUTF() {
        Assert.assertTrue(encoderFactory.createInstance(UTF_8_FORMAT) instanceof UTFCharacterEncoder);
    }
    @Test
    public void testCreateInstanceISO() {
        Assert.assertTrue(encoderFactory.createInstance(ISO_FORMAT) instanceof ISOCharacterEncoder);
    }

}
