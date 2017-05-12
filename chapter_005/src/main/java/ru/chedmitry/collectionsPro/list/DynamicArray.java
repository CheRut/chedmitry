package ru.chedmitry.collectionsPro.list;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class DynamicArray<E> implements Iterable<E> {

    /**
     * контейнер элементов
     */
    private E[] container ;


    /**
     * индек
     * */
    private int index = 0;
    DynamicArrayIterator dynamicArray = new DynamicArrayIterator(container);

    public DynamicArray(int size) {
        this.container = (E[]) new Object[size];

    }

    @Override
    public Iterator<E> iterator() {
        return dynamicArray;
    }
    public <E> E[] resizeContainer() {
        E[]containerBuffer = (E[])Arrays.copyOf(dynamicArray.getObjectsIterator(),
                container.length+1);
        if(!dynamicArray.hasNext()) {
           this.container = Arrays.copyOf(container,containerBuffer.length);
        }
        return (E[])this.container;
    }

    public boolean sizeChecker(E[]cont) {
        return iterator().hasNext()?true:false;
    }

    public void add(E value) {

    resizeContainer();
       // System.out.println(container.length);
    this.container[index++] = value;
    iterator().next();

    }
    public <E> E get(int index) {
        return (E)this.container[index];
    }

}