package ru.chedmitriy.collectionsPro.testExercise;

import java.util.*;

/**
 * Created by dimsan on 29.08.17.
 */
public class Book {
    private String bookName;
    private String operation;
    private Float price;
    private int volume;
    private String id;


    public Book() {

    }


    public Book(String bookName, String id) {
        this.bookName = bookName;
        this.id = id;
    }

    public Book(String bookName, List<String> bidList, List<String> askList) {
        this.bookName = bookName;

    }

    public Book(String bookName, String operation, Float price, int volume) {
        this.bookName = bookName;
        this.operation = operation;
        this.price = price;
        this.volume = volume;
    }

    public Book(String bookName, String operation, Float price, int volume, String id) {
        this.bookName = bookName;
        this.operation = operation;
        this.price = price;
        this.volume = volume;
        this.id = id;
    }




    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }





    @Override
    public String toString() {
        return " Book name: " + this.bookName +
                "\n" + this.volume +
                "@" + this.price+"\n"+
                "id "+this.id+"\n";
    }




    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o instanceof Book) {
            Book node = (Book) o;
            return (
                    Objects.equals(bookName, node.getBookName()) &&
                            Objects.equals(price, node.getPrice()) &&
                            Objects.equals(volume,node.getVolume()) &&
                            Objects.equals(id,node.getId())&&
                            Objects.equals(hashCode(),node.hashCode()));
        }
        return false;
    }

    @Override
    public int hashCode() {
       int hash = 31;
        hash = hash * 17 + price.hashCode()+id.hashCode();

        return hash;
    }



}
