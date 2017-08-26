package ru.chedmitry.multithreading.threads.thread;

import ru.chedmitry.multithreading.threads.InputOutput.InputOutput;


import java.io.*;
import java.util.Scanner;


public class WordsCounter  extends Thread {
    /**
     * путь к файлу
     */
    private final String path;
    /**
     * параметр ввода/вывода
     */
    private final InputOutput iO;

    /**
     * параметр чтения строк
     */
    private Scanner sc;

    /**
     * поток ввода
     */
    private final InputStream stream;
    /**.
     * 'c' - символьная переменная
     * значение ее принимается как приведенное
     * целочисленное значение
     * */
    private char c;
    /**.
     * параметр 't' - принимает
     * входящий поток*/
    private int t;

    public WordsCounter(final String path) {
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
            }catch(IOException e){
                e.printStackTrace();
            }             finally {
                try { stream.close();
                } catch(IOException iex){
                    iO.println(iex.toString());
                }
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
        while (sc.hasNext()) {
            sc.next();
            count++;
            iO.println("Количество слов: " + count);
        }
        sc.close();
        return count;
    }

}
