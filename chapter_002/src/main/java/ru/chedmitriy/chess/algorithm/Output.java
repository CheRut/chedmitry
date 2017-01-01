package ru.chedmitriy.chess.algorithm;

/**
 * @author Dmitry Cherutsa on 10.12.2016.
 * @version $Id$
 * @project junior
 * @since 0.1
 * Интерфейс вывода
 */
public interface Output {
/**
 * @param object -  параметр
 *               выводимый в консоль с переносом строки
 * */
    void println(Object object);
    /**
     * @param object -  параметр
     *               выводимый в консоль
     *               без переноса строки
     * */
    void print(Object object);
}
