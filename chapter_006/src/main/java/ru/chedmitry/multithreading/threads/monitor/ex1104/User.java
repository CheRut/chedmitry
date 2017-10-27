package ru.chedmitry.multithreading.threads.monitor.ex1104;

/**
 * @author cheDmitry
 * @since 27.08.2017
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
     * конструктор по умолчанию
     * @param id  - id пользователя
     * @param amount - количество пользователей
     */
    public User(int id, int amount) {
        this.id = id;
        this.amount = amount;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "User{"
                + "amount = "
                + amount
                + ", id = "
                + id
                + '}';
    }

}
