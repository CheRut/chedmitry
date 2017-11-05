package ru.chedmitriy.multithreading.threads.thread;

import java.io.IOException;
import java.io.InputStream;
import ru.chedmitriy.multithreading.threads.io.InputOutput;
import ru.chedmitriy.multithreading.threads.service.Settings;



/**
 * класс,в котором
 * производится опрекделение
 * символов в тексте,
 * в нашем случае символа пробела.
 * @author cheDmitry
 * @since 27.08.2017
 * @version 1.0.
 *
 */


public class Counter extends WordsCounter {

    /**параметр ввода/вывода.
     * @see InputOutput
     *
     **/
        private final InputOutput inputOutput;

    /**
     * поток ввода.
     */
    private final InputStream stream;

    /**
     * конструктор по умолчанию.
     * */
    public Counter() {
        inputOutput = new InputOutput();

        /**
         * параметр конфигурации
         * */
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
            int t;
            while ((t = stream.read()) != -1) {
                char c = (char) t;
                if (c == ' ') {
                    try {
                        count++;
                        sleep(1000);
                    } catch (InterruptedException iex) {
                        inputOutput.println("подсчет пробелов остановлен");
                        break;
                    }
                    inputOutput.println("Количество пробелов: " + count);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                stream.close();
            } catch (IOException iex) {
                inputOutput.println(iex.toString());
            }
        }

    }
}
