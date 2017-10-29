package ru.chedmitry.multithreading.threads.monitor.ex1105;

import org.junit.Before;
import org.junit.Test;
import ru.chedmitry.multithreading.threads.monitor.ex1105.arrayListLike.DynamicArrayThread;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;


/**
 * ru.chedmitry.multithreading.threads.monitor.ex1105
 *
 * @author cheDmitry
 * @version 1.0
 * @since 28.10.2017
 */
public class ListThreadTest {
    DynamicArrayThread listThread;
    ThreadOne t1;
    ThreadTwo t2;
    @Before
    public void init() throws InterruptedException {
        listThread = new DynamicArrayThread(5);
        t1 = new ThreadOne(listThread);
        t1.setName("firstThread");
        t2 = new ThreadTwo(listThread);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
    }
    @Test
    public void whenNewStringWasAdded() throws Exception {
        assertTrue((listThread.getArray().get(0).equals("one")) ||
                listThread.getArray().get(0).equals("four"));
    }
    @Test
    public void whenSizeIsChanging() throws Exception {
        assertThat(listThread.getArray().size, is(6));
    }

}
class ThreadOne extends Thread {
    private final DynamicArrayThread listThread;


    ThreadOne(DynamicArrayThread listThread) {
        super();
        this.listThread = listThread;
    }

    @Override
    public void run() {
        listThread.add("one");
        listThread.add("two");
        listThread.add("three");
    }
}

class ThreadTwo extends Thread {
    private final DynamicArrayThread listThread;
    ThreadTwo(DynamicArrayThread listThread) {
        super();
        this.listThread = listThread;
    }

    @Override
    public void run() {
        listThread.add("four");
        listThread.add("five");
        listThread.add("six");


    }
}