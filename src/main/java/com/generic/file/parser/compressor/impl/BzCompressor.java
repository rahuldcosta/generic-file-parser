package com.generic.file.parser.compressor.impl;

import com.generic.file.parser.compressor.Compressor;

public class BzCompressor implements Compressor {
    public void compress(String fileName) {
        System.out.println("File:- "+fileName+" compressed to bz format:- "+fileName+".bz");
    }

    public void deCompress(String fileName) {
        System.out.println("File:- "+fileName+" De-Compressed from bz format");
    }
}
