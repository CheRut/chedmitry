package sqlJdbc.service;

import java.io.IOException;
import java.util.Properties;


/**
 * ru.chedmitry.multithreading.threads.service.
 *
 * @author cheDmitry
 * @version 1.0
 * @since 29.10.2017
 * Класс конфигурации.
 *
 */

public class Settings {
    /**
     * параметр доступа к
     * конфигураионному файлу.
     */
    private final Properties prop = new Properties();
    /**
     * загрузка файла конфигурации.
     */

    public void load() {

        try {

            this.prop.load(getClass().getClassLoader().getResourceAsStream("app.properties"));

        } catch (IOException ex) {

            ex.printStackTrace();

        }

    }

    /**
     * получаем значение по ключу.
     * @param key - искомый ключ
     * @return найденный ключ
     */

    public String getValue(String key) {

        return this.prop.getProperty(key);

    }

}
