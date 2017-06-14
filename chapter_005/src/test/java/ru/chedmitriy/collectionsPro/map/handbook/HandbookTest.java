package ru.chedmitriy.collectionsPro.map.handbook;

import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Created by d1msan on 13.06.2017.
 */
public class HandbookTest {
    Handbook<Integer,String> hb;
    @Before
    public void init(){
        hb = new Handbook(4);
    }
    @Test
    public void insert() throws Exception {
        hb.insert(1,"one");
        hb.insert(2,"two");
        hb.insert(3,"three");
        hb.insert(4,"four");
        for (int i = 0; i <hb.mapDataBase.length ; i++) {
            System.out.println(hb.mapDataBase[i].getKey());
        }

    }

    @Test
    public void get() throws Exception {
        hb.insert(1,"one");
        hb.insert(2,"two");
        hb.insert(3,"three");
        hb.insert(4,"four");
        String value = "two";
        hb.get(1);
        assertThat(value,is(hb.get(2)));
    }

    @Test
    public void delete() throws Exception {
        hb.insert(1,"one");
        hb.insert(2,"two");
        hb.insert(3,"three");
        hb.insert(4,"four");
        hb.delete(3);
    }

}