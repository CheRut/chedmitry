package ru.chedmitry.multithreading.threads.monitor.ex1102;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

/**
 * @author cheDmitry
 * @since 27.10.2017
 * @version 1.0
 * в данном классе демонстрируется
 * работа блокировки объекта класса,
 * а также применены аннотации @ThreadSafe
 * и @GuardedBy
 */
@ThreadSafe
class Count {

    /**
     * класс - инкремент
     */
    public static final class Incrementer {
        int count = 0;

        @GuardedBy("count")
        public synchronized void increment() {
                count++;

        }
    }

    /**
     * класс  - поток,который непсредственно
     * сможет работать с объектом блокировки
     *
     */
    public static final class CounterThread extends Thread {
        /**
         * объет блокировки
         */
        final Incrementer incrementer;

        /** конструктор потока
         * @param incrementer объект класса Incrementer
         *                он же объект блокировки
         */
        public CounterThread(final Incrementer incrementer) {
            this.incrementer = incrementer;
        }
        /**
         * в методе производится вызов метода
         * 9 млн. раз.При спользовании
         * блокировки любой поток, вызвавший
         * метод будет ожидать своей очереди,
         * после чего,сможет работать с объектом
         * класса
         * */
        @Override
        public void run() {
            for (int i = 0; i < 9_000_000; i++) {
                incrementer.increment();
            }
        }
    }

}
