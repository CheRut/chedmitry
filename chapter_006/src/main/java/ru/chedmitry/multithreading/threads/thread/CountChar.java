package ru.chedmitry.multithreading.threads.thread;

import ru.chedmitry.multithreading.threads.InputOutput.InputOutput;

import static java.lang.Thread.sleep;

/**
 * Created by dimsan on 27.08.17.
 */
public class CountChar implements Runnable {
    /**
     * Строка для обработки
     */
    private String chars;
    /**
     * параметр ввода
     */
    private InputOutput iO;

    /**
     * конструктор,принимающий
     * в качестве параметра
     * обрабатываемую строку
     * @param chars
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
        }
    }
}
