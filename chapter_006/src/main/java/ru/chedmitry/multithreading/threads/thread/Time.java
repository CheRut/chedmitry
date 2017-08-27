package ru.chedmitry.multithreading.threads.thread;

import ru.chedmitry.multithreading.threads.InputOutput.InputOutput;

import static java.lang.Thread.sleep;

/**
 * @author - cheDmitry
 * @since 27.08.2017
 * @version - 1.0
 */

public class Time implements Runnable {
    /**
     * параметр ввода
     * */
    private final InputOutput iO;
    /**
     * новый поток, основанный на классе CountChar
     * */
    private final Thread thread;


    /**
     * вставляем в качестве параметра
     * объект кдасса CountCounter
     * @param countChar -объект типа Runnable
     */
    public Time(CountChar countChar) {
        this.iO = new InputOutput();
        this.thread = new Thread(countChar);

    }

    /**
     * Точка входа в поток,основанный на базе
     * этого класса
     */
    @Override
    public void run() {
        iO.println("запуск потока");
        thread.start();
        try {
            sleep(3000);
        } catch (InterruptedException e) {
           iO.println("завершение потока "+thread.getName());
            thread.interrupt();
        }
    }


}
