package ru.chedmitry.multithreading.threads.jmm;



/**
 * @author cheDmitry
 * @since 27.10.2017
 * @version 1.0
 * класс демонстрирует
 * проблемы
 * многопоточности.
 */

public class VisibilityProblems {

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

     synchronized void incrementValue() {
        for (int i = 0; i < 1_000_000; i++) {
            value++;
        }

    }

    /**
     * несинхронизированный метод
     * увеличивает значение на 1.
     */
    void increment() {
        for (int i = 0; i < 1_000_000; i++) {
            unVolatileValue++;
        }
    }

    /**
     * вовращаем значение value
     * @return целое число.
     */
    public int getValue() {
        return value;
    }

    /**
     *
     * @param value - параметр целое число.
     */
    public void setValue(int value) {
        this.value = value;
    }




}
