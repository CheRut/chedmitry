package ru.chedmitriy.collectionsPro.set.linkedListBasedSet;

import org.junit.Test;

import java.util.Iterator;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
        /* При тестировании метода
        * add пытаюсь повторно добавить
        * существующие элементы
        * на выходе видим,что они не добавились,
        * следовательно в контейнере
        * только уникальные значения
        * */
public class SetLinkedListTest {

    @Test
    public void add() throws Exception {
        SetLinkedList<String>setLinkedList = new SetLinkedList();
        setLinkedList.add("one");
        setLinkedList.add("two");
        setLinkedList.add("three");
        setLinkedList.add("one");
        setLinkedList.add("four");
        setLinkedList.add("two");
        String[]value ={"one","two","three","four"};
        int index = 0;
        Iterator it = setLinkedList.iterator();
        while (it.hasNext()){
            assertThat(it.next(),is(value[index++]));
        }

    }

}

