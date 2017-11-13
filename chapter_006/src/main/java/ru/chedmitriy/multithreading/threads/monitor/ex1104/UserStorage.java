package ru.chedmitriy.multithreading.threads.monitor.ex1104;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

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
@ThreadSafe
class UserStorage {

    /**
     * хранилище данных типа User.
     */
    @GuardedBy("this")
    private final List<User> storage = new ArrayList<>();

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
    public synchronized void remove(int id) {
        if (storage.size() > 0) {
            //Передаем управление другому потоку
            if (Thread.currentThread().getName().equals("one")) {

                Thread.yield();
            }

            storage.remove(id);
        }
    }

    /**
     * синхронизированный метод
     * изменяющий параметр amount
     *  объекта user,если выполгняется
     *  некоторое условие.
     */
    public synchronized void update(int id) {
        for (User us : storage) {
            if (us != null) {

                if (us.getId() == id) {
                    us.setAmount(us.getAmount() + 1);
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
     * @throws IllegalArgumentException - исключение при отсутствии хотя бы
     *               одного из значений
     */
    public synchronized void transfer(int fromId, int toId, int amount) {
        if (storage.get(fromId - 1 ) == null || storage.get(toId - 1 ) == null) {
            throw new IllegalArgumentException();
        }
            storage.get(fromId - 1 ).setAmount(storage.get(fromId - 1).getAmount() - amount);
            storage.get(toId - 1).setAmount(storage.get(toId - 1).getAmount() + amount);

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
