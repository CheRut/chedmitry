package ru.chedmitriy.persistent;

import ru.chedmitriy.models.User;

import java.util.Collection;
import java.util.concurrent.ConcurrentHashMap;


/**
 * Класс - хранилище данных
 */
public class MemoryStore implements Store<User> {
    /**
     *  синглтон с Volatile
     *  может привести к проблемам на мультипроцессорных системах
     */
    private static volatile MemoryStore instance;

    /**
     *  хранилище пользователей
     *  вида ключ-значение
     */
    private final ConcurrentHashMap<Integer, User> users = new ConcurrentHashMap<Integer, User>();

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
        return this.users.values();
    }
    /** вызов Синглтона
     * @return
     */
    public static MemoryStore getInstance() {
        if (instance == null) {
            synchronized (MemoryStore.class) {
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
        return this.users.get(id);
    }

    /**
     * Добавляем пользователь
     * @param user новый пользователь
     * @return - true при успешном
     * добавлении,иначе - false
     */
    public void add(User user) {
        this.users.put(user.getId(), user);
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
        this.users.remove(id);
    }

    /**
     * пользователь ищется в
     * хранилище,
     * затем редактируется
     * @param user - id редактируемого
     *           пользователя
     */
    public void edit(User user) {
        this.users.replace(user.getId(), user);
    }

    /**
     * Получаем значения
     * хранилища
     * @return - значения из хранилища
     */
    public Collection<User> viewAll() {
        return this.users.values();
    }
}
