package ru.chedmitriy.thread;

import ru.chedmitriy.io.InputOutput;

/**
 * ru.chedmitry.multithreading.threads.thread.
 *
 * @author cheDmitry
 * @version 1.0
 * @since 29.10.2017
 * Ожидание вывода.
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


