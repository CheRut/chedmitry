package ru.chedmitriy.collectionsPro.IteratorAndDoubleArray.iteratorConverter;

import org.junit.Test;


import static org.junit.Assert.assertArrayEquals;


public class ConvertIteratorTest {

    /**
     * Тестирую результат работы класса
     * выбираю два произвольных списка,
     * затем преобразовываю их в Список итераторов->Итератор итератора
     * так как результирующий Итератор пуст,посредством цикла
     * заношу значения использую метод convert
     * Создаю два массива один является желаемым результатом работы
     * класса,второй(пустой) - актуальным.
     * сравниваю полученные массивы
     * */
    @Test
    public void testIterator() {
        ConvertIterator converter = new ConvertIterator();
        converter.doubleListIterator();
        for (int i = 0; i < 21 ; i++) {
            converter.convert(converter.getIteratorOfIterator());
        }
        int[] exp = {4,2,0,4,6,4,9,0,9,8,7,5,1,3,5,6,7,0,9,8,4};
        int[] act = new int[21];
        int i = 0;
        while ( converter.hasNext()) {
            act[i] = converter.getResultItertor().next();
            i++;
        }
        assertArrayEquals(exp, act);
    }

}