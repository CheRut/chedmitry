package ru.chedmitriy.persistent;

import ru.chedmitriy.models.User;

import java.util.Collection;
import java.util.concurrent.ConcurrentHashMap;


/**
 * Класс - хранилище данных
 */
public class MemoryStore implements Store {
    /**
     *  синглтон с Volatile
     *  может привести к проблемам на мультипроцессорных системах
     */
    private static volatile MemoryStore instance;

    /**
     *  хранилище пользователей
     *  вида ключ-значение
     */
    private final ConcurrentHashMap<Integer, User> Users = new ConcurrentHashMap<Integer, User>();

    /**
     *  конструктор по умолчанию
     */
    private MemoryStore() {

    }


    /**
     *  Получаем всех пользователей
     *  без ключей - идентификаторов
     *  @return - хранилище объектов
     */
    public Collection<User> values() {
        return this.Users.values();
    }
    /** вызов Синглтона
     * @return
     */
    public static MemoryStore getInstance() {
        if(instance == null){
            synchronized ( MemoryStore.class) {
                if (instance == null) {
                    instance = new MemoryStore();
                }
            }
        }
        return instance;
    }

    /**
     * Поиск по id
     * Также используется при удалении и
     * редактированиии
     * @param id -искомый пользователь
     * @return пользователь
     * с таким ключом-id
     */
    public User getById(int id) {
        return this.Users.get(id);
    }

    /**
     * Добавляем пользователь
     * @param User новый пользователь
     * @return - true при успешном
     * добавлении,иначе - false
     */
    public void add(User User) {
        this.Users.put(User.getId(),
                User);
    }

    /**
     * пользователь ищется в
     * хранилище по id.
     * Удаляем пользователь
     * по его id
     * @param id - id удаляемого
     *           пользователя
     */
    public void delete(int id) {
        this.Users.remove(id);
    }

    /**
     * пользователь ищется в
     * хранилище,
     * затем редактируется
     * @param User - id редактируемого
     *           пользователя
     */
    public void edit(User User) {
        this.Users.replace(User.getId(),User);
    }

    /**
     * Получаем значения
     * хранилища
     * @return - значения из хранилища
     */
    public Collection<User> viewAll() {
        return this.Users.values();
    }
}
