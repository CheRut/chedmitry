package ru.chedmitriy.service;

import java.io.IOException;
import java.io.InputStream;

import java.util.Properties;

/**
 * Created by dimsan on 18.01.2017.
 */
public class Settings {
    private final Properties prop = new Properties();

    public void load(InputStream io) {
        try {
            this.prop.load(io);
            
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public String getValue(String key) {
        return this.prop.getProperty(key);

    }
}
