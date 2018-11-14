package ru.chedmitriy.io;

/**
 * ru.chedmitry.multithreading.threads.io.
 *
 * @author cheDmitry
 * @version 1.0
 * @since 28.10.2017.
 */


interface Input {
    /**
     * Метод 'ask()' Выводит строку -вопрос и принимает.
     * введенные значения - строку.
     * @param s - параметр  строка
     * @return - строка
     */
     String askString(final String s);

    /**
     * Метод 'askLit()' Выводит строку -вопрос и принимает
     * введенные значения - символ.
     * @param l - параметр символ
     * @return - символьный параметр
     */
    char askLit(final char l);

    /**
     * Метод 'askNumber()' Выводит строку -вопрос и принимает
     * введенные значения - число.
     * @param numb - параметр число
     * @return - целое число
     */
    int askNumber(final int numb);
}
