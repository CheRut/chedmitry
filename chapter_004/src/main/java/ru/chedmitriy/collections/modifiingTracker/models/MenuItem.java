package ru.chedmitriy.collections.modifiingTracker.models;


import ru.chedmitriy.collections.modifiingTracker.objects.ConsoleInput;
import ru.chedmitriy.collections.modifiingTracker.objects.Tracker;

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
