package ru.chedmitry.multithreading.threads.thread;

import ru.chedmitry.multithreading.threads.InputOutput.InputOutput;

import static java.lang.Thread.sleep;

/**
 * Created by dimsan on 27.08.17.
 */
public class Time implements Runnable {
    /**
     * параметр ввода
     * */
    private InputOutput iO;
    /**
     * новый поток, основанный на классе CountChar
     * */
    private Thread thread;


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

    /**
     * главный метод
     * @param args
     * @throws InterruptedException
     */
    public static void main(String[] args) throws InterruptedException {
        CountChar countChar = new CountChar("kklklklklk");
        Thread timer = new Thread(new Time(countChar));
        timer.start();
        Thread.sleep(2500);
        timer.interrupt();
    }
}
