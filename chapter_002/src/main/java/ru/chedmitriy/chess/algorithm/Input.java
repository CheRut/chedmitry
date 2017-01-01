package ru.chedmitriy.chess.algorithm;

/**
 * @author Dmitry Cherutsa on 10.12.2016.
 * @version $Id$
 * @project junior
 * @since 0.1
 * Интерфейс  ввода
 */
public interface Input {
    /**
    * Метод 'ask()' Выводит строку -вопрос и принимает
     * введенные значения - строку
    * */
    String ask(String s);
    /**
     * Метод 'askLit()' Выводит строку -вопрос и принимает
     * введенные значения - символ
     * */
    char askLit(char l);
    /**
     * Метод 'askNumber()' Выводит строку -вопрос и принимает
     * введенные значения - число
     * */
    int cellNumber(int numb);
}
