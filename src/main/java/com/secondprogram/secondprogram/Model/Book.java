

package com.secondprogram.secondprogram.Model;

// Model Class --> Book Entity || Used to represent Book Object and its properties 
// Used in Service Layer and Controller Layer and for spring data binding

public class Book {
    private int id;
    private String title;
    private String author;
    public Book() {
    }

    public Book(int aInt, String string, String string0) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    public int getId() {
        return id;
    }
    public String getTitle() {
        return title;
    }   
    public String getAuthor() {
        return author;
    }
    public void setId(int id){
        this.id=id;
    }

    public void setTitle(String title){
        this.title=title;
    }
    public void setAuthor(String author){
        this.author=author;
    }
}
