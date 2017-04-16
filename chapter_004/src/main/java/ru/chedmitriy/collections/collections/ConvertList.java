package ru.chedmitriy.collections.collections;

    import java.util.*;

/**
 * Главный класс,реализующий преобразование
 * двумерного массива в коллекцию и наоборот...
 */
public class ConvertList {
    /**
     *.
     * список значений
     * */
    private final List<Integer> allInOne = new ArrayList<>();

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
        int arr2ndLength = array[0].length;
        for (int i = 0; i < arrLength; i++) {
            for (int j = 0; j < arr2ndLength; j++) {
                convertedArray.add(array[i][j]);
            }
        }
        for (int numb:convertedArray) {
            System.out.print(numb + " ");
        }
        System.out.println();
        return convertedArray;
    }

    /**
     * Метод,конвертирующий коллекцию целых чисел
     * в двумернй массив
     * Алгоритм метода:снача проверяем кратность всех
     * элементов массива строкам
     * Если кратно-заполняем массив,в противном случае,
     * добиваем коллекцию нулями,до тех пор,пока количество элементов
     * не станет кратно строкам,заполняем массив.
     * @param list - передаваемая коллекция
     * @param rows - количество строк в новом двумерном массиве
     * @return int[][] arr - полученный массив
     * */
    public int[][] toArray(final List<Integer> list, final int rows) {
        int[][] arr = new int[rows][];
        int fillingElements = list.size() / rows;
        int index = 0;
        if (list.size() % rows == 0) {
            arr = new int[rows][fillingElements];
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < fillingElements; j++) {
                    arr[i][j] = list.get(index++);
                }
            }
        }
        else if (list.size() % rows != 0){
            while (list.size() % rows != 0){
                list.add(0);
            }
            arr = new int[rows][list.size() / rows];
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < list.size() / rows; j++) {
                    arr[i][j] = list.get(index++);
                }
            }
        }
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < list.size() / rows; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
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
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
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
     * @return allInOne - коллекция содержимого нескольких массивов
     * целых чисел
     * */
    public List<Integer> convert(final List<int[]> list){
        for (int[] values:list){
            for (int i = 0; i < values.length; i++) {
                this.allInOne.add(values[i]);
            }
        }
        for (int val:this.allInOne) {
            System.out.print(val + "; ");
        }

        return this.allInOne;
    }


}
