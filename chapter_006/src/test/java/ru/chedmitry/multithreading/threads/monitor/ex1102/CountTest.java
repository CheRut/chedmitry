package ru.chedmitry.multithreading.threads.monitor.ex1102;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * @author cheDmitry
 * @since 27.08.2017
 * @version 1.0
 * в данном классе
 * тестирется класс Count
 */
public class CountTest {
    private Count.Incrementer incrementer;
    private Thread threadA;
    private Thread threadB;
    @Before
    public void initData() {
        incrementer = new Count.Incrementer();
        threadA = new Count.CounterThread(incrementer);
        threadB = new Count.CounterThread(incrementer);
    }
    @Test
    public void whenTreadsIsRunning() throws InterruptedException {
            threadA.start();
            threadB.start();
            threadA.join();
            threadB.join();
            assertThat(incrementer.count, is(18000000));

    }
}