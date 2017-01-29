package ru.chedmitriy.chess.usage;


import ru.chedmitriy.chess.algorithm.Input;
import ru.chedmitriy.chess.algorithm.Output;

import java.util.Scanner;

/**
 * @author Dmitry Cherutsa on 10.12.2016.
 * @version $Id$
 * @project junior
 * @since 0.1
 * Класс ввода/вывода для работы с консолью
 */
public class ConsoleIO implements Input, Output {
    /**.
     * параметр 'scanner' принимает введенные
     * пользователем значения
     * */
    Scanner scanner = new Scanner(System.in);


    /**
     * Метод 'ask()' Выводит строку -вопрос и принимает
     * введенные значения - строку
     */
    @Override
    public String ask(String s) {
       println(s);
        return scanner.next();
    }
    /**
     * Метод 'askLit()' Выводит строку -вопрос и принимает
     * введенные значения - символ
     */
    @Override
    public char askLit(char l) {
        println("Please enter the name of cell: 'A,B,C... etc'");
        return scanner.next().charAt(0);
    }
    /**
     * Метод 'askNumber()' Выводит строку -вопрос и принимает
     * введенные значения - число
     */
    @Override
    public int cellNumber(int number) {
       println("Please enter the cell number");
        return scanner.nextInt();
    }
    /**
     * @param object -  параметр
     *               выводимый в консоль с переносом строки
     */
    @Override
    public void println(Object object) {
        System.out.println(object);
    }
    /**
     * @param object -  параметр
     *               выводимый в консоль
     *               без переноса строки
     */
    @Override
    public void print(Object object) {
        System.out.print(object);
    }
}
