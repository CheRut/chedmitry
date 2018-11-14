package ru.chedmitriy.jdbc;

import org.w3c.dom.Document;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.File;

/**
 * ru.chedmitriy.jdbc
 *
 * @author cheDmitry
 * @version 1.0
 * @since 11.12.2017
 * определяет новый
 * формат XML файла, полученного
 * из базы данных
 */
public class XMLTransformation {

    /**
     * преобразует файл, полученный из
     * базы данных к новому виду,
     * описанному в шаблоне
     * @param template - шаблон
     * @param source - исходный фйл
     * @param output - полученный файл
     */
    public  void applyTransform(String template, String source, String output) {
        try {
            TransformerFactory tf = TransformerFactory.newInstance();
            Transformer transformer = tf.newTransformer(new StreamSource(template));
            transformer.transform(
                    new StreamSource(source),
                    new StreamResult(output));
        } catch (TransformerException e) {
            e.printStackTrace();
        }
    }

    /**
     * преобразуем объект document.
     * к xml файлу.
     * @param document документ
     * @param docName - имя файла.
     */

    public void transformXML(Document document, String docName) {
        try {
            Transformer transformer = TransformerFactory.newInstance()
                    .newTransformer();
            DOMSource source = new DOMSource(document);
            StreamResult result = new StreamResult(
                    new File(docName));
            transformer.transform(source, result);
        } catch (TransformerException e) {
            e.printStackTrace();
        }
    }
}
