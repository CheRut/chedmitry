package ru.chedmitriy.IteratorAndDoubleArray.evenSearching;

import java.util.Iterator;
/**
 * Класс - демонстрирует
 * применение итератора
 * Отображаются только четные числа
 * некоторого
 * массива
 *
 * */
public class SearchForEvenValues implements Iterator {
    /**
     * Переменная
     * - массив целых чисел
     * */
    private final int[] arr;

    /**
     * Параметр индекса
     * элемента массива
     * */
    private int indexPosition = 0;
    /**Конструктор класса
     * @param arr - пердаваемый параметр -
     * массив целых чисел
     * */
    public SearchForEvenValues(int[] arr) {
        this.arr = arr;
    }
    /**
     * Метод проверяет наличие
     * следующего элемента
     * в массиве
     * */

    @Override
    public boolean hasNext() {
        return  indexPosition < arr.length;
    }
    /**
     * Метод возвращает
     * четные числа массива
     *
     * */
    @Override
    public Integer next() {
        int t = indexPosition;
        indexPosition++;
        return arr[t] % 2 == 0 ? arr[t] : next();
    }
}
