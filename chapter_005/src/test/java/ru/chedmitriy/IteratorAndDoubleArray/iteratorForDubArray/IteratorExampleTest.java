package ru.chedmitriy.IteratorAndDoubleArray.iteratorForDubArray;

import org.junit.Test;
import ru.chedmitriy.IteratorAndDoubleArray.iteratorForDobArray.IteratorExample;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class IteratorExampleTest {
    /**
     * Для тестировлания,создадим
     * двумерный массив,передадим его в
     * качестве параметра объекту
     * it.Вызовем реализацию метода next(),
     * При первом вызове методе,получаем значение
     * 1-го элемента
     * при повторном -значение второго элемента,егои
     * передадим параметру value, проверим
     *
     * */
    @Test
    public void whenNextElementChecking() {
        int[][]ar = new int[][]{{1,2},{3,4}};


        IteratorExample it = new IteratorExample(ar);
        it.next();
        it.next();
        int value = it.next();
        assertThat(value,is(3));


    }

    /**
     *
     * протеструем метод hasNext()
     * В переданномконструктору массиве
     * всего два элемента если дважды
     * воспользоваться методом next()
     * мы должны добраться до крайнего и,
     * вызвав метод hasNext получить false.
     * */

    @Test
    public void whileArrayHasAnElements() {
        int[][]ar = new int[][]{{1},{2},{3}};
        IteratorExample it = new IteratorExample(ar);
        it.next();
        it.next();
        it.next();
        boolean hasNextValue = it.hasNext();
        assertThat(hasNextValue,is(false));
    }



}