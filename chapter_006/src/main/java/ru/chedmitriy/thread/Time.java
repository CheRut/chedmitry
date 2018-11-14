package ru.chedmitriy.thread;

import static java.lang.Thread.sleep;

/**
 * ru.chedmitry.multithreading.threads.thread.
 *
 * @author cheDmitry
 * @version 1.0
 * @since 29.10.2017
 * механизм программной
 * остановки потока.
 *
 */

class Time implements Runnable {

    /**
     * новый поток,
     * основанный на классе CountChar.
     * */
    private final Thread thread;


    /**
     * вставляем в качестве параметра
     * объект кдасса CountCounter.
     * @param countChar -объект типа Runnable
     */
    public Time(CountChar countChar) {
        this.thread = new Thread(countChar);

    }

    /**
     * Точка входа в поток,основанный на базе
     * этого класса.
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
