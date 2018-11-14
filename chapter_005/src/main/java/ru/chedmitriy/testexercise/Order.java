package ru.chedmitriy.testexercise;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by dimsan on 10.09.17.
 */
public class Order {
    private Book book;
    private String name;
    public ArrayList<Book> orders;
    public Map<Float, Book> buyList;
    public Map<Float, Book> sellList;

    public Order(String name) {
        this.book = new Book();
        this.name = name;
        this.orders = new ArrayList<>();
        buyList = new TreeMap<>(BID_COMPARATOR);
        sellList = new TreeMap<>(ASK_COMPARATOR);
    }

    private static final Comparator<Float> BID_COMPARATOR = new Comparator<Float>() {
        int compare = 0;
        @Override
        public int compare(Float obj1, Float obj2) {
            if (obj1.compareTo(obj2) >= 0) {
                compare = 1;
            }
            if (obj1.compareTo(obj2) < 0) {
                compare = -1;
            }
            return compare;
        }
    };
    private static final Comparator<Float> ASK_COMPARATOR = new Comparator<Float>() {
        int compare = 0;
        @Override
        public int compare(Float obj1, Float obj2) {
            if (obj2.compareTo(obj1) >= 0) {
                compare = 1;
            }
            if (obj2.compareTo(obj1) < 0) {
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

    public void add(final Map<Float, Book> map, Book book) {
        Book temp = map.get(book);
        System.out.println(temp.getBookName());
        if (temp != null) {

            map.put(book.getPrice(), new Book(book.getBookName(), book.getOperation(), book.getPrice(), book.getVolume()
                    + temp.getVolume(),  book.getId()));
        } else {
            map.put(temp.getPrice(), temp);
        }

    }

}
