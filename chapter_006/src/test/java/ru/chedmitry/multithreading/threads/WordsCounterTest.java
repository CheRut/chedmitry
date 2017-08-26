package ru.chedmitry.multithreading.threads;

import org.junit.Before;
import org.junit.Test;
import ru.chedmitry.multithreading.threads.service.Settings;
import ru.chedmitry.multithreading.threads.thread.WordsCounter;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class WordsCounterTest {
    String path;
    @Before
    public void init(){
        Settings settings = new Settings();
        settings.load();
        path =  settings.getValue("inputFile");
    }
    @Test
    public void counter() throws Exception {

        System.out.println("Start");
        new Thread(new WordsCounter(path)).start();
        new Thread(new WordsCounter(path).new WhitespaceCounter()).start();
        System.out.println("Finish");
    }

    @Test
    public void whenWordsWasCount(){
        assertThat(new WordsCounter(path).wordsCounter(),is(20));
    }
    @Test
    public void whenWhiteSpacesWasCount(){
        assertThat(new WordsCounter(path).new WhitespaceCounter().wsCounter(),is(19));
    }

}