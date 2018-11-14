package ru.chedmitriy.iteratorandcoublearray.iteratorconverter;

import java.util.Iterator;

/**
 * реализуем интерфейс,определим метод
 * convert для Iterator<Iterator<Integer>>
 *
 */
public class IteratorConverterImplement implements IteratorConverterInterface {

    /**
     *
     * @param it - итератор итератора целых чисел
     * @return возвращаем итератор
     */
    @Override
    public Iterator<Integer> convert(Iterator<Iterator<Integer>> it) {
        return new ConvertIterator<>(it);
    }
}
