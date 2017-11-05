package ru.chedmitriy.multithreading.threads.monitor.ex1105;

import org.junit.Before;
import org.junit.Test;
import ru.chedmitriy.collectionsPro.exceptions.CatchArrayOutOfBoundException;


import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;


/**
 * ru.chedmitriy.multithreading.threads.monitor.ex1105
 *
 * @author cheDmitry
 * @version 1.0
 * @since 28.10.2017
 */
public class ListThreadTest {
    private DynamicArrayThread listThread;
    private ThreadOne t1;
    private ThreadTwo t2;
    @Before
    public void init() throws InterruptedException, CatchArrayOutOfBoundException {
        listThread = new DynamicArrayThread(5);
        t1 = new ThreadOne(listThread);
        t1.setName("firstThread");
        t2 = new ThreadTwo(listThread);
        listThread.add("one");
        listThread.add("two");
        listThread.add("three");
        listThread.add("four");
        listThread.add("five");
        listThread.add("six");
        t1.start();
        t2.start();
        t1.join();
        t2.join();


    }
    @Test
    public void whenNewStringWasAdded() throws Exception {
        assertTrue((listThread.getArray().get(6).equals("new_2"))
                || listThread.getArray().get(6).equals("new_1"));
    }
    @Test
    public void whenSizeIsChanging() throws Exception {
        assertThat(listThread.getSize(), is(8));
    }
    @Test
    public void whenTryToGetArrayValue() throws CatchArrayOutOfBoundException {
        assertTrue(listThread.getCloneArray().get(0).equals("one")
                && listThread.getCloneArray().get(1).equals("two")
                || listThread.getCloneArray().get(0).equals("five")
                && listThread.getCloneArray().get(1).equals("six"));

    }

}
@SuppressWarnings("unchecked")
class ThreadOne extends Thread {
    private final DynamicArrayThread listThread;

    ThreadOne(DynamicArrayThread listThread) {
        super();
        this.listThread = listThread;
    }

    @Override
    public void run() {
        listThread.add("new_2");

        try {
            listThread.getCloneArray().add(listThread.get(0));
            listThread.getCloneArray().add(listThread.get(1));
        } catch (CatchArrayOutOfBoundException e) {
            e.printStackTrace();
        }
    }
}

class ThreadTwo extends Thread {
    private final DynamicArrayThread listThread;
    ThreadTwo(DynamicArrayThread listThread) {
        super();
        this.listThread = listThread;
    }
    @SuppressWarnings("unchecked")
    @Override
    public void run() {
        listThread.add("new_1");
        try {
            listThread.getCloneArray().add(listThread.get(4));
            listThread.getCloneArray().add(listThread.get(5));
        } catch (CatchArrayOutOfBoundException e) {
            e.printStackTrace();
        }
    }
}