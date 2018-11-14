package ru.chedmitriy.iteratorandcoublearray.iteratorconverter;

import java.util.Iterator;

public interface IteratorConverterInterface  {
    /**
     * .
     * Метод конвертирует несколько объектов
     * типа Iterator в один
     * @return полученный объект
     * */
    Iterator<Integer> convert(Iterator<Iterator<Integer>> it);
}
