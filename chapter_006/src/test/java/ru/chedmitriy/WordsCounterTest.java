package ru.chedmitriy;


import org.junit.Test;
import ru.chedmitriy.service.Settings;


import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class WordsCounterTest {

    @Test
    public void whenConfigFileCall() throws Exception {
        Settings settings = new Settings();
        settings.load();
        assertThat(settings.getValue("inputFile"), is("/text.txt"));

    }


}