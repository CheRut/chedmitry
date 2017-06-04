package ru.chedmitriy.collectionsPro.list.arrayListLike;

import java.util.Iterator;

/**
 * Created by dimsan on 13.05.2017.
 */
public class ArrayIterator<E> implements Iterator<E> {
    E[] objectsIterator;

    private int indexPosition;

    public ArrayIterator(E[] objectsIterator){
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
