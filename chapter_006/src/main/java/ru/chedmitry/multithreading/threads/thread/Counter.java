package ru.chedmitry.multithreading.threads.thread;

import ru.chedmitry.multithreading.threads.InputOutput.InputOutput;
import ru.chedmitry.multithreading.threads.service.Settings;

import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

/**
 * класс,в котором
 * производится опрекделение
 * символов в тексте,
 * в нашем случае символа пробела
 * @author cheDmitry
 * @since 27.08.2017
 * @version 1.0
 */
public class Counter extends WordsCounter {
    /**
     * параметр конфигурации
     * @see ru.chedmitry.multithreading.threads.service.Settings
     */
    private final Settings settings;


    /**
     * параметр ввода/вывода
     * @see ru.chedmitry.multithreading.threads.InputOutput.InputOutput
     */
    private final InputOutput iO;

    /**
     * поток ввода
     */
    private final InputStream stream;
    /**
     * .
     * 'c' - символьная переменная
     * значение ее принимается как приведенное
     * целочисленное значение
     */
    private char c;
    /**
     * .
     * параметр 't' - принимает
     * входящий поток
     */
    private int t;

    public Counter() {
        iO = new InputOutput();
        this.settings = new Settings();
        settings.load();
        this.stream = getClass().getResourceAsStream(settings.getValue("inputFile"));

    }
    /**
     * при объевлении нового потока из
     * этого класса,данный
     * метод станет точкой вхождения
     */
    @Override
    public void run() {
        int count = 0;
        try {
            while ((t = stream.read()) != -1) {
                c = (char) t;
                if (c == ' ') {
                    try {
                        sleep(1000);
                        count++;
                    } catch (InterruptedException iEx) {
                        iEx.printStackTrace();
                    }
                    iO.println("Количество пробелов: " + count);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                stream.close();
            } catch (IOException iex) {
                iO.println(iex.toString());
            }
        }

    }
}
