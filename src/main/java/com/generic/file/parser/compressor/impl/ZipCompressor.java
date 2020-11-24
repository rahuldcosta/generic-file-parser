package com.generic.file.parser.compressor.impl;

import com.generic.file.parser.compressor.Compressor;

public class ZipCompressor  implements Compressor {
    public void compress(String fileName) {
        System.out.println("File:- "+fileName+" compressed to zip format:- "+fileName+".zip");
    }

    public void deCompress(String fileName) {
        System.out.println("File:- "+fileName+" De-Compressed from zip format");
    }
}
