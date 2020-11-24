package com.generic.file.parser.parser;

import com.generic.file.parser.compressor.Compressor;
import com.generic.file.parser.encoder.Encoder;
import com.generic.file.parser.encryptor.Encryptor;

import java.io.UnsupportedEncodingException;
import java.util.Objects;

import static com.generic.file.parser.constants.FileParserConstants.UTF_8_FORMAT;

public class CSVFileParser {

    private final Encoder encoder;
    private final Encryptor encryptor;
    private final Compressor compressor;
    private final String fileName;
    private final String filePath;

    public CSVFileParser(Builder builder) {
        this.encoder = builder.encoder;
        this.encryptor = builder.encryptor;
        this.compressor = builder.compressor;
        this.fileName = builder.fileName;
        this.filePath = builder.filePath;
    }

    public static class Builder {
        private Encoder encoder;
        private Encryptor encryptor;
        private Compressor compressor;
        private final String fileName;
        private final String filePath;

        private Builder(String fileName, String filePath) {
            this.fileName = fileName;
            this.filePath = filePath;
        }

        public static Builder newInstance(String fileName, String filePath) {
            return new Builder(fileName, filePath);
        }

        public Builder withEncoder(Encoder encoder) {
            this.encoder = encoder;
            return this;
        }

        public Builder withEncryptor(Encryptor encryptor) {
            this.encryptor = encryptor;
            return this;
        }

        public Builder withCompressor(Compressor compressor) {
            this.compressor = compressor;
            return this;
        }

        public CSVFileParser build() {
            return new CSVFileParser(this);
        }
    }

    private void readFileInChunks(int start, int end, String fileName) {
        System.out.println("*******************************");
        System.out.println("Reading file:-" + fileName + " in chunks start=" + start + " end=" + end);
    }

    private void writeFileInChunks(int start, int end, String fileName) {
        System.out.println("*******************************");
        System.out.println("Writing file:-" + fileName + " in chunks start=" + start + " end=" + end);
    }

    public void readFile(String[] args) throws UnsupportedEncodingException {
        int chunkSizeValue = 1000;
        int start = 1;
        int end = 0;
        for (int i = 0; i < args.length; i++) {
            end = start + chunkSizeValue;
            readFileInChunks(start, end, fileName);
            start = end;

            for (int j = 0; j < args.length; j++) {
                if (args[j].contains("compression=")) {
                    applyDecompression();
                } else if (args[j].contains("encryption=")) {
                    applyDencryption();
                } else if (args[j].contains("encoding=")) {
                    applyDecoding();
                }
            }
        }
    }

    private void applyDecoding() throws UnsupportedEncodingException {
        if (Objects.nonNull(encoder) && Objects.nonNull(fileName))
            encoder.decode(fileName.getBytes(UTF_8_FORMAT));
        else
            System.out.println("CharacterSet decoding Not Applied");
    }

    private void applyDencryption() {
        if (Objects.nonNull(encryptor))
            encryptor.decrypt(fileName);
        else
            System.out.println("Decryption Not Applied");
    }

    private void applyDecompression() {
        if (Objects.nonNull(compressor))
            compressor.deCompress(fileName);
        else
            System.out.println("Decompression Not Applied");
    }

    public void writeFile(String[] args) throws UnsupportedEncodingException {
        int chunkSizeValue = 1000;
        int start = 1;
        int end = 0;
        for (int i = 0; i < args.length; i++) {
            end = start + chunkSizeValue;
            writeFileInChunks(start, end, fileName);
            start = end;

            for (int j = 0; j < args.length; j++) {
                if (args[j].contains("compression=")) {
                    applyEncoding();
                } else if (args[j].contains("encryption=")) {
                    applyEncryption();
                } else if (args[j].contains("encoding=")) {
                    applyCompression();
                }
            }
        }
    }

    private void applyCompression() {
        if (Objects.nonNull(compressor))
            compressor.compress(fileName);
        else
            System.out.println("Compression Not Applied");
    }

    private void applyEncryption() {
        if (Objects.nonNull(encryptor))
            encryptor.encrypt(fileName);
        else
            System.out.println("Encryption Not Applied");
    }

    private void applyEncoding() throws UnsupportedEncodingException {
        if (Objects.nonNull(encoder) && Objects.nonNull(fileName))
            encoder.encode(fileName);
        else
            System.out.println("CharacterSet Encoding Not Applied");
    }


    public String getFileName() {
        return fileName;
    }

    public String getFilePath() {
        return filePath;
    }


}
