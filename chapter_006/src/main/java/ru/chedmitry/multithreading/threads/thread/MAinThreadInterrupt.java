package ru.chedmitry.multithreading.threads.thread;

import ru.chedmitry.multithreading.threads.InputOutput.InputOutput;

/**
 * Created by dimsan on 27.08.17.
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


