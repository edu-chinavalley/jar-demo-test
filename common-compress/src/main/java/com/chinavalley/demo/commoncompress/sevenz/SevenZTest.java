package com.chinavalley.demo.commoncompress.sevenz;

import org.apache.commons.compress.archivers.sevenz.SevenZArchiveEntry;
import org.apache.commons.compress.archivers.sevenz.SevenZFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class SevenZTest {
    public static void main(String ...args) throws IOException {

        // 解压7z文件 方式1
        String outputDir = "";
        int bufferEdSize = 8092;
        try{
            SevenZFile sevenZFile = new SevenZFile(new File("archive.7z"));
            SevenZArchiveEntry entry = null;

            while((entry = sevenZFile.getNextEntry()) != null){
                if (entry.isDirectory()) {
                    //createDirectory(outputDir, entry.getName());
                }else{
                    File tmpFile = new File(outputDir + File.separator
                            + entry.getName());
                    //createDirectory(tmpFile.getParent() + File.separator, null);
                    OutputStream out = null;
                    try{
                        out = new FileOutputStream(tmpFile);
                        int length = 0;
                        byte[] b = new byte[bufferEdSize];

                        while((length = sevenZFile.read(b)) != -1){
                            out.write(b,0,length);
                        }
                    }catch(IOException ex){
                        throw ex;
                    }finally{
                        if (out != null)
                            out.close();
                    }
                }
            }
        }catch (Exception ex){
            System.err.println(ex.toString());
        }
    }

    // TODO: 2018/5/17 补充7Z解压缩方法 添加方法
}
