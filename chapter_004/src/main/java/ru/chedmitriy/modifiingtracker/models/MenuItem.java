package ru.chedmitriy.modifiingtracker.models;


import ru.chedmitriy.modifiingtracker.objects.ConsoleInput;
import ru.chedmitriy.modifiingtracker.objects.Tracker;

/**
 *
 * Класс - шаблон меню опций
 */
public abstract class  MenuItem implements MenuOption {

    /**
     * .
     * название опции меню
     * */
    private final String name;

    public MenuItem(final String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    /**
     * .
     * Метод выбора пунктов меню, в соответствии с действиями над
     * списком объектов
     * */
    abstract public void menuItemInfo(final ConsoleInput cIn, final Tracker tracker);




}
