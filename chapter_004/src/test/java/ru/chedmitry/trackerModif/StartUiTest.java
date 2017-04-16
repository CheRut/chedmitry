package ru.chedmitry.trackerModif;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import ru.chedmitriy.collections.modifiingTracker.objects.Tracker;
import ru.chedmitriy.collections.modifiingTracker.objects.Comments;
import ru.chedmitriy.collections.modifiingTracker.objects.Item;
import ru.chedmitriy.collections.modifiingTracker.objects.Task;


import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class StartUiTest {
    /**
     * Создаем объект класс Tracker
     * */
	private Tracker tracker;
	/**
     * Заполняем массив объектами Item,Task и Comments
     * */
	@Before
    public void addingItemTester() {
        tracker = new Tracker();
        tracker.add(new Item("first task", "first desc"));
        tracker.add(new Task("second task", "second desc"));
        tracker.add(new Task("third task", "third desc"));
        tracker.add(new Task("fourth task", "fourth desc"));
        tracker.add(new Task("fifth task", "fifth desc"));
        tracker.add(new Task("sixth task", "sixth desc"));
        tracker.add(new Task("seventh task", "seventh desc"));
        tracker.add(new Task("eighth task", "eighth desc"));
        tracker.add(new Comments("tenth task", "tens desc","this is comments"));
    }
	
/**
 * По оканчании вы полнения тестов,удаляем все элементы
 * */
@After
public void cleareList(){
	    tracker.getItems().clear();
}

	/**
     * Проверяем опцию редактирования:
     * перепишем второй элемент массива
     * */
	@Test
    public void editItemTester() {
            tracker.editById((tracker.getItems().get(1)), "dmitry", "junior");
            String expected = "dmitry";
            assertThat(((tracker.getItems().get(1)).getName()), is(expected));

    }

/**
 * Проверярем опцию удаления:
 * удалим 2 -й элемент массива
 * Сначала передаем переменной значение удаляемого
 * элемента,затем проверяем соответствие по удаленному индексу
 * при вызове этого элемента после удаления -  результат false
 * */
    @Test
    public void deleteItemTester(){
            Item exp = tracker.getItems().get(1);
            tracker.deleteById(tracker.getItems().get(1));
            assertFalse((tracker.getItems().get(1)).equals(exp));
    }
    /**
     * 8 - й  элемент массива имеет
     * тип Comments.
     * Проверяем это
     * */
    @Test
    public void commentAddingTester(){
          assertTrue(tracker.getItems().get(8) instanceof Comments);

    }   
}