package ru.chedmitriy.collectionsPro.orderBooks;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.*;

/**
 * Класс,
 * Заказы из файла по тегу
 * <AddOrder></AddOrder>
 *
 * @author - cheDmitry
 * @since 16.09.2017
 * @version - 1.0
 */
public class AddOrderTags extends DefaultHandler  {
    /**
     * перечисляемые аттрибуты
     */
    enum ADDTAGATTRIBUTES {
        AddOrder,book,operation,price,volume,orderId
    }
    /**
     * карта заказов
     */
    private final Map<Integer,Order> orders;
    /**
     * Конструктор,в котором
     * инициализируется
     * карта orders
     */
    public AddOrderTags() {
        this.orders = new TreeMap<>();
    }
    /** в этом методе,при обращении
     * к данному классу
     * происходит поиск атрибутов
     * @param uri
     * @param localName
     * @param qName - поиск по имени
     * @param attributes
     * @throws SAXException
     */
    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if(qName.equals(ADDTAGATTRIBUTES.AddOrder.toString())){
            addOrder(attributes);
        }
    }
    /**
     * метод добавляет новые
     * заказы в карту orders
     * @param at - аттрибут
     */
    private void  addOrder(Attributes at){
        orders.put(Integer.valueOf(at.getValue(ADDTAGATTRIBUTES.orderId.toString())),
                new Order(at.getValue(ADDTAGATTRIBUTES.book.toString()),
                        at.getValue(ADDTAGATTRIBUTES.operation.toString()),
                        Float.valueOf(at.getValue(ADDTAGATTRIBUTES.price.toString())),
                        Integer.valueOf(at.getValue(ADDTAGATTRIBUTES.volume.toString())),
                        Integer.valueOf(at.getValue(ADDTAGATTRIBUTES.orderId.toString()))
                ));
    }
    /**
     * получаем карту orders
     * @return map<Integer,Order>
     * */
    public Map<Integer, Order> getOrders() {
        return orders;
    }
}
