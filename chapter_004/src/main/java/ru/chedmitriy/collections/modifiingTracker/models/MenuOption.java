package ru.chedmitriy.collections.modifiingTracker.models;

import ru.chedmitriy.collections.modifiingTracker.objects.ConsoleInput;
import ru.chedmitriy.collections.modifiingTracker.objects.Tracker;

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
