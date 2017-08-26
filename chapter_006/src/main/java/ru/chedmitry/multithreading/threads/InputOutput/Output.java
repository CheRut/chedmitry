package ru.chedmitry.multithreading.threads.InputOutput;

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
