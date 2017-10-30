package ru.chedmitry.multithreading.threads.monitor.ex1105.arrayListLike;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * junior
 *
 * @author CheDmitry
 * @version 1.0
 * @since 30.10.17
 */
public class LinkedListThreadTest {
    LinkedListThread listThread;
    SomeThread someThread;
    AnotherThread anotherThread;
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

    @Test
    public void addLast() throws Exception {
    }

    @Test
    public void addFirst() throws Exception {
        for (int i = 0; i <listThread.getSize() ; i++) {
            System.out.println(listThread.getNext(i));
        }
    }

    @Test
    public void getNext() throws Exception {
    }

    @Test
    public void remove() throws Exception {
    }

    @Test
    public void getSize() throws Exception {
    }

}
class SomeThread extends Thread{
    private final LinkedListThread list;
    SomeThread(LinkedListThread list){
        this.list = list;
    }

    @Override
    public void run() {
        list.addFirst("one");
        list.addFirst("two");
        list.addFirst("three");

    }

}
class AnotherThread extends Thread{
    private final LinkedListThread list;
    AnotherThread(LinkedListThread list){
        this.list = list;
    }

    @Override
    public void run() {
        list.addFirst("four");
        list.addFirst("five");
        list.addFirst("six");

    }
}