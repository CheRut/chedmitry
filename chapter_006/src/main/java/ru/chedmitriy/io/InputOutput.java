package ru.chedmitriy.io;

import java.util.Scanner;

/**
 * ru.chedmitry.multithreading.threads.io.
 *
 * @author cheDmitry
 * @version 1.0
 * @since 28.10.2017
 */

public class InputOutput implements Input, Output {
    /**.
     * параметр 'scanner' принимает введенные
     * пользователем значения.
     * */
    private final Scanner scanner = new Scanner(System.in);


    @Override
    public final String askString(final String s) {
        println("Введите строку: ");
        return scanner.nextLine();
    }

    @Override
    public final char askLit(final char l) {
        println("Введите символ: ");
        return scanner.next().charAt(0);

    }

    @Override
    public final int askNumber(final int numb) {
        println("Введите число");
        return scanner.nextInt();
    }

    @Override
    public final void println(final Object object) {
        System.out.println(object);
    }




}
