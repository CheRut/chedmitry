package ru.chedmitriy.collectionsPro.orderBooks;


import ru.chedmitriy.collectionsPro.io.InputOutput;

import java.util.*;

/**
 * Класс,получающий заказы,в ссответствии
 * с типами книг,присутствующими
 * в файле
 * @author - cheDmitry
 * @since 16.09.2017
 * @version - 1.0
 */
class Book {
    private final InputOutput io;
    /**
     * Название книги
     */
    private String bookName;
    /**
     * карта ореров на покупку
     */
    private final Map<Float,Order> sell;
    /**
     * Карта ордеров на продажу
     */
    private final Map<Float,Order> buy;
    /**
     * Конструктор,инициализирующий
     * карты на покупку и продажу
     * для соответствующего типа книг
     * Данные карты сортируются
     * в соответствии с
     * условиями сортировки
     *
     */
    public Book() {
        io = new InputOutput();
        this.sell = new TreeMap<>(SELL);
        this.buy = new TreeMap<>(BUY);
    }
    /**
     * Компаратор сортировки по возрастанию для
     * ордеров на продажу
     */
    private final Comparator<Float>SELL = new Comparator<Float>() {
        @Override
        public int compare(Float o1, Float o2) {
            return o1.compareTo(o2);
        }
    };
    /**
     * компаратор сортировки
     * по убыванию для ордеров
     * на покупку
     */
    private static final Comparator<Float> BUY = new Comparator<Float>() {
        @Override
        public int compare(Float o1, Float o2) {
            return o2.compareTo(o1);
        }
    };
    /**
     * метод установки названия книг
     * @param bookName - название книги
     */
    public void setBookName(String bookName) {
        this.bookName = bookName;
    }
    /**
     * метод получения
     * назвавния книги
     * @return - название
     */
    private String getBookName() {
        return bookName;
    }
    /**
     * метод получения списков ордеров на продажу
     * @return - список ордеров
     */
    public Map<Float,Order> getSell() {
        return sell;
    }
    /**
     * метод получения списков ордеров на покупку
     * @return - список ордеров
     */
    public Map<Float,Order> getBuy() {
        return buy;
    }
    /**
     * метод проверяет сделки
     * в двух списках
     * в соответствии
     * с условием задачи
     * @param book - в качестве параметра передается
     *             книга.
     */
    public void dealChecker(Book book) {
        List<Order> buyList = new ArrayList<>(book.getBuy().values());
        List<Order> sellList = new ArrayList<>(book.getSell().values());
        List<Order> toClearBuyOrders = new ArrayList<>();
        List<Order> toClearSellOrders = new ArrayList<>();
        int size = buyList.size()>=sellList.size()?buyList.size():sellList.size();
        io.println(book.getBookName());
        for (int i = 0; i < size ; i++) {
            try {
                if (buyList.get(i).getPrice() < sellList.get(i).getPrice() && sellList.get(i) != null) {
                    io.println(String.format("%s \t\t%s",buyList.get(i).getVolume() + "@" + buyList.get(i).getPrice(),
                            sellList.get(i).getVolume() + "@" + sellList.get(i).getPrice()));
                }
                else {
                    toClearBuyOrders.add(buyList.get(i));
                    toClearSellOrders.add(sellList.get(i));
                }
            }catch (IndexOutOfBoundsException ind){
                io.println(String.format("%s \t\t%s","----------",
                       sellList.get(i).getVolume()+"@"+sellList.get(i).getPrice()));
            }
        }
    }
}
