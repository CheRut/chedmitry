package ru.chedmitriy.testexercise;





import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;
import ru.chedmitriy.service.Settings;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;
import java.util.*;

/**
 * Created by dimsan on 29.08.17.
 */
public class OrderParse extends DefaultHandler  {
    static final String ADD_ORDER = "AddOrder";
    static final String DELETE_ORDER = "DeleteOrder";

    static final String BOOK_NAME_ATTR = "book";
    static final String OPERATION_ATTR = "operation";
    static final String PRICE_ATTR = "price";
    static final String VOLUME_ATTR = "volume";
    static final String ID_ATTR = "orderId";
    static Book book;

    static Map<Integer, Book> addOrderList = new Hashtable<>();


    static Queue<Integer> delOrderList = new LinkedList<Integer>();
    static Map<String, Map<Map<Float, Book>, Map<Float, Book>>> ordersByBookName;
    static Map<String, Order> allOrders = new Hashtable<>();

    static Set<String> names;
    static int index = 0;
    private String currentElement;
    private static List<Order> orders;

    public OrderParse() {
        this.book = new Book();
        this.orders = new ArrayList<>();
    }

    @Override
    public void startElement(String uri, String localName,
                             String qName,
                             Attributes attributes) throws SAXException {

        currentElement = qName;
        if (currentElement.equals(ADD_ORDER)) {
            addOrder(attributes);
        } else if (currentElement.equals(DELETE_ORDER)) {
            delOrderList.add(Integer.valueOf(attributes.getValue(ID_ATTR)));
        }

    }
    public static void  addOrder(Attributes at) {
        book = new Book();
        book.setBookName(at.getValue(BOOK_NAME_ATTR));
        book.setOperation(at.getValue(OPERATION_ATTR));
        book.setPrice(Float.valueOf(at.getValue(PRICE_ATTR)));
        book.setVolume(Integer.valueOf(at.getValue(VOLUME_ATTR)));
        book.setId(at.getValue(ID_ATTR));

        addOrderList.put(Integer.valueOf(book.getId()), book);

    }
    public static List<String> names() {
        Set<String> getNames = new TreeSet<>();
        for (Book o:addOrderList.values()) {
            getNames.add(o.getBookName());
        }

        return new ArrayList<>(getNames);
    }


    public static void sortBidAsk() {
        Order order;
        for (String name:names()) {
           order = new Order(name);
            for (Book book : addOrderList.values()) {
                if (book != null && book.getBookName().equals(name)) {

                    order.add(book.getOperation().equals("BUY")
                            ? order.buyList : order.sellList, book);
                }
            }
            orders.add(order);
            for (Order o : orders) {
                System.out.println(o);
            }
        }
    }

    public static void removeOrders() {
        addOrderList.keySet().removeAll(delOrderList);
        sortBidAsk();
    }

    public static void main(String[] args)
            throws ParserConfigurationException, SAXException, IOException {
        OrderParse orderParse = new OrderParse();
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser saxParser = factory.newSAXParser();
        XMLReader xmlReader = saxParser.getXMLReader();
        xmlReader.setContentHandler(orderParse);
        Settings set = new Settings();
        set.load();
        long start = System.nanoTime();
        System.out.println("start");
        xmlReader.parse(set.getValue("sourceFile"));
        removeOrders();
        long end = System.nanoTime() - start;
        double seconds = (double) end / 1000000000.0;
        System.out.println(seconds);
        System.out.println("finish");

    }
}
