package ru.chedmitriy.jdbc.connection;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;

/**
 * ru.chedmitriy.jdbc.connection
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
    private static final Logger LOGGER = LoggerFactory.getLogger(ConnectOptions.class);
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
    public   Connection connectSQLiteDb(String dbName) {
        try {
            Class.forName("org.sqlite.JDBC");
            String dbUrl = "jdbc:sqlite:" + dbName + ".sqlite";
            open = DriverManager.getConnection(dbUrl);
            return open;
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
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
    public   Connection connectPostgresDb(String dbName) {
        try {
            Class.forName("org.sqlite.JDBC");
            String dbUrl = "jdbc:postgresql://localhost:5432/" + dbName + "";
            open = DriverManager.getConnection(dbUrl);
            return open;
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
            return null;
        }
    }

    public Connection getOpen() {
        return open;
    }

    public void makeSQl(String dbName, String sql, PreparedStatement pst) {

       try {
            pst = open.prepareStatement(sql);
            pst.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public PreparedStatement getStatment(String sql) throws SQLException {
       return open.prepareStatement(sql);
    }



}
