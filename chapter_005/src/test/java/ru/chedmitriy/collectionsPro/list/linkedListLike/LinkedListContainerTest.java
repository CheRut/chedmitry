package ru.chedmitriy.collectionsPro.list.linkedListLike;

import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class LinkedListContainerTest {
    LinkedListContainer<String> aC;
    @Before
    public void init(){
        aC = new LinkedListContainer<>();
    }
    @Test
    public void add() {
        aC.addLast("first");
        aC.addLast("ok");
        aC.addLast("one");
        aC.addLast("sss");
        String[] value = {"first","ok","one","sss"};
        int index =0;
        Iterator it = aC.iterator();
        while (it.hasNext()){
            assertThat(it.next(),is(value[index]));
            index++;
        }
    }
    @Test
    public void get() throws Exception {
        aC.addLast("ok");
        aC.addLast("one");
        String value ="one";
        assertThat(aC.getNext(1),is(value));
    }

}