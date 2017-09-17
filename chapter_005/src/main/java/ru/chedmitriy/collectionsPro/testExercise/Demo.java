package ru.chedmitriy.collectionsPro.testExercise;

import org.w3c.dom.*;
import org.xml.sax.SAXException;
import ru.chedmitriy.collectionsPro.service.Settings;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by dimsan on 03.09.17.
 */
public class Demo {
    static List<Book> bookList;
    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {
        bookList = new ArrayList<>();
        Settings set = new Settings();
        set.load();
        try {
            // Создается построитель документа
            DocumentBuilder documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            // Создается дерево DOM документа из файла
            Document document = documentBuilder.parse(set.getValue("sourceFile"));

            // Получаем корневой элемент

            System.out.println("List of books:");
            System.out.println();
            // Просматриваем все подэлементы корневого - т.е. книги
            NodeList books = document.getElementsByTagName("AddOrder");
            for (int i = 0; i < books.getLength(); i++) {
                System.out.println(books.item(i).getAttributes().item(0).getNodeValue());
            }
        } catch (ParserConfigurationException ex) {
            ex.printStackTrace(System.out);
        } catch (SAXException ex) {
            ex.printStackTrace(System.out);
        } catch (IOException ex) {
            ex.printStackTrace(System.out);
        }
    }


}