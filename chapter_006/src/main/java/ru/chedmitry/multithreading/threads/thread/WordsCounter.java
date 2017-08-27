package ru.chedmitry.multithreading.threads.thread;

import ru.chedmitry.multithreading.threads.InputOutput.InputOutput;
import ru.chedmitry.multithreading.threads.service.Settings;


import java.io.*;
import java.util.Scanner;


/**
 * Класс счетчик слов в текстовом файле
 * @author cheDmitry
 * @since 27.08.2017
 * @version 1.0
 */
class WordsCounter extends Thread {

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
     * Конструктор - инициализирует
     * поток ввода из текстового файла.
     * Путь к текстовому файлу лежит
     * в файле конфигурации app.properties
     *
     *
     */
    public WordsCounter() {
        iO = new InputOutput();
        /*
      параметр конфигурации
      */
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
            }catch (InterruptedException e){
                iO.println("подсчет слов остановлен");
                 break;
            }
            iO.println("Количество слов: " + count);
        }
        try {
            stream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



}
