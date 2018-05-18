package com.chinavalley.demo.commoncompress.zip;

import org.apache.commons.compress.archivers.ArchiveEntry;
import org.apache.commons.compress.archivers.zip.Zip64Mode;
import org.apache.commons.compress.archivers.zip.ZipArchiveEntry;
import org.apache.commons.compress.archivers.zip.ZipArchiveInputStream;
import org.apache.commons.compress.archivers.zip.ZipArchiveOutputStream;

import java.io.*;

public class ZipTest {

    public static void main(String ...args){

    }

    //解压缩
    public void uncompress(String fileName,String path){
        File file = new File(fileName);
        InputStream is = null;
        ZipArchiveInputStream zais = null;
        try {
            is = new FileInputStream(file);
            zais = new ZipArchiveInputStream(is);
            ArchiveEntry archiveEntry = null;
            while((archiveEntry = zais.getNextEntry()) != null) {
                String entryFileName = archiveEntry.getName();
                byte[] content = new byte[(int) archiveEntry.getSize()];
                zais.read(content);
                OutputStream os = null;
                try {
                    //把解压出来的文件写到指定路径
                    File entryFile = new File(path + entryFileName);
                    os = new BufferedOutputStream(new FileOutputStream(entryFile));
                    os.write(content);
                }catch(IOException e) {
                    throw new IOException(e);
                }finally {
                    if(os != null) {
                        os.flush();
                        os.close();
                    }
                }

            }
        }catch(Exception e) {
            throw new RuntimeException(e);
        }finally {
            try {
                if(zais != null) {
                    zais.close();
                }
                if(is != null) {
                    is.close();
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    //压缩
    public void compress(File file,String zipFilePath){
        ZipArchiveOutputStream zaos = null;
        try {
            File zipFile = new File(zipFilePath);
            zaos = new ZipArchiveOutputStream(zipFile);
            //Always,AsNeeded,Never
            zaos.setUseZip64(Zip64Mode.AsNeeded);

            ZipArchiveEntry zipArchiveEntry  = new ZipArchiveEntry(file,file.getName());
            zaos.putArchiveEntry(zipArchiveEntry);
            InputStream is = null;
            try {
                is = new BufferedInputStream(new FileInputStream(file));
                byte[] buffer = new byte[1024 * 5];
                int len = -1;
                while((len = is.read(buffer)) != -1) {
                    zaos.write(buffer, 0, len);
                }
                zaos.closeArchiveEntry();
            }catch(Exception e) {
                throw new RuntimeException(e);
            }finally {
                if(is != null)
                    is.close();
            }
            zaos.finish();
        }catch(Exception e){
            throw new RuntimeException(e);
        }finally {
            try {
                if(zaos != null) {
                    zaos.close();
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
