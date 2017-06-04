package ru.chedmitriy.collectionsPro.list.queue;

import org.junit.Before;
import org.junit.Test;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class QueueContainerTest {
    QueueContainer queueContainer;
    @Before
    public void init(){
        queueContainer = new QueueContainer();
    }

    @Test
    public void element() throws Exception {
    queueContainer.offer("one");
    queueContainer.offer("two");
    assertThat(queueContainer.element(),is("one"));

    }

    @Test
    public void offer() throws Exception {
    queueContainer.offer("1");
    queueContainer.offer("2");
    queueContainer.offer("3");
    assertTrue(queueContainer.offer("one"));
        Iterator it = queueContainer.iterator();
        it.next();
        it.next();
        assertThat(it.next(),is("3"));

    }

    @Test
    public void peek() throws Exception {
        queueContainer.offer("1");
        queueContainer.offer("2");
        queueContainer.offer("3");
        assertThat(queueContainer.peek(),is("1"));
    }

    @Test
    public void poll() throws Exception {

        queueContainer.addLast("1");
        queueContainer.addLast("2");
        queueContainer.addLast("3");

       // System.out.println(queueContainer.pol());
        System.out.println(queueContainer.get(0));
//
//      Queue q = new LinkedList();
//        q.add("1");
//        q.add("2");
//        q.add("3");
//        q.add("4");
//
//        System.out.println(q.peek());
//        System.out.println(q.poll());
//        System.out.println(q.peek());


    }

    @Test
    public void remove() throws Exception {

    }

}