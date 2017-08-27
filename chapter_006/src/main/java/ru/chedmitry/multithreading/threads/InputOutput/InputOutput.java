package ru.chedmitry.multithreading.threads.InputOutput;

import java.util.Scanner;

public class InputOutput implements Input,Output {
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

    @Override
    public void print(Object object) {
        System.out.print(object);
    }
}
