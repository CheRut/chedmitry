package ru.chedmitry.collectionsPro.list;

import java.util.Arrays;
import java.util.Iterator;

public class DynamicArrayIterator<E> implements Iterator<E> {
    E[] objectsIterator;

    public E[] getObjectsIterator() {
        return objectsIterator;
    }

    public void setObjectsIterator(E[] objectsIterator) {
        this.objectsIterator = objectsIterator;
    }

    private int indexPosition;
    private final int CAPACITYUPONTENPOSITIONS = 10;

    public DynamicArrayIterator(E[] objectsIterator){
        this.objectsIterator = objectsIterator;
    }

    @Override
    public boolean hasNext() {
        
      return this.objectsIterator.length > indexPosition;

    }

    @Override
    public E next() {
        return this.objectsIterator[indexPosition++];
    }
}
