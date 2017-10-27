package ru.chedmitry.multithreading.threads.thread;

import ru.chedmitry.multithreading.threads.io.InputOutput;

import static java.lang.Thread.sleep;

/**
 * @author - cheDmitry
 * @since 27.08.2017
 * @version - 1.0
 */
class CountChar implements Runnable {
    /**
     * Счетчик операций
     */
    private int countingOperations = 0;
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
     * пока isInterrupt() возвращает false
     */
    @Override
    public void run() {
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
