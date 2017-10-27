package ru.chedmitry.multithreading.threads.service;

import java.io.IOException;
import java.util.Properties;


/**
 * Класс предоставляет доступ
 * к фйлу конфигурации
 */
public class Settings {
    /**
     * параметр доступа к
     * конфигураионному файлу
     */
    private final Properties prop = new Properties();
    /**
     * загрузка файла конфигурации
     */
    public void load() {
        try {
            this.prop.load(getClass().getClassLoader().getResourceAsStream("app.properties"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    /**
     * получаем значение по ключу
     * @param key - искомый ключ
     * @return найденный ключ
     */
    public String getValue(String key) {
        return this.prop.getProperty(key);

    }
}
