package ru.chedmitriy.collectionsPro.generic.storeRealization.models;


/**
 *Класс общий для
 * всех обеъкто Role и User
 */
public abstract class Base {
    /**
     *id объекта
     */
    private   String id;
    /**
     * имя объекта
     * */
    private String name;
    /**
     * Конструктор создает новый
     * обеъкт Role или User
     * @param name
     */
    public Base(String name) {
        this.name = name;
    }
    /**
     * метод возвращает
     * имя объекта
     * @return
     */
    public String getName() {
        return name;
    }
    /**
     * метод определяет имя объекта
     * */
    public void setName(String name) {
        this.name = name;
    }
    /**
     * метод возвращает id
     * объекта
     * @return - id объекта
     */
    public String getId() {
        return id;
    }

    /**
     * метод,определяющий
     * id объекта
     * @param id
     */
    public void setId(String id) {
        this.id = id;
    }
}
