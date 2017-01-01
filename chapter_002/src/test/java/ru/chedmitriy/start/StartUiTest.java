package ru.chedmitriy.start;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import ru.chedmitriy.models.Comments;
import ru.chedmitriy.models.Item;
import ru.chedmitriy.models.Task;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class StartUiTest{	
	private Tracker tracker;
	private Item resultItem;
    
	
	@Before
    public void addingItemTester() {
        tracker = new Tracker();
        resultItem = new Item();
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
	
    @After
    public void itemListCleared(){
        for (int index = 0; index < tracker.getItems().length; index++) {
            tracker.getItems()[index] = null;
            assertNull(tracker.getItems()[index]);
        }

    }
	
	@Test
    public void editItemTester() {
		
        for (int index = 0; index < tracker.getItems().length; index++) {
            tracker.editById((tracker.getItems()[1]), "dmitry", "junior");
            String expected = "dmitry";
            assertThat(((tracker.getItems()[1]).getName()), is(expected));
            break;
        }
    }

    @Test
    public void getItemListTest(){
           assertNotNull(tracker.getItems());
}

    @Test
    public void deleteItemTester(){
        String exp = null;
        for(int index=0;index<tracker.getItems().length;index++){
            tracker.deleteById(tracker.getItems()[2]);
            break;
        }
        for(int index=0;index<tracker.getItems().length;index++){
            assertThat((tracker.getItems()[2].getName()),is(exp));
        }
    }
    @Test
    public void commentAddingTester(){

        for (int index = 0; index <tracker.getItems().length ; index++) {
          assertTrue(tracker.getItems()[8] instanceof Comments);
        }
    }   
}