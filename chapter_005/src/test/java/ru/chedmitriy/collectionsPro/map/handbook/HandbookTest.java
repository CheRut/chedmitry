package ru.chedmitriy.collectionsPro.map.handbook;

import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Created by d1msan on 01.07.2017.
 */
public class HandbookTest {
    Handbook<Integer,String> hb;
    @Before
    public void init(){
        hb = new Handbook<>();

    }
    @Test
    public void insert() throws Exception {
        hb.insert(1,"one");
        hb.insert(2,"two");
        hb.insert(3,"three");
        hb.insert(4,"four");
        hb.insert(4,"four");
        hb.insert(2,"two");
        hb.insert(3,"three");
        hb.insert(6,"six");
        String[] values = {"one","two","three","four","six"};
        int index =0;
        for (String val:hb){
            if(val!=null){
                assertThat(val,is(values[index++]));
            }
        }
    }

    @Test
    public void delete() throws Exception {
        hb.insert(1,"one");
        hb.insert(2,"two");
        hb.insert(3,"three");
        hb.insert(4,"four");
        hb.insert(6,"six");
        hb.delete(4);
        String[] values = {"one","two","three","six"};
        int index =0;
        for (String val:hb){
            if(val!=null){
                assertThat(val,is(values[index++]));
                assertThat(hb.size(),is(4));
            }
        }
        //пробуем удалить по несуществующему ключу
        assertFalse(hb.delete(5));
    }

    @Test
    public void get() throws Exception {
        hb.insert(1,"one");
        hb.insert(2,"two");
        hb.insert(3,"three");
        hb.insert(4,"four");
        String value = "three";
        assertThat(hb.get(3),is(value));
        //попробуем достать несуществующий ключ
        assertNull(hb.get(5));
    }

    @Test
    public void size() throws Exception {
        hb.insert(1,"one");
        hb.insert(2,"two");
        hb.insert(3,"three");
        hb.insert(4,"four");
        hb.insert(5,"five");
        hb.insert(6,"six");
        hb.insert(7,"seven");
        hb.insert(8,"eight");
        hb.insert(9,"nine");
        hb.insert(10,"ten");
        assertThat(hb.getCapacity(),is(16));
        hb.insert(11,"eleven");
        hb.insert(12,"twelve");
        assertThat(hb.getCapacity(),is(32));
    }
}