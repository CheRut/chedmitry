package ru.chedmitry.multithreading.threads.thread;

import ru.chedmitry.multithreading.threads.io.InputOutput;

import static java.lang.Thread.sleep;

/**
 * @author - cheDmitry
 * @since 27.08.2017
 * @version - 1.0
 */

class Time implements Runnable {

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
        this.thread = new Thread(countChar);

    }

    /**
     * Точка входа в поток,основанный на базе
     * этого класса
     */
    @Override
    public void run() {
        thread.start();
        try {
            sleep(3000);
        } catch (InterruptedException e) {
            thread.interrupt();
        }

    }


}
