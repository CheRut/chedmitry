package ru.chedmitriy.collectionsPro.IteratorAndDoubleArray.primeNumbers;

import java.util.Iterator;

/**
 *
 * Класс для поиска простых
 * чисел в некотором массиве
 * */

public class PrimeNumber implements Iterator{

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
    public PrimeNumber(final int[] arr) {
        this.arr = arr;
    }
    /**
     * Метод проверяет наличие
     * следующего элемента
     * в массиве
     * */
    @Override
    public boolean hasNext() {
        int limit = arr.length - 1;
        boolean result = false;
        if (primeNumberChecker(arr[limit])) {
            result = indexPosition < arr.length;
        }
        else if (!primeNumberChecker(arr[limit])) {
            while (!primeNumberChecker(arr[limit])) {
                limit--;
            }
            result = indexPosition < limit+1;
        }
        if (limit == 0) {
            result = indexPosition == limit;
        }
        return result;
    }
    /**
     * Метод возвращает
     * простые  числа массива
     *
     * */
    @Override
    public Object next() {
        int t = indexPosition;
        indexPosition++;
        return primeNumberChecker(arr[t]) ? arr[t]:next();
    }

    /**
     *
     * Вспомогательный метод
     * содержит свойства простых
     * чисел
     * @param number - передаваемое
     *               для проверки число
     * */
    public boolean primeNumberChecker(int number) {
        for(int i=2;i<number;i++) {
            if(number%i==0)
                return false;
        }

        return true;

    }

    /**
     * Возвращаемый массив;
     *
     * */
    public int[] getArr() {
        return arr;
    }
}
