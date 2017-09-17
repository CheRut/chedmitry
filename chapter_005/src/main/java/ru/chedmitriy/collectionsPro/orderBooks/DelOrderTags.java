package ru.chedmitriy.collectionsPro.orderBooks;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;


import java.util.*;

/**
 * Класс,
 * Заказы из файла по тегу
 * <DeleteOrder></DeleteOrder> *
 * @author - cheDmitry
 * @since 16.09.2017
 * @version - 1.0
 */
public class DelOrderTags extends DefaultHandler {
    /**
     * перечисляемые аттрибуты
     */
    enum DELTAGATTRIBUTES {
        DeleteOrder,orderId
    }
    /**
     * список id удаленных сделок
     */
    private final Queue<Integer> delOrderList;

    /**
     * конструкор,где
     * инициализируем список
     * удаленных сделок
     */
    public DelOrderTags() {
        delOrderList = new LinkedList<>();
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
       if(qName.equals(DELTAGATTRIBUTES.DeleteOrder.toString())){
            delOrderList.add(Integer.valueOf(attributes.getValue(DELTAGATTRIBUTES.orderId.toString())));
        }
    }
    /**
     * Получаем очередь id
     * @return список чиел id
     */
    public Queue<Integer> getDelOrderList() {
        return delOrderList;
    }

}

