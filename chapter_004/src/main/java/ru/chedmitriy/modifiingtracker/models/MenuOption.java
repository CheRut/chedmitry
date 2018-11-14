package ru.chedmitriy.modifiingtracker.models;

import ru.chedmitriy.modifiingtracker.objects.ConsoleInput;
import ru.chedmitriy.modifiingtracker.objects.Tracker;

/**
 *
 * Интерфейс пунктов меню
 */
interface MenuOption {
    /**
     * метод выбора действий из меню
     * */
    void menuItemInfo(ConsoleInput cIn, Tracker tracker);


}
