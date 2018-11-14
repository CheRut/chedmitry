package ru.chedmitriy.service;

import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

/**
 * Created by dimsan on 18.01.2017.
 */
public class SettingsTest {
    @Test
    public void whenLoadThen() throws IOException {
        Settings settings = new Settings();
        File file = new File("./../app.properties");
        try (FileInputStream io = new FileInputStream(file)) {
            settings.load(io);
        }
        String value = settings.getValue("home.path");
        assertThat(value, is("c:\\temp\\"));
    }
    @Test
    public void whenClassLoader() throws IOException {
        Settings settings = new Settings();
        ClassLoader loader = Settings.class.getClassLoader();
        try (InputStream io = loader.getResourceAsStream("app.properties")) {
            settings.load(io);
        }
        String value = settings.getValue("sourceFile");
        assertThat(value, is("ru/chedmitriy/extsort/source/source.txt"));
    }
}