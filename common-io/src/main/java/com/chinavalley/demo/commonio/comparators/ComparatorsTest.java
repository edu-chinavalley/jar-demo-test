package com.chinavalley.demo.commonio.comparators;

import org.apache.commons.io.comparator.CompositeFileComparator;
import org.apache.commons.io.comparator.DirectoryFileComparator;
import org.apache.commons.io.comparator.NameFileComparator;
import org.apache.commons.io.comparator.PathFileComparator;

import java.io.File;

/**
 * @author: polfdark
 */
public class ComparatorsTest {
    public static void main(String ...args){



    }
    public void nameComparators(){
        File f1 = new File("");
        File f2 = new File("");
        int result = NameFileComparator.NAME_COMPARATOR.compare(f1, f2);
        System.out.println(result);
    }


    public void pathComparators(){
        File f1 = new File("");
        File f2 = new File("");
        int result = PathFileComparator.PATH_COMPARATOR.compare(f1, f2);
        System.out.println(result);
    }

    public void compositeFileComparator(){
        File dir = new File("");
        File [] files = dir.listFiles();
        for (File file : files) {
            System.out.println(file.getName());
        }
        CompositeFileComparator cfc = new CompositeFileComparator(
                DirectoryFileComparator.DIRECTORY_COMPARATOR,
                NameFileComparator.NAME_COMPARATOR);
        cfc.sort(files);
        System.out.println("**after sort*");
        for (File file : files) {
            System.out.println(file.getName());
        }
    }
}
