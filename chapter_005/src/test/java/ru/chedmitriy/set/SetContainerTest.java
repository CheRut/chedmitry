package ru.chedmitriy.set;

import org.junit.Before;
import org.junit.Test;
import ru.chedmitriy.set.arraybasedset.SetContainer;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class SetContainerTest {
    SetContainer<String> setContainer;

    /**
     * Перед выполнением тестов
     * производится инициализация
     * контейнера и добавление в него
     * двух элементов
     *
     */
    @Before
    public void init() {
        setContainer = new SetContainer(2);
        setContainer.add("one");
        setContainer.add("two");

    }
    /**
     * проверка метода add
     * можем добавлять элементы
     * в любом количестве,при этом
     * убедимся,что
     * дубликаты не добавляются
     * */
    @Test
    public void whenTryToAddAnElement() throws Exception {
        setContainer.add("string");
        setContainer.add("rows");
        setContainer.add("one");
        setContainer.add("one");
        setContainer.add("one");
        setContainer.add("one");
        setContainer.add("NoOne");
        setContainer.add("two");
        setContainer.add("three");
        String[]value = {"one", "two", "string", "rows", "NoOne", "three", null};
        for (int i = 0; i < setContainer.resizeContainer().length; i++) {
            assertThat(setContainer.resizeContainer()[i], is(value[i]));
        }
    }

}