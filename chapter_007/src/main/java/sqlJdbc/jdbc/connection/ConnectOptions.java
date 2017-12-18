package sqlJdbc.jdbc.connection;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;

/**
 * sqlJdbc.jdbc.connection
 *
 * @author cheDmitry
 * @version 1.0
 * @since 09.12.2017
 *
 * определяем подключения
 * для двух типов
 * баз данных:Postgres и SQLite.
 */
public class ConnectOptions {

    /**
     * файл логирования
     */
    private static final Logger log = LoggerFactory.getLogger(ConnectOptions.class);
    /**
     * создаем параметр для подключения к базе данных
     */
    private  Connection open;

    /**
     * подключаемся к базе sqlite
     * определяем имя базы
     * @param dbName - наименование
     *               подключаемой базы данных
     *
     * @return тип Connection  при успешном подключении
     * или null - при неудаче
     */
    public   Connection connect_SQLite_Db(String dbName) {
        try {
            Class.forName("org.sqlite.JDBC");
            String dbUrl = "jdbc:sqlite:"+dbName+".sqlite";
            open = DriverManager.getConnection(dbUrl);
            return open;
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return null;
        }
    }
    /**
     * подключаемся к базе postgres
     * определяем имя базы
     * @param dbName - наименование
     *               подключаемой базы данных
     *
     * @return тип Connection  при успешном подключении
     * или null - при неудаче
     */
    public   Connection connect_postgres_Db(String dbName) {
        try {
            Class.forName("org.sqlite.JDBC");
            String dbUrl = "jdbc:postgresql://localhost:5432/tracker";
            String name = "postgres";
            String password = "domi21092012nika";
            open = DriverManager.getConnection(dbUrl,name,password);
            return open;
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return null;
        }
    }

    public Connection getOpen () {
        return open;
    }

    public void makeSQl(String dbName, String sql,PreparedStatement pst) {

       try {
            pst = open.prepareStatement(sql);
            pst.execute();
        } catch (SQLException e) {
           log.error(e.getMessage(), e);
        }

    }

    public PreparedStatement getStatment(String sql) throws SQLException {
       return open.prepareStatement(sql);
    }



}
