package ru.chedmitriy.collections.mapExample;

/**
 * Главный класс,здесь
 * задаются параметры
 * для каждого нового User
 */
public class User {
    /**
     * имя объекта
     * */
    private final String name;
    /**
     * идентификатор объекта
     * */
    private final int id;
    /**
     * город объекта
     * */
    private final String city;
/**
 * Конструктор,где задаются общие для всех объектов
 * данного класса параметры
 * @param name - имя объекта USer
 * @param id - идентификатор объекта User
 * @param city  -  город объекта
 *
 * */
    public User(int id,String name,String city) {
        this.id = id;
        this.name = name;
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

}
