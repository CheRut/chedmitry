package ru.chedmitriy.collectionsPro.testExercise;


import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by dimsan on 10.09.17.
 */
public class Order {
    private Book book;
    private String name;
    private Map <Float,Book> buyList;
    private Map <Float,Book> sellList;

    public Order(String name) {
        this.name = name;
        buyList = new TreeMap<>(BID);
        sellList = new TreeMap<>(ASK);
    }
    private static final Comparator<Float> BID = new Comparator<Float>(){
        int compare = 0;
        @Override
        public int compare(Float obj1,Float obj2){
            if(obj1.compareTo(obj2)>=0){
                compare = 1;
            }
            if(obj1.compareTo(obj2)<0){
                compare = -1;
            }
            return compare;
        }
    };
    private static final Comparator<Float> ASK = new Comparator<Float>() {
        int compare = 0;
        @Override
        public int compare(Float obj1,Float obj2){
            if(obj2.compareTo(obj1)>=0){
                compare = 1;
            }
            if(obj2.compareTo(obj1)<0){
                compare = -1;
            }
            return compare;
        }
    };
    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<Float, Book> getBuyList() {
        return buyList;
    }

    public void setBuyList(Map<Float, Book> buyList) {
        this.buyList = buyList;
    }

    public Map<Float, Book> getSellList() {
        return sellList;
    }

    public void setSellList(Map<Float, Book> sellList) {
        this.sellList = sellList;
    }
}
