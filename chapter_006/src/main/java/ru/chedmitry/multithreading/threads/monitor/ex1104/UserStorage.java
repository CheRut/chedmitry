package ru.chedmitry.multithreading.threads.monitor.ex1104;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

import java.util.ArrayList;
import java.util.List;

/**
 * класс - хранилище
 * пользователей
 * @author cheDmitry
 * @since 24.10.2017
 * @version 1.0
 */
@ThreadSafe
class UserStorage {

    /**
     * хранилище пользователей
     */
    private final List<User> store = new ArrayList<>();

    /**
     * добавляем
     * нового пользователя  User
     * Так как не работать с пустым хранилищем
     * не будет возможности,необходимо
     * поставить заблокировать
     * работу с хранилищем,пока не будут получены
     * данные,все методы смогут
     * работать с этим хранилищем,
     * об этом нам говорит метод notifyAll()
     * дающий разрешение всем ожидающим методам
     * @param user - параметр типа User
     */
    @GuardedBy("store")
    public void add(final User user) {
        synchronized (this.store) {
            this.store.add(user);
            this.store.notifyAll();
        }
    }

    /**
     * обновляем
     * значение параметра amount
     * пользователей, где значение
     * этого параметра <=0,
     * заменим его числом 1000,
     * при этом,данный метод
     * выполняет дополнительную проверку,
     * на заполненность хранилища:
     * пока хранилище пусто,метод вызывает wait(),
     * до момента разрешения notifyAll() из
     * метода add()
     *
     */
    @GuardedBy("store")
    public void update() {
        synchronized (this.store) {
            while (this.store.isEmpty()) {
                try {
                    this.store.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            for (User user : this.store) {
                if (user.getAmount() <= 0) {
                    user.setAmount(1000);
                }
            }
        }
    }

    /**
     * метод удаляет
     * пользователя из хранилища
     * параметр amount который делится
     * по модулю на 3 без остатка
     */
    @GuardedBy("store")
    public void delete() {
        synchronized (this.store) {
            while (this.store.isEmpty()) {
                try {
                    this.store.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            for (User user : this.store) {
                if (user.getAmount() % 3 == 0) {
                    this.store.remove(user);
                    break;
                }
            }
        }
    }
    /**
     *
     * метод переноса
     * значений
     * @param fromId параметр id
     *               пользователя откуда переносим значения
     * @param toId - параметр id пользователя
     *               которому переносим значения
     * @param amount - перемещаемое значение
     */
    @GuardedBy("store")
    public void transfer(int fromId, int toId, int amount) {
        synchronized (this.store) {
            for (User user : this.store) {
                if (user.getId() == fromId) {
                    user.setAmount(user.getAmount() - amount);
                }
                if (user.getId() == toId) {
                    user.setAmount(user.getAmount() + amount);
                }
            }
        }
    }
    public List<User> getStore() {
        return store;
    }
}

