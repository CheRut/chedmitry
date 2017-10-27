package ru.chedmitry.multithreading.threads.thread;

import ru.chedmitry.multithreading.threads.io.InputOutput;

/**
 * @author - cheDmitry
 * @since 27.08.2017
 * @version - 1.0
 */
public class MAinThreadInterrupt {

        /**
         * главный метод,
         * являющийся основным
         * потоком.здесь продемонстрирована остановка процессов
         * @param args - принимаемые параметры
         */
        public static void main(String[] args) throws InterruptedException {
            InputOutput iO = new InputOutput();
            Counter space = new Counter();
            WordsCounter wordsCounter = new WordsCounter();
            iO.println("Программа для подсчета числа слов и пробелов");
            wordsCounter.start();
            space.start();
            Thread.sleep(3000);
            space.interrupt();
            wordsCounter.interrupt();
            iO.println("программа завершилась");


        }

    }


