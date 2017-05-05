package ru.chedmitriy.collections.organization;

/**
 *
 * Класс в котором создаются
 * новые подразделения организации
 * */

public class Subdivision extends Department{
    /**
     * Название организации
     * */

    private final String name;
/**
 * Конструктор для создания
 * нового подразделения
 * @param name - название подразделения
 * */


    public Subdivision(String name) {
        super(name);
        this.name = name;
    }

    /**
 * Получаем название подразделения
 * @return name
 *
 * */
    public String getName() {
        return name;
    }
}
