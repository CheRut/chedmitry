package ru.chedmitriy.multithreading.threads.monitor.ex1105;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;



/**
 * ru.chedmitriy.multithreading.threads.monitor.ex1105.
 *
 * @author cheDmitry
 * @version 1.0
 * @since 29.10.2017
 * тестируем класс LinkedListThread
 *
 */
public class LinkedListThreadTest {
    private LinkedListThread listThread;
    private SomeThread someThread;
    private AnotherThread anotherThread;
    @Before
    public void init() throws InterruptedException {
        listThread = new LinkedListThread();
        someThread = new SomeThread(listThread);
        someThread.setName("1");
        anotherThread = new AnotherThread(listThread);
        someThread.start();
        anotherThread.start();
        someThread.join();
        anotherThread.join();
    }


    /**
     * Тестируем метод
     * LinkedListThread#getNext(),
     * а также проверяем первый элемент списка
     * - т.е метод
     * LinkedListThread#addFirst().
     *
     * @throws NullPointerException
     */
    @Test
    public void getNext() throws Exception {
        String getFirstValue = (String)listThread.getNext(1);
       assertTrue(getFirstValue.equals("twenty")
       || getFirstValue.equals("thirty"));
    }

    /**
     * Тестируем метод
     * LinkedListThread#remove(),
     * а также проверяем последний добавленный элемент
     * - т.е метод
     * LinkedListThread#addLast()
     *
     * @throws NullPointerException
     */
    @Test
    public void remove() throws Exception {
        String removingValue = listThread.remove();
        assertTrue(removingValue.equals("six")
        || removingValue.equals("three"));

    }

    @Test
    public void getSize() throws Exception {
        assertThat(listThread.getSize(), is(8));
    }

}
class SomeThread extends Thread{
    private final LinkedListThread list;
    SomeThread(LinkedListThread list){
        this.list = list;
    }

    @Override
    public void run() {
        list.addLast("one");
        list.addLast("two");
        list.addLast("three");
        list.addFirst("thirty");

    }

}
class AnotherThread extends Thread{
    private final LinkedListThread list;
    AnotherThread(LinkedListThread list){
        this.list = list;
    }

    @Override
    public void run() {
        list.addLast("four");
        list.addLast("five");
        list.addLast("six");
        list.addFirst("twenty");


    }
}

