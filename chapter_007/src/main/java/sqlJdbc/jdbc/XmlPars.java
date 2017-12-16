package sqlJdbc.jdbc;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;

/**
 * sqlJdbc.jdbc
 *
 * @author cheDmitry
 * @version 1.0
 * @since 11.12.2017
 * получаем значения из
 * полученнрго файла и проводим опрецию сложения всех чичел
 */
public class XmlPars extends DefaultHandler {

    /**
     * наименование тега
     */
    private final String tagName = "entry";

    /**
     * наименование аттрибута
     */
    private final String attribute = "field";

    /**
     * значение тэга
     */
    private String currentElement;

    /**
     * значение суммы всех чисел.
     */
    private static long result = 0;

    @Override
    public void startElement(String uri, String localName,
                             String qName, Attributes attributes) throws SAXException {

        currentElement = qName;
        if(currentElement.equals(tagName)) {
           counter(attributes);
        }
    }

    /**
     * счетчик суммы всех чисел.
     * @param attributes - складываемые значения
     *
     * @return - полученная сумма
     */
    public long  counter(Attributes attributes) {
        result += (Integer.valueOf(attributes.getValue(attribute)));
        return result;
    }

    /**
     * метод запускает парсер
     * переданного в параметрах файла
     * @param fileName - файл,который парсится
     *
     * @throws ParserConfigurationException
     * @throws SAXException
     * @throws IOException
     */
    public void parser(String fileName) throws ParserConfigurationException,
            SAXException, IOException {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser saxParser = factory.newSAXParser();
        XMLReader xmlReader = saxParser.getXMLReader();
        xmlReader.setContentHandler(new XmlPars());
        xmlReader.parse(fileName);
        System.out.print (String.format("\t Полученная сумма: %s;\n",result));
    }


}
