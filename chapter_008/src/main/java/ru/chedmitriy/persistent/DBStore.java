package ru.chedmitriy.persistent;

import org.apache.commons.dbcp2.BasicDataSource;
import ru.chedmitriy.models.User;

import java.sql.Connection;
import java.sql.Statement;
import java.util.Collection;

public class DBStore  implements Store<User> {



    private static final BasicDataSource SOURCE = new BasicDataSource();
    private static DBStore instance = new DBStore();


    public DBStore() {
        SOURCE.setUrl("...");
        SOURCE.setUsername("...");
        SOURCE.setPassword("...");
        SOURCE.setMinIdle(5);
        SOURCE.setMaxIdle(10);
        SOURCE.setMaxOpenPreparedStatements(100);
    }

    public static DBStore getInstance() {
        return instance;
    }

    /**
     * Поиск по id
     * Также используется при удалении и
     * редактированиии
     *
     * @param id -искомый пользователь
     *           пользователь с таким ключом-id
     */
    @Override
    public User getById(int id) {
        return null;
    }

    /**
     * Добавляем пользователя
     *
     * @param user новый пользователь
     */
    @Override
    public void add(User user) {
        try (Connection connection = SOURCE.getConnection();
             Statement st = connection.prepareStatement("...")
        ) {
            String nullValue; // just to do this section is not empty
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * пользователь ищется в
     * хранилище по id.
     * Удаляем пользователь
     * по его id
     *
     * @param id - id удаляемого
     *           пользователя
     */
    @Override
    public void delete(int id) {

    }

    /**
     * Get the store's values
     * without a keys
     *
     * @return - values
     */
    @Override
    public Collection<User> values() {
        return null;
    }

    /**
     * Пользователь ищется в
     * хранилище по id,
     * затем редактируется
     *
     * @param user - id редактируемого
     *             пользователя
     */
    @Override
    public void edit(User user) {

    }

    /**
     * Получаем значения
     * хранилища
     *
     * @return - значения из хранилища
     */
    @Override
    public Collection<User> viewAll() {
        return null;
    }
}
