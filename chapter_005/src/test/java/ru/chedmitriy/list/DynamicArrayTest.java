package ru.chedmitriy.list;

import org.junit.Before;
import org.junit.Test;
import ru.chedmitriy.list.arraylistlike.DynamicArray;


import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class DynamicArrayTest {

    DynamicArray dynamicArray;

    /**
     * Перед выполнением тестов
     * производится инициализация
     * контейнера и добавление в него
     * двух элементов
     *
     */
    @Before
    public void init() {
        dynamicArray = new DynamicArray(2);
        dynamicArray.add(1);
        dynamicArray.add(2);

    }
    /**
     * проверка метода add()
     * можем добавлять элементы
     * любых типов
     * проверку
     * */
    @Test
    public void whenTryToAddAnElement() throws Exception {
        dynamicArray.add("string");
        String value = "string";
        assertThat(dynamicArray.resizeContainer()[2],
                is(value));
    }
    /**
     *получаем элемент
     *  по индексу
     * */
    @Test
    public void whenTryToGetAnElementByIndex() throws Exception {
        int value = 1;
        assertThat(dynamicArray.get(0),
                is(value));
    }

    /**
     * проверка размера массива.
     * Если контейнер заполнен,
     * увеличиваем его размер на
     * 1.
     *
     */
    @Test
    public void whenTryToResizeContainerLength() {
        dynamicArray.add("new Element");
        int value = 4;
        assertThat(dynamicArray.resizeContainer().length,
                is(value));
    }

}