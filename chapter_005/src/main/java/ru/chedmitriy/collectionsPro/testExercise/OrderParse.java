package ru.chedmitriy.collectionsPro.testExercise;





import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;
import ru.chedmitriy.collectionsPro.service.Settings;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;
import java.util.*;

/**
 * Created by dimsan on 29.08.17.
 */
public class OrderParse extends DefaultHandler  {
    static final String ADDORDER_TAG = "AddOrder";
    static final String DELETEORDER_TAG = "DeleteOrder";

    static final String BOOK_NAME_Attr = "book";
    static final String OPER_Attr = "operation";
    static final String PRICE_Attr = "price";
    static final String VOLUME_Attr = "volume";
    static final String ID_Attr = "orderId";
    static Book book;

    static Map<Integer,Book> addOrderList = new Hashtable<>();


    static Queue<Integer> delOrderList = new LinkedList<Integer>();
    static Map<String,Map<Map<Float,Book>,Map<Float,Book>>> ordersByBookName;
    static Map<String,Order> allOrders =new Hashtable<>();
    // static List<Book> addOrderList = new LinkedList<>();
    static Set<String> names;
    static int index = 0;
    private String currentElement;

    public OrderParse() {
        this.book = new Book();
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {

        currentElement = qName;
        if(currentElement.equals(ADDORDER_TAG)){
            addOrder(attributes);
        }
        else if(currentElement.equals(DELETEORDER_TAG)){
            delOrderList.add(Integer.valueOf(attributes.getValue(ID_Attr)));
        }

    }
    public static void  addOrder(Attributes at){
        book = new Book();
        book.setBookName(at.getValue(BOOK_NAME_Attr));
        book.setOperation(at.getValue(OPER_Attr));
        book.setPrice(Float.valueOf(at.getValue(PRICE_Attr)));
        book.setVolume(Integer.valueOf(at.getValue(VOLUME_Attr)));
        book.setId(at.getValue(ID_Attr));

        addOrderList.put(Integer.valueOf(book.getId()), book);

    }
    public static List<String> names(){
        Set<String> getNames = new TreeSet<>();
        for(Book o:addOrderList.values()){
            getNames.add(o.getBookName());
        }

        return new ArrayList<>(getNames);
    }


    public static void sortBidAsk(){

        for (String name:names()) {
            Order order = new Order(name);
            for (Book book : addOrderList.values()) {
                if (book != null && book.getBookName().equals(name)) {
                    if (book.getOperation().equals("BUY")) {
                       order.getBuyList().put(book.getPrice(), book);
                    } else if (book.getOperation().equals("SELL")) {
                        order.getSellList().put(book.getPrice(), book);
                    }

                }

            }

            allOrders.put(name,order);

              // System.out.println(allOrders.get("book-1").getBuyList().values());
           }

    }

    public static void removeOrders(){

        addOrderList.keySet().removeAll(delOrderList);


        sortBidAsk();
    }






    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {

        OrderParse orderParse = new OrderParse();
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser saxParser = factory.newSAXParser();
        XMLReader xmlReader= saxParser.getXMLReader();

        xmlReader.setContentHandler(orderParse);
        Settings set = new Settings();
        set.load();
        long start = System.nanoTime();
        System.out.println("start");
        xmlReader.parse(set.getValue("sourceFile"));
        removeOrders();

        long end = System.nanoTime()-start;
        double seconds = (double)end / 1000000000.0;
        System.out.println(seconds);
        //biAskFill();
        System.out.println("finish");

    }
}
