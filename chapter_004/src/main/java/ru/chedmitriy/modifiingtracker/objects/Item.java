package ru.chedmitriy.modifiingtracker.objects;

import java.sql.Timestamp;

/**
 *
 * Класс - родитель для всех объетов
 * помещаемых в коллекцию
 *
 */
public class Item {

    /**
     * Имя объекта
     * */
    private String name;

    /**
     * Описание объкта
     * */
    private String description;

    /**
     * Конструктор по умолчанию*/
    Item() { }
    /**
     * Конструктор с параметрами
     * @param name - имя объекта
     * @param description - описание объекта
     * */
    public Item(final String name, final String description) {
        this.name = name;
        this.description = description;

    }



    /**
     * возвращаем имя объекта
     *
     * @return - имя объекта
     * */
    public String getName() {
        return this.name;
    }
    /**
     * передаем имя объекту
     * @param name - параметр имя
     * */
    public void setName(final String name) {
        this.name = name;
    }
     /**
     * возвращаем описание к объекту
     * @return -описание к объекту
     * */
    public String getDescription() {
        return this.description;
    }
    /**
     * передаем описание объекту
     * @param description  - описание к объекту
     * */
    public void setDescription(final String description) {
        this.description = description;
    }


}
