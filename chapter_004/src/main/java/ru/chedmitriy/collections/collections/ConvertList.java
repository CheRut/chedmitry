package ru.chedmitriy.collections.collections;

import java.util.*;
/**
 * Главный класс,реализующий преобразование
 * двумерного массива в коллекцию и наоборот...
 */
public class ConvertList {
    /**
     * Метод конвертирующий двумерный массив
     * в коллекцию List параметров Integer
     * Алгоритм: проходим по всем элементам массива и
     * забиваем их в коллекцию
     * @param array - передаваемый двумерный
     *              массив целых чисел
     * @return convertedList - полученая коллекция
     */
    public List<Integer> toList(final int[][] array) {
        ArrayList<Integer> convertedArray = new ArrayList<>();
        int arrLength = array.length;
        //int arr2ndLength = array[0].length;
        for (int i = 0; i < arrLength; i++) {
            for (int j = 0; j < array[i].length; j++) {
                convertedArray.add(array[i][j]);
            }
        }

        return convertedArray;
    }

    /**
     * Метод,конвертирующий коллекцию целых чисел
     * в двумернй массив
     * Алгоритм метода:
     * тернарный опреатор считает количество столбцов:
     * @param list - передаваемая коллекция
     * @param rows - количество строк в новом двумерном массиве
     * @return int[][] arr - полученный массив
     * */
    public int[][] toArray(final List<Integer> list, final int rows) {
        int[][] arr = new int[rows][];
        int col = list.size() % rows == 0 ? list.size() / rows : list.size() / rows + 1;
        Iterator<Integer> iterator = list.iterator();
        arr = new int[rows][col];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < col; j++) {
                if (iterator.hasNext()) {
                    arr[i][j] = iterator.next();
                }
                else {
                    break;
                }
            }

        }
        return arr;
    }
    /**
     *  Вспомагательный метод,позоляющий
     *  быстро создать массив с заданными араметрами
     *  случайных целых чисел типа "rows x columns"
     *  @param rows - количество строк
     *  @param columns - количество элементов в строке
     *  @return int[][]a - сгенерированный двумерный массив целых чисел
     *  */
    public int[][] randomNumberFill(final int rows, final int columns){
        int[][] a = new int[rows][columns];
        Random rnd = new Random();
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {

                int bound = 10;
                a[i][j] = rnd.nextInt(bound) + 1;
            }
        }

        return a;
    }
    /**
     * Метод,преобразующий коллекцию
     * массивов целых чисел в коллекцию
     * содержимого этих массивов по порядку
     * Алгоритм:
     * посредством оператора foreach проходим по
     * коллекции массивов,затем - по содержимому каждого массива
     * Полученные элементы заносим в коллекцию allInOne
     * @param list - коллекция массивовцелых чисел
     * @return  - коллекция содержимого нескольких массивов
     * целых чисел
     * */
    public List<Integer> convert(final List<int[]> list){
        List<Integer>  resultList = new ArrayList<>();
        for (int[] values:list){
            for (int i = 0; i < values.length; i++) {
                resultList.add(values[i]);
            }
        }

        return resultList;
    }


}
