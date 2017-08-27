package ru.chedmitry.multithreading.threads.InputOutput;

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