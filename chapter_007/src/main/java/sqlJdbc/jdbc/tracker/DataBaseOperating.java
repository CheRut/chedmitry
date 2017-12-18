package sqlJdbc.jdbc.tracker;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sqlJdbc.jdbc.connection.ConnectOptions;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

/**
 * chedmitry
 *
 * @author CheDmitry
 * @version 1.0
 * @since 17.12.17
 */
public class DataBaseOperating {
    /**
     * файл логирования
     */
    private static final Logger log = LoggerFactory.getLogger(ConnectOptions.class);



    /**
     * определяем подключение
     * к базе данных
     */
    private ConnectOptions openConnection;

    /**
     * подключаемся к
     * postgres базе
     */
    public DataBaseOperating() {
        this.openConnection = new ConnectOptions();
        this.openConnection.connect_postgres_Db("tracker");
    }

    /**
     * выполняем sql запрос
     * @param sql - строка -команда
     */
    public void makeSql(String sql) {
        PreparedStatement pst = null;
        try {
            pst = openConnection.getOpen().prepareStatement(sql);
            pst.executeUpdate();
            pst.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * создаем таблицу.
     * с полями id: serial primary key,
     *          item_name: character varying(20),
     *          create_date: timestamp
     *
     */
    public void createTable() {
        String sql = "create table if not exists";
        String tabName = "tracker";
        String fields = String.format("%s%s%s",
                "id serial primary key,",
                "item_name character varying(20),",
                "create_date timestamp");
        makeSql(String.format("%s %s(%s) ", sql, tabName, fields));

    }

    /**
     * добавляем заявку
     * @param item - новая заявка
     *
     */
    public void addItem(Item item) {
        String sql = String.format("%s ",
                "insert into tracker(item_name, create_date) values (?,?)");
        PreparedStatement pst = null;
        try {
            pst = openConnection.getOpen().prepareStatement(sql);
            pst.setString(1,item.getName());
            pst.setTimestamp(2,item.getCreateDate());
            pst.executeUpdate();
            pst.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    /**
     * редактируем заявку по id.
     * @param id - id редактируемой заявки
     * @param newName - новое название заявки
     * @param createDate - новая дата
     */
    public Item updateItem(String id, String newName, Timestamp createDate) {
        String operation = "update tracker set item_name = ?, create_date = ?";
        String condition = "where id = ";
        PreparedStatement pst  = null;
        Item item = null;
        try {
            pst = openConnection.getOpen().prepareStatement(String.format("%s %s %s",
                    operation,condition, id));
            pst.setString(1,newName);
            pst.setTimestamp(2,createDate);
            pst.executeUpdate();
            pst.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return getElementById(id);

    }

    /**
     * удаляем заявку по id
     * @param id - id удаляемой заявки заявки
     */
    public void deleteItem(String id) {
        String sql = "delete from tracker where id="+id;
        PreparedStatement pst = null;
        try {
            pst = openConnection.getOpen().prepareStatement(sql);
            pst.execute();
            pst.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Отображаем список всех заявок
     *
     */
    public void showAllItems() {
        String sql = "select * from tracker";
        PreparedStatement pst  = null;
        try {
            pst = openConnection.getOpen().prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                System.out.printf("%s %s %s\n",
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(3));
            }
            pst.execute();
            pst.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * получаем заявку по названию
     * @param name - название заявки
     * @return найденная заявка
     */
    public Item getElementByName(String name) {
        String sql = "SELECT * FROM tracker WHERE item_name='"+name+"'";
        PreparedStatement pst  = null;
        Item item = null;
        try {
            pst = openConnection.getOpen().prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                String id = String.valueOf(rs.getInt("id"));
                String itemName = rs.getString("item_name");
                Timestamp date = rs.getTimestamp("create_date");
                item = new Item(id, itemName, date);

            }
            pst.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return item;
    }

    /**
     * отображаем заявку по id
     * @param id - уникальный идентификатор
     * @return найденная заявка
     */
    public Item getElementById(String id) {
        String sql = "SELECT * FROM tracker WHERE id='"+id+"'";
        PreparedStatement pst  = null;
        Item item = null;
        try {
            pst = openConnection.getOpen().prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                item = new Item(String.valueOf(rs.getInt("id")),
                        rs.getString("item_name"), rs.getTimestamp("create_date"));
            }
            pst.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return item;
    }

}
