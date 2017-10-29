package ru.chedmitry.multithreading.threads.monitor.ex1104;

import java.util.ArrayList;
import java.util.List;

/**
 * ru.chedmitry.multithreading.threads.monitor.ex1104
 *
 * @author cheDmitry
 * @version 1.0
 * @since 29.10.2017
 *
 * класс имитирует некоторое хранилище
 * данных типа User.
 */
public class UserStorage {

    /**
     * хранилище данных типа User.
     */
    private List<User> storage = new ArrayList<>();

    /**
     * синхронизированный метод
     * добавляет нового пользователя
     * в хранилище.
     * @param user - новый объект хранилища.
     */
    public synchronized void add(User user) {
        storage.add(user);
    }

    /**
     * синхронизированный метод
     * удаляющий 1 - й
     * объект из хранилища.
     *
     * @return - первый объект
     *          хранилища при успехе,
     *          null - при неудаче.
     */
    public synchronized User remove() {
        if (storage.size() > 0) {
            //Передаем управление другому потоку
            if (Thread.currentThread().getName().equals("one")) {
                Thread.yield();
            }
            return storage.remove(0);
        }
        return null;
    }

    /**
     * синхронизированный метод
     * изменяющий параметр amount
     *  объекта user,если выполгняется
     *  некоторое условие.
     */
    public synchronized void update() {
        for (User user : storage) {
            if (user != null) {
                if (user.getAmount() % 3 == 0) {
                    user.setAmount(user.getAmount() + 1);
                }
            }

        }
    }

    /**
     * синхронизированный метод,
     * перемещающий часть значения параметра
     * amount объекта user:User, чей id равен
     * параметру fromId:int,
     * параметру другого объекта user:User,
     * чей id равен параметру toId:int.
     * величина перемещаемого значения равна
     * параметру метода amount:int.
     * @param fromId - id объекта,от которого передаем.
     * @param toId - id объекта,которому передаем.
     * @param amount - величина значения для переноса.
     */
    public synchronized void transfer(int fromId, int toId, int amount) {
        for (User user : storage) {
            if (user != null) {
                if (user.getId() == fromId) {

                    user.setAmount(user.getAmount() - amount);
                }
                if (user.getId() == toId) {
                    user.setAmount(user.getAmount() + amount);
                }
            } else {
                throw new NullPointerException("User не найден");
            }
        }
    }

    /**
     * синхронизированный метод.
     * получения списка - хранилища.
     * @return - список - хранилище.
     */
    public synchronized List<User> getStorage() {
        return storage;
    }
}
