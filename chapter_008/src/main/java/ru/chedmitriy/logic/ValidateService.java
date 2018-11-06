package ru.chedmitriy.logic;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import ru.chedmitriy.models.User;
import ru.chedmitriy.servlets.UserServlet;

import java.util.Collection;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Singleton
 */
public class ValidateService {
    /**
     * файл логирования
     */
    private  final Logger LOGGER = LogManager.getLogger(UserServlet.class);
    /**
     *
     */
    private static final ValidateService instance = new ValidateService();

    /**
     *
     */
    private final ConcurrentHashMap<Integer,User> users = new ConcurrentHashMap<Integer, User>();


    /**
     * @return
     */
    public static ValidateService getInstance(){
        return instance;
    }

    /**
     * @return
     */
    public Collection<User> values() {
        return this.users.values();
    }

    /**
     * @param user
     *
     */
    public boolean add(final User user) {
        if (user == null){
            LOGGER.error("Ошибка! Попытка добавления пустого значечния");
            return false;
        }
        this.users.put(user.getId(),user);
        LOGGER.info("Пользователь "+user+ " добавлен в коллекцию");
        return true;
    }

    /**
     * @param user
     */
    public boolean edit (final User user) {
        if (user == null){
            LOGGER.error("Ошибка редактирования");
            return false;
        }
        this.users.replace(user.getId(),user);
        LOGGER.info("Редактирование успешно проаедено");
        return true;
    }

    /**
     * @param id
     */
    public boolean delete (final int id) {
        if (getById(id)==null) {
            LOGGER.error("Ошибка!Пользователя с тамим id не существует");
            return false;
        }
            LOGGER.info("Удаление пользователя "+getById(id));
            this.users.remove(id);
            LOGGER.info("Пользователь удален");
        return true;
    }


    /**
     * @return
     */
    public Collection<User> findAll(){

        return this.users.values();
    }


    /**
     * @param id
     * @return
     */
    public User getById (final int id) {
        if (users.get(id)==null){
            LOGGER.error("Ошибка!Пользователя с тамим id не существует");
        }
        return this.users.get(id);
    }


}
