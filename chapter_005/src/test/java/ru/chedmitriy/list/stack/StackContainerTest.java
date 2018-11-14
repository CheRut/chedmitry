package ru.chedmitriy.list.stack;

import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Created by d1msan on 31.05.2017.
 */
public class StackContainerTest {
    StackContainer sC;

    @Before
    public void init() {
        sC = new StackContainer();
        sC.addLast("one");
        sC.addLast("two");
        sC.addLast("three");


    }
    @Test
    public void whentrytopeek() {
        assertThat(sC.peek(), is("three"));
    }

    @Test
    public void whentrytopop() {
        assertThat(sC.pop(), is("three"));
        assertThat(sC.getSize(), is(2));
        String[] stringList = {"one", "two"};
        int indexCounter = 0;
        Iterator it = sC.iterator();
        while (it.hasNext()) {
            assertThat(it.next(), is(stringList[indexCounter]));
            indexCounter++;
        }
    }

    @Test
    public void whentrytopush() {
        sC.push("four");
        sC.push("five");
        sC.push("six");

        String[] stringList = {"one", "two", "three", "four", "five", "six"};
        int indexCounter = 0;
        Iterator it = sC.iterator();
        while (it.hasNext()) {
            assertThat(it.next(), is(stringList[indexCounter]));
            indexCounter++;
        }
    }

    @Test
    public void whentryingsearching() {
        assertThat(sC.search("one"), is(2));
    }
    @Test
    public void wnentrytocheckavailabilityofelements() {
        StackContainer st = new StackContainer();
        assertTrue(st.isEmpty());
        assertFalse(sC.isEmpty());

    }
}