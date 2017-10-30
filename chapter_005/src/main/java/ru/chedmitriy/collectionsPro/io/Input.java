package ru.chedmitriy.collectionsPro.io;

/**
 * ru.chedmitry.multithreading.threads.io
 *
 * @author cheDmitry
 * @version 1.0
 * @since 28.10.2017
 */
interface Input {
    /**
     * Метод 'ask()' Выводит строку -вопрос и принимает
     * введенные значения - строку
     */
    String askString(String s);

    /**
     * Метод 'askLit()' Выводит строку -вопрос и принимает
     * введенные значения - символ
     */
    char askLit(char l);

    /**
     * Метод 'askNumber()' Выводит строку -вопрос и принимает
     * введенные значения - число
     */
    int askNumber(int numb);
}
