package ru.chedmitriy.collectionsPro.IteratorAndDoubleArray.iteratorForDobArray;

import java.util.Iterator;

/**
 * Демонстрация работы метода next()
 * и hasNext();
 * интерфейса Iterator
 * с двумерными массивами
 * */
public class IteratorExample implements Iterator {
    int counter =0;
    /**
     * массив целых чисел.
     * */
    private final int[][] array;
    /**
     * парамет "строки" массива
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

        return counter < array.length*array[index].length;
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
        this.counter++;
        if(col==array[index].length){
            col = 0;
            if(index<array.length)
            index++;
        }
        int i = col;
        int t = index;
        col++;
        return array[t][i];
    }

   }

