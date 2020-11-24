package com.generic.file.parser.compressor.impl;

import com.generic.file.parser.compressor.Compressor;

public class BzipCompressor implements Compressor {
    public void compress(String fileName) {
        System.out.println("File:- "+fileName+" compressed to bzip format:- "+fileName+".bzip");
    }

    public void deCompress(String fileName) {
        System.out.println("File:- "+fileName+" De-Compressed from bzip format");
    }
}
