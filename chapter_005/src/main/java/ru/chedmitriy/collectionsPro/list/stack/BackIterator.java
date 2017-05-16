package ru.chedmitriy.collectionsPro.list.stack;

import java.util.Iterator;
/**
 * Данный интерфейс
 * - итератор перебирает
 * элементы с конца
 * */
public interface BackIterator<E> {
    /**
     * @return Iterator<E>
     */
    Iterator<E> backIterator();
}
