package com.chinavalley.demo.commonio.lineiterator;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.LineIterator;

import java.io.File;
import java.io.IOException;

/**
 * @author: polfdark
 */
public class LineIteratorTest {

    public static void main(String ...args) throws IOException {
        File file = new File("");
        LineIterator it = FileUtils.lineIterator(file, "UTF-8");
        try {
            while (it.hasNext()) {
                String line = it.nextLine();
                /// do something with line
            }
        } finally {
            it.close();
        }

    }
}
