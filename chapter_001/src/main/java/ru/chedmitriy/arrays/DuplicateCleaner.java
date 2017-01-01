package ru.chedmitriy.arrays;
import java.util.*;
/**
 * Class DoubleWord - пример удаления дубликатов строк
 * @author dimCher
 * @since 31.05.2016.
 * @param: arr - исходный массив строк.
 * @param: count - целое число,счетчик
 */
public class DuplicateCleaner{
    
    int count = 0;
    /**метод ShowArr
     * выводит в консоль исходный массив
     * */
    String[] showArr(String[] endArr){
        String[] withoutNullarray;
        int count = 0;
        String[] withNullArray = new String [5];
        withNullArray= arrFormat(arrAlg(endArr));
        for (int i = 0; i <withNullArray.length ; i++) {
            if (withNullArray[i]!=null){
                count++;
            }
        }
        withoutNullarray= new String[count];
        for (int i = 0; i <withNullArray.length ; i++) {
            if (withNullArray[i]!=null){
                withoutNullarray[i]=withNullArray[i];
            }
        }
        System.out.printf("\nresult:");
        System.out.println(Arrays.toString(withoutNullarray));

        return withoutNullarray;
    }
        /**метод arrAlg
         * выводит в консоль алгоритм собствееной работы,
         * если элемент вложенного цикла(j) равен элементу
         * основного цикла(i),счетчик инкрементируем.
         * Если элемент вложенного цикла(j)равен элементу
         * основного цикла(i),счетчик инкрементируем и при этом
         * значение уже встречалось (счетчик = 1)
         * присваиваем j значение null
         * */
       public String [] arrAlg(String[] shufArr) {            
            for (int i = 0; i < shufArr.length; i++) {
                for (int j = 0; j < shufArr.length; j++) {
                    if (shufArr[j] == (shufArr[i])) {
                        count++;
                    }
                    if (shufArr[j] == (shufArr[i]) && count > 1) {
                        String tmp = shufArr[j];
                        shufArr[j] = shufArr[shufArr.length - 1];
                        shufArr[shufArr.length - 1] = tmp;
                        shufArr[shufArr.length - 1] = null;
                        count = 0;

                        break;
                    }
                }
            }
            return shufArr;
        }
        /**метод arrFormat
         * выводит в консоль конечный результат
         * если элемент вложенного цикла(j) равен null,-
         * кидаем j  в конец массива.
         * */
        String[] arrFormat(String[] sortArr) {

            for (int i = 0; i < sortArr.length; i++) {
                for (int j = 0; j < sortArr.length; j++) {
                    if (sortArr[j] == null) {
                        if ((j + 1) <= sortArr.length - 1) {
                            String b = sortArr[j];
                            sortArr[j] = sortArr[j + 1];
                            sortArr[j + 1] = b;
                        }
                    }

                }
            }

            return sortArr;
        }

}
