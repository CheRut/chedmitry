package ru.chedmitriy.iteratorandcoublearray.iteratorconverter;

import java.util.*;
/**
 * класс конвертор Iterator<Iterator<Integer>> в
 * Iterator<Integer>
 *
 * */
public class ConvertIterator<T> implements Iterator {
    /**
     * параметр Итератор Итератора
     *
     * */
    private final Iterator<Iterator<T>> iterator;
    /**
     * параметр текущий Итератор
     * */
    private Iterator<T> currentIterator = null;

    /**
     * конструктор принимает Итератор итератора
     * @param iterator - принимаемый итератор итератора
     */
    public ConvertIterator(Iterator<Iterator<T>> iterator) {
        this.iterator = iterator;
    }

    /**
     * переопределяем метод
     * @return true, если текущий итератор не равен null
     * и в текущем итераторе имеется следующее значение
     */
    @Override
    public boolean hasNext() {
        selectCurrentIterator();
        return (currentIterator != null && currentIterator.hasNext());
    }

    /**
     * @throws NoSuchElementException - если текущий
     * итератор null - исключение
     * @return - следующий элемнт текущего итератора
     */
    @Override
    public T next() {
        selectCurrentIterator();
        if (currentIterator == null) {
            throw new NoSuchElementException();
        }
        return currentIterator.next();
    }

    /**
     * Суть данного метода заключается
     * в том, что мы создаем итератор
     * в котором может содержаться
     * разное количество итераторов.
     * а значению currentIterator мы присваиваем
     * значение каждого итератора поочереди,пока
     * новый currentIterator имеет элементы.
     * return в первом условии нас выбрасывает из метода до тех
     * пор,пока условие не перестанет выполняться.
     * В это время будут повторяться выполненния методов
     * hasNext() и next() для каждого итератора

     */
    private void selectCurrentIterator() {
        if (currentIterator != null && currentIterator.hasNext()) {
            return;
        }
        currentIterator = null;
        while (iterator.hasNext()) {
            Iterator<T> nextIterator = iterator.next();
            if (nextIterator.hasNext()) {
                currentIterator = nextIterator;
                break;
            }
        }
    }


}

