package ru.chedmitry.multithreading.threads.io;

import java.util.Scanner;

/**
 * класс ввода-вывода
 */
public class InputOutput implements Input, Output {
    /**.
     * параметр 'scanner' принимает введенные
     * пользователем значения
     * */
    private final Scanner scanner = new Scanner(System.in);


    @Override
    public String askString(String s) {
        println("Введите строку: ");
        return scanner.nextLine();
    }

    @Override
    public char askLit(char l) {
        println("Введите символ: ");
        return scanner.next().charAt(0);

    }

    @Override
    public int askNumber(int numb) {
        println("Введите число");
        return scanner.nextInt();
    }

    @Override
    public void println(Object object) {
        System.out.println(object);
    }




}
