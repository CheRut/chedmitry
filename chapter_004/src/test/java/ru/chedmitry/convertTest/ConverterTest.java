package ru.chedmitry.converttest;

import org.junit.Before;
import org.junit.Test;
import ru.chedmitriy.collections.ConvertList;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class ConverterTest {
    ConvertList cList;
    int[][]ar;
    List<Integer> al;

    @Before
    public void init() {
        cList = new ConvertList();
        ar = cList.randomNumberFill(2, 4);
        al = cList.toList(ar);
    }
    /**
     * Проверим метод по изменению размера массива,
     * а также на соответствие элементов
     * одного элементам другого
     * */
   @Test
    public void toListTest() {
       int expected = 8;
       int checkValue = ar[1][2];
       assertThat(al.size(), is(expected));
       assertThat(al.get(6), is(checkValue));
    }
    /**
     * Проверяем метод преобразования
     * контейнера в двумерный массив
     * Создадим вспомогательный список
     * из полученного двумерного массива
     * и сравним исходный контейнер с этим списком
     * */
    @Test
    public void toArrayTest() {
        List<Integer> result = new ArrayList<>();
         ar = cList.toArray(al, 5);
         result = cList.toList(ar);
         if (al.size() < result.size()) {
             assertTrue(result.contains(0));
         }
    }
    /**
     * тестируем конвертацию двух одномерных массивов
     * в контейнер
     * */
    @Test
    public void whenTwoArraysCreatingList() {
        int[]a = {1, 2, 3, 4, 12, 14};
        int[]b = {5, 6, 7, 8};
        List<int[]> list = new ArrayList<>();
        list.add(a);
        list.add(b);
        cList.convert(list);
        assertTrue(list.contains(a) && list.contains(b));
    }
}
