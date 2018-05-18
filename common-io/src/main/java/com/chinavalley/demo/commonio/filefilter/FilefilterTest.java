package com.chinavalley.demo.commonio.filefilter;

import org.apache.commons.io.filefilter.*;

import java.io.File;

/**
 * @author: polfdark
 * http://commons.apache.org/proper/commons-io/javadocs/api-release/index.html?org/apache/commons/io/filefilter/package-summary.html
 */
public class FilefilterTest {

    public static void main(String ...args){
        File dir = new File(".");
        String[] files = dir.list(
                new AndFileFilter(
                                new PrefixFileFilter("A"),
                                new OrFileFilter(
                                        new SuffixFileFilter(".class"),
                                        new SuffixFileFilter(".java")
                                )
                )
        );
        for ( int i=0; i<files.length; i++ ) {
            System.out.println(files[i]);
        }
    }
}
