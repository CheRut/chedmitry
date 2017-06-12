package ru.chedmitriy.collectionsPro.IteratorAndDoubleArray.iteratorConverter;

import java.util.Iterator;

public interface IteratorConverterInterface  {
    /**
     * .
     * Метод конвертирует несколько объектов
     * типа Iterator в один
     * @return полученный объект
     * */
    Iterator<Integer> convert (Iterator<Iterator<Integer>> it);
}
