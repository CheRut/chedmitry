package ru.chedmitriy.monitor.ex1104;

/**
 * package ru.chedmitriy.multithreading.threads.monitor.ex1104
 *
 * @author cheDmitry
 * @since 27.10.2017
 * @version 1.0
 * в данном классе
 * создается пользователь
 * User, из которых состоит
 * хранилище
 */

class User {
    /**
     * параметр количетво
     */
    private int amount;
    /**
     * параметр id
     * */
    private int id;

    /**
     * конструктор по умолчанию.
     *
     * @param id  - id пользователя
     * @param amount - количество пользователей
     */
    public User(int id, int amount) {
        this.id = id;
        this.amount = amount;
    }


    /**
     * получаем id
     * объекта user:User
     *
     * @return - целое число
     */
    public int getId() {
        return id;
    }

    /**
     * получаем значение
     * счетчика объекта user:User
     *
     * @return - целое число
     */
    public int getAmount() {
        return amount;
    }

    /**
     * задаем значение параметра
     * счетчика объекта user:User
     *
     * @param amount - задаваемые параметр
     */
    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return String.format("%s %s  %s %s%n",
                "id =", id,
                "amount =",
                amount);
    }

}
