package ru.chedmitriy.multithreading.threads.jmm;



/**
 * package ru.chedmitriy.multithreading.threads.jmm
 *
 * @author cheDmitry.
 * @since 27.10.2017
 * @version 1.0
 *
 * класс демонстрирует
 * проблемы
 * многопоточности.
 */


class VisibilityProblems {

    /**
     * цикл в 1 млн. проходов.
     */
    private final int loop = 1_000_000;

    /**
     * параметр типа int.
     */
    private volatile int value = 0;

    /**
     * параметр типа int.
     */
    private int unVolatileValue = 0;

    /**
     * синхронизированый метод
     * увеличивает значение параметра на 1.
     */

     final synchronized void incrementValue() {
        for (int i = 0; i < loop; i++) {
            value++;
        }

    }

    /**
     * несинхронизированный метод
     * увеличивает значение на 1.
     */
   final void increment() {
        for (int i = 0; i < loop; i++) {
            unVolatileValue++;
        }
    }

    /**
     * вовращаем значение value.
     * @return целое число.
     */
    public final int getValue() {
        return value;
    }


}
