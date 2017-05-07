package ru.chedmitriy.IteratorAndDoubleArray;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Демонстрация работы метода next()
 * и hasNext();
 * интерфейса Iterator
 * с двумерными массивами
 * */
public class IteratorExample implements Iterator {
    /**
     * массив целых чисел.
     * */
    private final int[][] array;
    /**
     * парамет "строки массива"
     * */
    private int index = 0;
    /**
     * параметр "столбцы" массива
     * */
    private  int col = 0;
    /**
     * Конструктор,принимающий
     * в качестве параметра двумерный массив
     * @param array - двумерный
     *              массив целых чисел;
     *
     * */
    public IteratorExample(int[][] array) {
        this.array = array;
    }

    /**
     *
     * Переопределенный метод,
     * определяющий наличие следующего
     * элемента в массиве
     * @return - true, если количество
     * столбцов и строк принадлежат области
     * определения
     *
     * */
    @Override
    public boolean hasNext() {
        return index < array.length && col <array.length  ;
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
        if(col==array[index].length){
            col = 0;
            if (index<=array.length-1)
            index++;
        }
        int i = col;
        int t = index;
        col++;
        System.out.println(array[t][i]);
        return array[t][i];
    }

   }

