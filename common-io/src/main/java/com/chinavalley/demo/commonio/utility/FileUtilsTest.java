package com.chinavalley.demo.commonio.utility;

import org.apache.commons.io.FileUtils;

import java.io.*;

public class FileUtilsTest {
    public static void main(String ...args){
        FileUtilsTest fut = new FileUtilsTest();
        fut.copyFileForOutputStream();
    }
    //复制目录
    public void copyDirectory(){
        File src = new File("");
        File dest = new File("");

        try {
            FileUtils.copyDirectory(src,dest);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //将源目录复制到目标目录下
    public void copyDirectoryToDirectory(){
        File src = new File("");
        File dest = new File("");

        try {
            FileUtils.copyDirectory(src,dest);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //复制文件
    public void copyFile(){
        File src = new File("");
        File dest = new File("");

        try {
            FileUtils.copyFile(src,dest);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //复制文件夹，带有文件过滤功能
    public void copyDirectoryByFileFilter() throws IOException {
        File src = new File("");
        File dest = new File("");

        FileUtils.copyDirectory(src, dest, new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                String fileName = pathname.getName();
                if(fileName.endsWith(".doc")){
                    return false;
                }else{
                    return true;
                }
            }
        });
    }
    //复制文件到流
    public void copyFileForOutputStream(){
        OutputStream ops = null;
        try {
            ops = new FileOutputStream("/data1/123456.jpg");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        File file = new File("/data1/12345.jpg");
        try {
            System.out.println(FileUtils.copyFile(file, ops));
        }catch(IOException e){
            e.printStackTrace();
        }finally {
            if(null != ops) {
                try {
                    ops.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    //复制文件到目录
    public void copyFileToDirectory(){
        File src = new File("");
        File dir = new File("");

        try {
            FileUtils.copyFileToDirectory(src,dir);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
