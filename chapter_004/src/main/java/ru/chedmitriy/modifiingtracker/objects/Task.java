package ru.chedmitriy.modifiingtracker.objects;

/**
 *
 * класс -наследник объекта Item
 */
public class Task extends Item {


/**
 * Конструктор с параметрами
 * @param name - параметр имя объекта
 * @param description  - параметр описание объекта
 * */
    public Task(String name, String description) {
        super(name, description);
    }


}
