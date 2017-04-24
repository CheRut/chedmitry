package ru.chedmitry.timingTest;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import ru.chedmitriy.collections.collections.CollectionsProcessTiming;
import ru.chedmitriy.collections.modifiingTracker.objects.ConsoleInput;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.TreeSet;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class collectionsProcessTimerTest {
    ConsoleInput cIO = new ConsoleInput();
    ArrayList<String> aList;
    LinkedList<String> linkList;
    TreeSet<String> tSetList;
    CollectionsProcessTiming collectionsProcessTiming;
    String[] lines = {"one","two","three","four","five","six","seven","eight","nine","ten"};
    /**
     * Инициализируем значения для
     * тестирования*/
    @Before
    public void initValueForTest() {
        long result;
        aList = new ArrayList();
        linkList = new LinkedList();
        tSetList = new TreeSet();
        collectionsProcessTiming = new CollectionsProcessTiming();
        result = 0;
        for(String line:lines)
            result += collectionsProcessTiming.add(aList, line, 1);
        cIO.outPrintln(String.format("%5s %5s %5s %5s%n",result,"-","при работе  с контейнером типа ",
                aList.getClass().getName()));
        result=0;
        for(String line:lines)
            result += collectionsProcessTiming.add(linkList, line, 1);
        cIO.outPrintln(String.format("%5s %5s %5s %5s%n",result,"-","при работе  с контейнером типа ",
                linkList.getClass().getName()));
        result = 0;
        for(String line:lines)
            result += collectionsProcessTiming.add(tSetList, line, 1);
        cIO.outPrintln(String.format("%5s %5s %5s %5s%n",result,"-","при работе  с контейнером типа ",
                tSetList.getClass().getName()));

    }
    /**
     * Чистим все коллекции
     * */
    @After
    public void clearedCollections(){
        aList.clear();
        linkList.clear();
        tSetList.clear();
    }
    /**
     * Добавляем значения в ArrayList collection
     * Проверяем по изменению размера коллекции
     * */
    @Test
    public void arrayListCheckContent() {
        int expectedSize = 10;
        assertThat(this.aList.size(),is(expectedSize));
    }
    /**
     * Добавляем значения в LinkedList collection
     * Проверяем по изменению размера коллекции
     * */
    @Test
    public void linkedListCheckContent() {
        int expectedSize = 10;
        assertThat(this.linkList.size(),is(expectedSize));
    }
    /**
     * Добавляем значения в TreeSet collection
     * Проверяем по изменению размера коллекции
     * */
    @Test
    public void tSetListCheckContent() {
        int expectedSize = 10;
        assertThat(this.tSetList.size(),is(expectedSize));
    }
    /**
     * Удаляем значения в ArrayList collection
     * Проверяем по изменению размера коллекции
     * */
    @Test
    public void arrayListCheckContentAfterDeleting() {
        collectionsProcessTiming.delete(aList,5);
        int expectedSize = 5;
        assertThat(this.aList.size(),is(expectedSize));
    }
    /**
     * Удаляем значения в LinkedList collection
     * Проверяем по изменению размера коллекции
     * */
    @Test
    public void linkedListCheckContentAfterDeleting() {
        collectionsProcessTiming.delete(linkList,5);
        int expectedSize = 5;
        assertThat(this.linkList.size(),is(expectedSize));
    }
    /**
     * Удаляем значения в TreeSet collection
     * Проверяем по изменению размера коллекции
     * */
    @Test
    public void tSetListCheckContentAfterDeleting() {
        collectionsProcessTiming.delete(tSetList,5);
        int expectedSize = 5;
        assertThat(this.tSetList.size(),is(expectedSize));
    }

}
