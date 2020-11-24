package com.generic.file.parser.compressor.impl;

import com.generic.file.parser.compressor.Compressor;

public class GzipCompressor implements Compressor {
    public void compress(String fileName) {
        System.out.println("File:- "+fileName+" compressed to gzip format:- "+fileName+".gzip");
    }

    public void deCompress(String fileName) {
        System.out.println("File:- "+fileName+" De-Compressed from gzip format ");
    }
}
