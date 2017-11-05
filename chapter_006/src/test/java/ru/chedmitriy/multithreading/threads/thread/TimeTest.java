package ru.chedmitriy.multithreading.threads.thread;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * @author cheDmitry
 * @since 27.08.2017
 * @version 1.0
 * в данном классе
 * тестируется класс Time
 *
 */
public class TimeTest {
    @Test
    public void run() throws Exception {
        CountChar countChar = new CountChar();
        Thread timer = new Thread(new Time(countChar));
        timer.start();
        Thread.sleep(3000);
        timer.interrupt();
        assertThat(countChar.getCountingOperations(), is(5));
    }

}