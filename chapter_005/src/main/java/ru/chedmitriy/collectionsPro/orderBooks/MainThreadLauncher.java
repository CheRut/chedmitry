package ru.chedmitriy.collectionsPro.orderBooks;

import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import ru.chedmitriy.collections.modifiingTracker.objects.ConsoleInput;
import ru.chedmitriy.collectionsPro.service.Settings;


import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;
import java.util.*;

/**
 * Главный класс
 * @author - cheDmitry
 * @since 16.09.2017
 * @version - 1.0
 *//**
 * Created by dimsan on 16.09.17.
 */
public class MainThreadLauncher {

    /**
     *В качестве обработчика файла,выбираем
     *@see SAXParserFactory
     */
    private final SAXParserFactory factory;

    /**
     * непосредтвенно,парсер
     */
    private SAXParser saxParser = null;
    /**
     *  Получаем дотуп к файлу конфигурации
     */
    private Settings set;
    /**
     * экземпляр класса
     * -наследника DefaultHandler
     * для поиска аттрибутов тэга <AddOrder> </AddOrder>
     */
    private final AddOrderTags addOrderTags;
    /**
     * экземпляр класса
     * -наследника DefaultHandler
     * для поиска аттрибутов тэга <DeleteOrder> </DeleteOrder>
     */
    private final DelOrderTags delOrderTags;
    /**
     *Список всех книг,соответствующих
     * заказам
     */
    private final List<Book> bookList;
    /**
     * Конструктор,задающий начальное состояние
     * для экземпляра класса SAXParser - factory;
     * обработчика <AddOrder></AddOrder> тэга
     * обработчика <DeleteOrder></DeleteOrder> тэга,
     * а такжк инициализуруют bookList
     *
     */
    private MainThreadLauncher() {
        this.factory = SAXParserFactory.newInstance();
        this.addOrderTags = new AddOrderTags();
        this.delOrderTags = new DelOrderTags();
        this.bookList = new ArrayList<>();

    }
    /**
     * Метод обращаетя в файл конфигурации
     * и возвращает путь к файлу типа String
     * @return - путь,соответствующий
     * запрашиваемому значению
     */
    private String getPath(){
        set = new Settings();
        set.load();
        return set.getValue("sourceFile");
    }
    /**
     * метод парсит
     * файл по соответствующим тэгам
     */
    private void xmlReader(){
        try {
            saxParser = factory.newSAXParser();
            XMLReader xmlReader = saxParser.getXMLReader();
            xmlReader.setContentHandler(addOrderTags);
            xmlReader.parse((getPath()));
            xmlReader.setContentHandler(delOrderTags);
            xmlReader.parse((getPath()));
        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
    }
    /**
     * метод добавляет
     * в каждую книгу списки
     * ордеров на покупку
     * и продажу
     * алгоритм работы метода:
     * в картах ищутся значения по ключу-цене,переданному
     * в параметрах метода, а значения инкрементируются
     * @param map - список покупок или продаж
     * @param order - искомый заказ
     */
    private void add(final Map<Float, Order> map, Order order) {
        Order findOrder = map.get(order.getPrice());
        if (findOrder != null) {
            map.put(findOrder.getPrice(), new Order(findOrder.getName(), findOrder.getOperation(), findOrder.getPrice(), findOrder.getVolume() +
                    order.getVolume(), findOrder.getId()));
        } else {
            map.put(order.getPrice(), order);
        }
    }
    /**
     * метод получает множество уникальных названий книг
     * и добавляет их в список
     * @return - список уникальных имен
     */
    private List<String> typesOfBooks(){
        Set<String> names = new TreeSet<>();
        for(Order order:addOrderTags.getOrders().values()){
            names.add(order.getName());
        }
        return new ArrayList<>(names);
    }

    /**
     *из списков добавленных ордеров  исключаем
     * списки удаленных ордеров
     */
    private void delete() {
        addOrderTags.getOrders().keySet().removeAll(delOrderTags.getDelOrderList());
    }
    /**
     * В данном методе ордера соответтвующих
     * книг сортируютя по
     * покупке и продаже, в соответствии
     * с уловием сортировки
     * далее проверяем сделки,
     * согласно условию задачи
     */
    private void sortByOperations(){
        delete();
        for (String name:typesOfBooks()){
            /*
     Экземпляр класса Book
     */
            Book book = new Book();
            book.setBookName(name);
            for (Order order:addOrderTags.getOrders().values()){
                if(order.getName().equals(name)){
                    this.add(order.getOperation().equals("BUY")? book.getBuy() : book.getSell(), order);
                }
            }
            bookList.add(book);

        }
        for(Book book:bookList){
            book.dealChecker(book);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ConsoleInput io = new ConsoleInput();
        long start = System.nanoTime();
        MainThreadLauncher mainThreadLauncher = new MainThreadLauncher();
        mainThreadLauncher.xmlReader();
        mainThreadLauncher.sortByOperations();
        long end = System.nanoTime()-start;
        double seconds = (double)end / 1000000000.0;
        io.outPrintln(String.format("time:\t\t\t%s",seconds));
    }


}