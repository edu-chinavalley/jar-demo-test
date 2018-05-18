package com.chinavalley.demo.commondigester3;

import java.util.ArrayList;

/**
 * @author: polfdark
 */
public class Reader {
    private  String name;
    private  ArrayList books  =   new ArrayList();

    public   void  setName(String name) {
        this .name  =  name;
    }
    public  String getName() {
        return   this .name;
    }
    public   void  addBook(Book book) {
        this .books.add(book);
    }
    public  ArrayList getBooks() {
        return   this .books;
    }

}
