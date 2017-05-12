package ru.chedmitry.collectionsPro.list;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DynamicArrayTest {
    DynamicArray<Integer>dynamicArray;
    @Before
    public void init(){
        dynamicArray = new DynamicArray(2);
        dynamicArray.add(1);
        dynamicArray.add(2);

    }
    @Test
    public void add() throws Exception {
        dynamicArray.add(1);
        dynamicArray.add(2);


    }

    @Test
    public void get() throws Exception {
        dynamicArray.get(0);
    }

}