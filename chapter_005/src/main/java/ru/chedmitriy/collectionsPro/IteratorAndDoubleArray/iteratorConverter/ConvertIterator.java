package ru.chedmitriy.collectionsPro.IteratorAndDoubleArray.iteratorConverter;

import java.util.*;
/**
 * класс конвертор Iterator<Iterator<Integer>> в
 * Iterator<Integer>
 *
 * */
public class ConvertIterator implements IteratorConverterInterface{
    /**
     * Итератор Итератора
     * */
    private  Iterator<Iterator<Integer>> iteratorOfIterator;
    /**
     * Итератор получаем после конвертации
     * */
    private Iterator<Integer> resultItertor;
    /**
     * некоторый список значений
     * */
    private final List<Integer> listOne = new ArrayList<>(Arrays.asList(4,2,0,4,6,4,9));
    /**
     * некоторый список значений
     * */
    private final List<Integer>listTwo = new ArrayList<>(Arrays.asList(0,9,8,7,5));
    /**
     * некоторый список значений
     * */
    private final List<Integer>listThree = new ArrayList<>(Arrays.asList(1,3,5,6,7,0,9,8,4));
    /**
     * конструктор по умолчанию
     *
     * */
    public ConvertIterator()  {

    }
    /**
     * метод создает итератор итераторов
     * списков значений
     * */
    public void doubleListIterator() {
        List<Iterator<Integer>> combinedList =
                new ArrayList<>(Arrays.asList(listOne.iterator(),
                        listTwo.iterator(),
                        listThree.iterator()));
        this.iteratorOfIterator = combinedList.iterator();

    }
    /**
     * @return - итератор итераторов
     *
     * */
    public Iterator<Iterator<Integer>> getIteratorOfIterator() {
        return iteratorOfIterator;
    }
    /**
     * Метод получает итератор итераторов
     * и возвращает итератор целых чисел
     * @param it - итератор итераторов
     * @return resultIterator - итератор целых чисел.
     *
     * */
    @Override
    public Iterator<Integer> convert(Iterator<Iterator<Integer>> it) {
        int size = 0;
        while (resultItertor == null || !resultItertor.hasNext()) {
            resultItertor = iteratorOfIterator.next();
        }
        return resultItertor;
    }
    /**
     * Метод проверки на наличие
     * следующего элемента
     * */
    @Override
    public boolean hasNext() {

        while (resultItertor == null || !resultItertor.hasNext()) {
            if (!iteratorOfIterator.hasNext()) return false;
            resultItertor = iteratorOfIterator.next();
        }
        return true;
    }

    @Override
    public Object next() {
        return resultItertor.next();
    }

    public Iterator<Integer> getResultItertor() {
        return resultItertor;
    }
}
