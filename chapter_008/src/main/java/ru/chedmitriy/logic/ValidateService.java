package ru.chedmitriy.logic;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import ru.chedmitriy.models.User;
import ru.chedmitriy.persistent.DBStore;
import ru.chedmitriy.persistent.MemoryStore;
import ru.chedmitriy.persistent.Store;

import java.util.Collection;

/**
 * If the program will always need an instance,
 * or if the cost of creating the instance is not
 * too large in terms of time/resources,
 * the programmer can switch to eager initialization,
 * which always creates an instance when the class is loaded into the JVM.
 */
public class ValidateService {
    /**
     * Logging fail
     */
    private  final Logger LG = LogManager.getLogger(ValidateService.class);
    /**
     * Static member holds only one instance of the
     * ValidateService class
     */
    private static final ValidateService instance = new ValidateService();

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
        return instance;
    }

    /**
     * Call the singleton
     */
    private final Store storeInstance = MemoryStore.getInstance();

    /**
     * Trying to add a
     * new User
     * @param User - adding auto
     * @return - true/false
     */
    public boolean add(final User User) {
        storeInstance.add(User);
        if(storeInstance.values().contains(User)) {
            LG.info("Добавлен новый пользователь: "+User);
            return true;
        }
        else {
            LG.error("Произошла ошибка при добавлении" +
                    " нового пользователя");
            return false;
        }
    }

    /**
     * Trying to edit an User
     * @param User - founded User
     * @return true/false
     */
    public boolean edit (final User User){
        if(User != null ){
            storeInstance.edit(User);
            LG.info("Редактирование пользователя  успешно выполнено, новое значение: "+User);
            return true;
        }
        else {
            LG.error("Ошибка при редактировании пользователя: "+User);
            return false;
        }
    }

    /**
     * Trying to delete
     * an User by own id
     * @param id - deleting auto
     * @return true/false
     */
    public boolean delete (final int id) {
        if(storeInstance.getById(id)!= null) {
            storeInstance.delete(id);
            LG.info("Удаление пользователя успешно выполненно" );



            return true;
        }
        else  {
            LG.error("Ошибка при удалении пользователя! ");
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
        if(id > 0 && storeInstance.getById(id)!= null) {
            LG.info("пользователь с порядковым номером - "+id+": "+storeInstance.getById(id)+"найден");
            return (User) storeInstance.getById(id);
        }
        else    {
            LG.error("пользователь с порядковым номером - "+id+" не найден");
            return null;
        }
    }

    /**
     * Try to view all
     * Users of the store
     * @return - storage values
     */
    public Collection<User> getAllValues(){
        return storeInstance.values();

    }

}
