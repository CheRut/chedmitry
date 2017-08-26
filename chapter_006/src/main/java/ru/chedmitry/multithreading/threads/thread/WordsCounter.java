package ru.chedmitry.multithreading.threads.thread;

import ru.chedmitry.multithreading.threads.InputOutput.InputOutput;
import ru.chedmitry.multithreading.threads.InputOutput.Output;
import ru.chedmitry.multithreading.threads.service.Settings;

import java.io.*;
import java.util.Scanner;


public class WordsCounter  extends Thread {

    /**
     * параметр ввода/вывода
     */
    private  InputOutput iO;
    /**
     * путь к файлу
     */
    private String path;

    /**
     * параметр чтения строк
     */
    Scanner sc;

    /**
     * поток ввода
     */
    InputStream stream;
    /**.
     * 'c' - символьная переменная
     * значение ее принимается как приведенное
     * целочисленное значение
     * */
    char c;
    /**.
     * параметр 't' - принимает
     * входящий поток*/
    int t;

    public WordsCounter(String path) {
        iO=new InputOutput();
        this.path = path;
        this.stream = getClass().getResourceAsStream(path) ;
    }

    /**
     * при обращении потока
     * к данному классу,точкой вхождения станет
     * данный метод
     */
    @Override
    public void run() {
        wordsCounter();
    }

    /**
     * класс,в котором
     * производится опрекделение
     * символов в тексте,
     * в нашем случае символа пробела
     *
     */
    public  class WhitespaceCounter  implements Runnable{
        /**
         * при объевлении нового потока из
         * этого класса,данный
         * метод станет точкой вхождения
         */
        @Override
        public void run(){
            wsCounter();
        }

        /**
         * метод обработки входящего потока,
         * подсчет пробелов,вывод результатов
         *
         */
        public int wsCounter(){
            int count = 0;
            try {

                while ((t = stream.read()) !=-1) {
                    c = (char)t;
                    if(c ==' ') {
                        count++;
                        iO.println("Количество пробелов: "+count);
                    }
                }

                stream.close();
            }catch(IOException e){
                e.printStackTrace();
            }
            return count;
        }
    }

    /**
     * метод подсчета слов в строке
     */
    public int wordsCounter(){
        sc = new Scanner(stream);
        int count=0;
        while(sc.hasNext()){
            sc.next();
            count++;
            iO.println("Количество слов: " + count);
        }
        return count;
    }

}
