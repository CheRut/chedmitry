package ru.chedmitriy.multithreading.threads.thread;

import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;
import ru.chedmitriy.multithreading.threads.io.InputOutput;
import ru.chedmitriy.multithreading.threads.service.Settings;





/**
 * Класс счетчик слов в текстовом файле.
 * @author cheDmitry
 * @since 27.08.2017
 * @version 1.0
 */

class WordsCounter extends Thread {
    /**
     * параметр ввода/вывода.
     * @see InputOutput
     */
    private final InputOutput inputOutput;
    /**
     * поток ввода.
     */
    private final InputStream stream;
    /**
     * Конструктор - инициализирует
     * поток ввода из текстового файла.
     * Путь к текстовому файлу лежит
     * в файле конфигурации app.properties
     */
    public WordsCounter() {
        inputOutput = new InputOutput();

        Settings settings = new Settings();
        settings.load();
        this.stream = getClass().getResourceAsStream(settings.getValue("inputFile"));
    }

    /**
     * при обращении потока
     * к данному классу,точкой вхождения станет
     * данный метод
     */
    @Override
    public void run() {
        /*
      параметр чтения строк
     */
        Scanner sc = new Scanner(stream);
        int count = 0;
        while (sc.hasNext()) {
            sc.next();
            try {
                count++;
                sleep(1000);
            } catch (InterruptedException e) {
                inputOutput.println("подсчет слов остановлен");
                break;
            }
            inputOutput.println("Количество слов: " + count);
        }
        try {
            stream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



}
