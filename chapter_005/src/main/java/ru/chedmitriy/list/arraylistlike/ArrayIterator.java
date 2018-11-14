package ru.chedmitriy.list.arraylistlike;

import java.util.Iterator;

/**
 * Created by dimsan on 13.05.2017.
 * Класс Итератор
 */
public class ArrayIterator<E> implements Iterator<E> {
    /**
     * массив элементов
     * */
    public E[] objectsIterator;
    /**
     * параметр позиции элементов
     * */
    private int indexPosition;

    /**
     * конструктор принимающий
     * массив элементов
     * @param objectsIterator -
     *                        принимаемый массив элементов
     */
    public ArrayIterator(E[] objectsIterator) {
        this.objectsIterator = objectsIterator;
    }

    /**
     * @return true вернется только в том случае
     * если позиция элемента
     * меньше размера массива
     */
    @Override
    public boolean hasNext() {
        return this.objectsIterator.length > indexPosition;

    }

    /**
     * @return возвращаем элемент по индексу
     * и инкрементируем параметр индекса
     */
    @Override
    public E next() {
        return (E) this.objectsIterator[indexPosition++];
    }

}
