package ru.chedmitry.multithreading.threads.thread;

import ru.chedmitry.multithreading.threads.InputOutput.InputOutput;
import ru.chedmitry.multithreading.threads.service.Settings;

import java.io.IOException;
import java.io.InputStream;

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
     * параметр ввода/вывода
     * @see ru.chedmitry.multithreading.threads.InputOutput.InputOutput
     */
    private final InputOutput iO;

    /**
     * поток ввода
     */
    private final InputStream stream;

    public Counter() {
        iO = new InputOutput();
        /*
      параметр конфигурации
      */
        Settings settings = new Settings();
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
            /*
      .
      параметр 't' - принимает
      входящий поток
     */
            int t;
            while ((t = stream.read()) != -1) {
                /*
      .
      'c' - символьная переменная
      значение ее принимается как приведенное
      целочисленное значение
     */
                char c = (char) t;
                if (c == ' ') {
                    try{
                        count++;
                        sleep(1000);
                    } catch (InterruptedException iEx) {
                        iO.println("подсчет пробелов остановлен");
                        break;
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
