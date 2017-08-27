package ru.chedmitry.multithreading.threads.thread;

import ru.chedmitry.multithreading.threads.InputOutput.InputOutput;

import static java.lang.Thread.sleep;

/**
 * @author - cheDmitry
 * @since 27.08.2017
 * @version - 1.0
 */
public class CountChar implements Runnable {
    /**
     * Счетчик операций
     */
    private int countingOperations=0;
    /**
     * Строка для обработки
     */
    private final String chars;
    /**
     * параметр ввода
     */
    private final InputOutput iO;

    /**
     * конструктор,принимающий
     * в качестве параметра
     * обрабатываемую строку
     * @param chars - обрабатываемая строка
     */
    public CountChar(String chars) {
        this.chars = chars;
        iO = new InputOutput();
    }

    /**
     * точка входа в поток
     */
    @Override
    public void run() {
        int count = 0;
        for (int i = 0; i <chars.length() ; i++) {
            try {
                count++;

                sleep(500);
            } catch (InterruptedException e) {
                iO.println("Поток "+Thread.currentThread().getName()+" завершен ");
                break;

            }
            iO.println("символов в строке: "+ count);
            countingOperations++;
            countingOperations = count;
        }
    }

    public int getCountingOperations() {
        return countingOperations;
    }
}
