package ru.chedmitriy.generic.simplelistarray;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class SimpleListTest {

    SimpleList<String> simpleList;
    @Before
    public void init() {
        simpleList = new SimpleList(4);
        simpleList.add("Hello");
        simpleList.add("for deleting");
        simpleList.add("for updating");
        simpleList.add("for getting");
    }



    @Test
    public void whenTheNewValueAdding() throws Exception {

        String valueResult = simpleList.get(0);
        assertThat(valueResult, is("Hello"));
    }

    @Test
    public void update() throws Exception {

        simpleList.update(2, "UPDATE");
        String valueResult = simpleList.get(2);
        assertThat(valueResult, is("UPDATE"));
    }

    @Test
    public void delete() throws Exception {
        simpleList.delete(1);
        String valueResult = null;
        assertNull(valueResult);

    }

    @Test
    public void get() throws Exception {
        String resultValue = simpleList.get(3);
        assertThat(resultValue, is("for getting"));

    }

}