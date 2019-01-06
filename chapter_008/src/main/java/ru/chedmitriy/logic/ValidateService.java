package ru.chedmitriy.logic;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import ru.chedmitriy.models.User;
import ru.chedmitriy.persistent.MemoryStore;
import ru.chedmitriy.persistent.Store;

import java.util.Collection;

/**
 * If the program will always need an INSTANCE,
 * or if the cost of creating the INSTANCE is not
 * too large in terms of time/resources,
 * the programmer can switch to eager initialization,
 * which always creates an INSTANCE when the class is loaded into the JVM.
 */
public class ValidateService {
    /**
     * Logging fail
     */
    private  final Logger logger = LogManager.getLogger(ValidateService.class);
    /**
     * Static member holds only one INSTANCE of the
     * ValidateService class
     */
    private static final ValidateService INSTANCE = new ValidateService();

    /**
     * ValidateService prevents any
     * other class from instantiating
     */
    private ValidateService() {
    }
    /**
     *  Providing Global point of access
     * */
    public static final ValidateService getInstance() {
        return INSTANCE;
    }

    /**
     * Call the singleton
     */
    private final Store storeInstance = MemoryStore.getInstance();

    /**
     * Trying to add a
     * new user
     * @param user - adding auto
     * @return - true/false
     */
    public boolean add(final User user) {
        storeInstance.add(user);
        if (storeInstance.values().contains(user)) {
            logger.info("Добавлен новый пользователь: " + user);
            return true;
        } else {
            logger.error("Произошла ошибка при добавлении"
                    + " нового пользователя");
            return false;
        }
    }

    /**
     * Trying to edit an user
     * @param user - founded user
     * @return true/false
     */
    public boolean edit(final User user) {
        if (user != null) {
            storeInstance.edit(user);
            logger.info("Редактирование пользователя  успешно выполнено, новое значение: " + user);
            return true;
        } else {
            logger.error("Ошибка при редактировании пользователя: " + user);
            return false;
        }
    }

    /**
     * Trying to delete
     * an User by own id
     * @param id - deleting auto
     * @return true/false
     */
    public boolean delete(final int id) {
        if (storeInstance.getById(id) != null) {
            storeInstance.delete(id);
            logger.info("Удаление пользователя успешно выполненно");
            return true;
        } else  {
            logger.error("Ошибка при удалении пользователя! ");
            return false;
        }
    }

    /**
     * Try to find an User by
     * parameter id
     * @param id - finding User
     * @return
     */
    public User getById(final int id) {
        if (id > 0 && storeInstance.getById(id) != null) {
            logger.info("пользователь с порядковым номером - " + id
                    + ": " + storeInstance.getById(id) + "найден");
            return (User) storeInstance.getById(id);
        } else {
            logger.error("пользователь с порядковым номером - " + id + " не найден");
            return null;
        }
    }

    /**
     * Try to view all
     * Users of the store
     * @return - storage values
     */
    public Collection<User> getAllValues() {
        return storeInstance.values();

    }

    /**
     * getting the user's role
     * that have been try to register
     * @param login
     * @param password
     * @return
     */
    public User.Role registeredRole(final String login, final String password) {
        User.Role role = User.Role.GUEST;
        for (User user:getAllValues()) {

            if (user.getLogin().equals(login)
                    && user.getPassword().equals(password)) {
                role = user.getRole();
                break;
            }

        }  return role;
    }



}
