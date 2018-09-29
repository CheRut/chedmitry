package sqlJdbc.jdbc.optimization;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.sql.*;


/**
 * sqlJdbc.jdbc
 *
 * @author cheDmitry
 * @version 1.0
 * @since 09.12.2017
 */
public class JDBCOptimization {

    /**
     * файл логирования
     */
    private static final Logger log = LoggerFactory.getLogger(JDBCOptimization.class);
    /**
     * устанавливаем подключение
     */
    private Connection connection = null;

    XMLTransformation xTrans= new XMLTransformation();
    private final String dbName;

    /** в конструкторе определяем
     * подключение к базе данных sqlite
     * @param dbName - название базы данных
     */
    public JDBCOptimization (String dbName) {
        this.dbName = dbName;
    }

    /**
     * подключаемся к базе sqlite
     * определяем имя базы
     * @param dbName - наименование
     *               подключаемой базы данных
     *
     * @return тип Connection  при успешном подключении
     * или null - при неудаче
     */
    public   Connection openConnection(String dbName) {
        try {
            Class.forName("org.sqlite.JDBC");
            String dbUrl = "jdbc:sqlite:"+dbName+".sqlite";
            connection = DriverManager.getConnection(dbUrl);
            return connection;
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return null;
        }
    }

    public void makeSQl(String dbName, String sql,PreparedStatement pst) {
        openConnection(dbName);
        try {
            pst = connection.prepareStatement(sql);
            pst.execute();
        } catch (SQLException e) {
            log.error(e.getMessage(), e);
        }

    }
    public PreparedStatement getStatment(String sql) throws SQLException {
        return connection.prepareStatement(sql);
    }
    /**
     * создаем таблицу
     * с единственным полем FIELD
     */
    public void createTable() {
        PreparedStatement pst = null;
        String sql = "create table if not exists TEST(FIELD) ";
        makeSQl(this.dbName, sql, pst);
    }

    /**
     * очищаем таблицу
     */
    public void clearTable() {
        PreparedStatement pst = null;
        String sql = "DELETE FROM TEST";
        makeSQl(this.dbName, sql,pst);

    }

    /**
     * заполняем табицу значениями 1..n
     * @param n - количество элементов
     */
    public void fillData(int n) {
        PreparedStatement pst = null;
        String sql = "insert into TEST(field) VALUES (?)";
        try {
            connection.setAutoCommit(false);
            pst = getStatment(sql);
            for (int j = 1; j <= n ; j++) {
                pst.setInt(1,j);
                pst.execute();
            }
            connection.commit();
            pst.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    /** создаем документ XML формата и
     * сразу же делаем преобразование
     * XML-XML
     * @see XMLTransformation#transformXML(Document, String)
     * @param docName - название файла
     */
    public void xmlCreator(String docName) {
        PreparedStatement pst = null;
        String sql = "SELECT * FROM test ";
        ResultSet rs = null;
        try {
            Document document = null;
            document = DocumentBuilderFactory.newInstance()
                    .newDocumentBuilder().newDocument();
            Element entries = document.createElement("entries");
            document.appendChild(entries);
            try {
                pst = getStatment(sql);
                rs = pst.executeQuery();
                while (rs.next()) {

                    Element entry = document.createElement("entry");
                    entries.appendChild(entry);
                    Element field = document.createElement("field");
                    field.setTextContent(String.valueOf(rs.getString(1)));
                    entry.appendChild(field);
                }
                rs.close();
                pst.close();

            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                if (connection != null) {
                    try {
                        connection.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            }
            xTrans.transformXML(document, docName);
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) throws IOException,
            SAXException, ParserConfigurationException {
        String templ = "chapter_007/source/template.xsl";
        String source = "chapter_007/source/1.xml";
        String output = "chapter_007/source/2.xml";
        JDBCOptimization j = new JDBCOptimization("chapter_007/source/TEST");
        XMLTransformation xmlTransformation = new XMLTransformation();
        XmlPars xmlPars = new XmlPars();
        long start = System.nanoTime();
        j.createTable();
        j.clearTable();
        j.fillData(100);
        j.xmlCreator(source);
        xmlTransformation.applyTransform(templ,source,output);
        xmlPars.parser(output);
        System.out.print(String.format(
                "\t Время,затраченное на операцию: %s ",
                (double)(System.nanoTime() - start)/1000000000.0));
    }

}
