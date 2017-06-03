package ru.chedmitriy.collectionsPro.list.queue;

import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;


import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;

/**
 * Created by d1msan on 02.06.2017.
 */
public class QueueContainerTest<E> {
    private QueueContainer queueContainer;
    private String[] queListForOfferMethod;
    private  Integer[] queIntListForRemoveMethod;
    private  String[] queListForPollMEthod;
    private  Iterator it;

private void arrayEqualing(E[] array){
    int indexPosition = 0;
    while(it.hasNext()){
        assertThat(it.next(),is(array[indexPosition]));
        indexPosition++;
    }
}
    @Before
    public void init(){
        queueContainer = new QueueContainer();
        queListForOfferMethod = new String[]{"six","five","four","three","two","one"};
        queIntListForRemoveMethod = new Integer[]{1,2,3};
        queListForPollMEthod = new String[]{"one","two"};
        it = queueContainer.iterator();
    }

    @Test
    public void offer() throws Exception {
        queueContainer.offer("four");
        queueContainer.offer("five");
        queueContainer.offer("six");
        arrayEqualing((E[]) queListForOfferMethod);
    }

    @Test(expected = NoSuchElementException.class)
    public void remove(){
        queueContainer.offer(4);
        queueContainer.offer(3);
        queueContainer.offer(2);
        queueContainer.offer(1);
        queueContainer.remove();
        arrayEqualing((E[])queIntListForRemoveMethod);
        QueueContainer quCont = new QueueContainer();
        quCont.remove();
    }

    @Test
    public void poll() throws Exception {

        queueContainer.offer("three");
        queueContainer.offer("two");
        queueContainer.offer("one");
        queueContainer.poll();
        arrayEqualing((E[]) queListForPollMEthod);
        QueueContainer quCont = new QueueContainer();
        assertNull(quCont.poll());
    }

    @Test
    public void element() throws Exception {
        queueContainer.offer("one");
        queueContainer.offer("two");
        queueContainer.offer("three");
        assertThat(queueContainer.element(),is("one"));
        QueueContainer quCont = new QueueContainer();
        assertNull(quCont.element());

    }

    @Test(expected = NoSuchElementException.class)
    public void peek() throws Exception {
        queueContainer.offer("four");
        queueContainer.offer("five");
        queueContainer.offer("six");
        assertThat(queueContainer.peek(),is("four"));
        QueueContainer quCont = new QueueContainer();
        quCont.peek();
    }

}