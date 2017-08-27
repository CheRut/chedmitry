package ru.chedmitry.multithreading.threads.thread;

import ru.chedmitry.multithreading.threads.InputOutput.InputOutput;

/**
 * главный класс
 * демонстрирует параллельную работу
 * главного с двумя другими
 * @author - cheDmitry
 * @since 27.08.2017
 * @version - 1.0
 */
public class MainThread {
    /**
     * главный метод,
     * являющийся основным
     * потоком
     * @param args - принимаемые параметры
     */
    public static void main(String[] args) throws InterruptedException {
        InputOutput iO = new InputOutput();
        Counter space = new Counter();
        WordsCounter wordsCounter = new WordsCounter();
        iO.println("Программа для подсчета числа слов и пробелов");
        wordsCounter.start();
        space.start();

        if(wordsCounter.isAlive()){
            wordsCounter.join();
        }
        if(space.isAlive()){
            space.join();
        }
        iO.println("программа завершилась");
    }
}
