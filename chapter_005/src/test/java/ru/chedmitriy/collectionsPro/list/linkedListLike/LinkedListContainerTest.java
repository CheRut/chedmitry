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
        aC.add("first");
        aC.add("ok");
        aC.add("one");
        aC.add("sss");
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
        aC.add("ok");
        aC.add("one");
        String value ="one";
        assertThat(aC.get(1),is(value));
    }

}