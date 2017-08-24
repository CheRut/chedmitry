package ru.chedmitriy.collectionsPro.IteratorAndDoubleArray.iteratorForDobArray;

import java.util.Iterator;

/**
 * Демонстрация работы метода next()
 * и hasNext();
 * интерфейса Iterator
 * с двумерными массивами
 * */
public class IteratorExample implements Iterator {

    /**
     * Счетчик элементов
     */
    private int counter =0;
    /**
     * массив целых чисел.
     * */
    private final int[][] array;

    /**
     * параметр "столбцы" массива
     * */
    private  int columns = 0;

    /**
     * параметр "строки" массива
     * */
    private int rows = 0;

    /**
     * Конструктор,принимающий
     * в качестве параметра двумерный массив
     * @param array - двумерный
     *              массив целых чисел;
     *
     * */

    public IteratorExample(final int[][] array) {
        this.array = array ;
    }

    /**
     *
     * Переопределенный метод,
     * определяющий наличие следующего
     * элемента в массиве
     *
     * @return - true, если количество
     * столбцов и строк принадлежат области
     * определения
     *
     * */
    @Override
    public boolean hasNext() {
        if(columns == array[0].length){
            rows++;
            columns = 0;
        }
        return counter < array.length*array[0].length;
    }

    /**
     * Переопределенный метод
     * позволяющий перебирать индексы массива
     * @return - значение элемента
     * массива,которое соответствует
     * индексам.
     *
     * */
    @Override
    public Integer next() {
        counter++;
     return  array[rows][columns++];
    }
   }

