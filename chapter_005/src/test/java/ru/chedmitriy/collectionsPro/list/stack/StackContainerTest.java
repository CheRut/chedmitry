package ru.chedmitriy.collectionsPro.list.stack;

import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class StackContainerTest {
    StackContainer<String> stack;

    @Before
    public void init(){
        stack = new StackContainer<>();
    }

    @Test
    public void whenTryToPushAnElement() throws Exception {
        stack.push("fourth");
        stack.push("third");
        stack.push("second");
        stack.push("first");
        String[] value = {"fourth","third","second","first"};
        int index = 0;
        Iterator it = stack.iterator();
        while(it.hasNext()){
            assertThat(it.next(),is(value[index++]));
        }
    }
    /**
     * сначала добавляем элементы
     * в стэк.Затем извлекаем элементы
     * по принципу LIFO
     * элемент извлекается
     * из контэйнера,
     * его размер уменьшается
     * @throws Exception
     */
    @Test
    public void whenTryToPopTheElement() throws Exception {
        stack.push("fourth");
        stack.push("third");
        stack.push("second");
        stack.push("first");
        stack.pop();
        String[] value = {"fourth","third","second"};
        int index = 0;
        Iterator it = stack.iterator();
        while(it.hasNext()){
            assertThat(it.next(),is(value[index++]));
        }
    }

    @Test
    public void whenTryToCheckTheContainerIsEmpty(){
        assertTrue(stack.empty());
    }
    @Test
    public void whenTryToPeek(){
        stack.push("fourth");
        stack.push("third");
        stack.push("second");
        stack.push("first");
        String value = "first";
        assertThat(stack.peek(),is(value));
    }
    @Test
    public void whenTryToSearchTheElement() {
        stack.push("fourth");
        stack.push("third");
        stack.push("second");
        stack.push("first");
        String value = "third";
        assertThat(stack.search(value),is(3));
    }
}