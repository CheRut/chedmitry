package ru.chedmitriy.collectionsPro.map.handbook;

import java.util.Iterator;

/**
 * Created by d1msan on 18.06.2017.
 */
public class Client<T,V> implements Iterator<T> {
    T key;
    V value;
    public T[]keySet;
    int position = 0;

    public Client(T key, V value) {
        this.key = key;
        this.value = value;

    }

    public T getKey() {
        return key;
    }

    public void setKey(T key) {
        this.key = key;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }

    @Override
    public boolean hasNext() {
        return this.keySet.length>position;
    }

    @Override
    public T next() {
        return this.keySet[position++];
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Client<?, ?> client = (Client<?, ?>) o;

        return key != null ? key.equals(client.key) : client.key == null;
    }

    @Override
    public int hashCode() {
        return key != null ? key.hashCode() : 0;
    }
}
