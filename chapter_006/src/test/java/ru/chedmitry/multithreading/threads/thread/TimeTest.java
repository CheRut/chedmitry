package ru.chedmitry.multithreading.threads.thread;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Created by dimsan on 27.08.17.
 */
public class TimeTest {
    @Test
    public void run() throws Exception {
        CountChar countChar = new CountChar("kklklklklkлдлдлдлд");
        Thread timer = new Thread(new Time(countChar));
        timer.start();
        Thread.sleep(3000);
        timer.interrupt();
        assertThat(countChar.getCountingOperations(),is(5));


    }

}