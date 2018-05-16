package com.chinavalley.demo.commoncompress.factory;

import org.apache.commons.compress.compressors.CompressorInputStream;
import org.apache.commons.compress.compressors.CompressorOutputStream;
import org.apache.commons.compress.compressors.CompressorStreamFactory;

public class FactroyCreateTest {

    public static void main(String ...args){
        //通过已知的文件类型创建
        //CompressorOutputStream gzippedOut = new CompressorStreamFactory().createCompressorOutputStream(CompressorStreamFactory.GZIP,myOutputStream);
        //程序自行猜测文件类型
        //CompressorInputStream input = new CompressorStreamFactory().createCompressorInputStream(originalInput);

        //限制内存使用
        //CompressorOutputStream gzippedOut1 = new CompressorStreamFactory(true,8092).createCompressorOutputStream(CompressorStreamFactory.GZIP,myOutputStream);
    }
}
