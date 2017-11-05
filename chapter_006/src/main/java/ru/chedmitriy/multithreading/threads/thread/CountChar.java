package ru.chedmitriy.multithreading.threads.thread;

import ru.chedmitriy.multithreading.threads.io.InputOutput;

import static java.lang.Thread.sleep;

/**
 * ru.chedmitry.multithreading.threads.thread.
 *
 * @author cheDmitry
 * @version 1.0
 * @since 29.10.2017
 * используем в качестве списка
 * созданный ранее связный список
 *
 */
class CountChar implements Runnable {
    /**
     * Счетчик операций.
     */
    private int countingOperations = 0;
    /**
     * Строка для обработки.
     */
    private final String chars;
    /**
     * параметр ввода.
     */
    private final InputOutput iO;

    /**
     * конструктор,принимающий
     * в качестве параметра
     * обрабатываемую строку.
     */

    public CountChar() {
        String s = "kklklklklkлдлдлдлд";
        this.chars = s;
        iO = new InputOutput();
    }

    /**
     * точка входа в поток
     * В методе ведется потсчет
     * символов в строке дл тех пор
     * пока isInterrupt() возвращает false.
     */
    @Override
    public  void run() {
        iO.println("запуск потока: " + Thread.currentThread().getName());
        int count = 0;
        for (int i = 0; i < chars.length(); i++) {
            if (Thread.currentThread().isInterrupted()) {
                break;
            } else {
                try {
                    count++;
                    sleep(500);
                    iO.println("символов в строке: " + count);
                } catch (InterruptedException e) {
                    iO.println("Поток " + Thread.currentThread().getName() + " завершен");
                }
            }
            countingOperations++;
        }
    }

    public int getCountingOperations() {
        return countingOperations;
    }
}
