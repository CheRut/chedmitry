package ru.chedmitriy.multithreading.threads.test.bomberman;

import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * ru.chedmitriy.multithreading.threads.test.bomberman
 *
 * @author cheDmitry
 * @version 1.0
 * @since 05.12.2017
 */
public class Board {

    /**
     * массив объктов блокировок
     */
    private  final ReentrantLock[][] board =  new ReentrantLock[8][8];

    /**
     * генератор случайных чисел в диапазоне
     * строк массива board.
     * @return - случайное целое число от 0 до 7
     */
    public int randomX() {
        return new Random().nextInt(8);
    }

    /**
     * генератор случайных чисел в диапазоне
     * столбцов массива board.
     * @return - случайное целое число от 0 до 7
     */
    public int randomY() {
        return new Random().nextInt(8);
    }


    /**
     * геттер массива объектов блокировок.
     * @return - массив board
     */
    public ReentrantLock[][] getBoard() {
        return board;
    }
}

/**
 * класс определяет объект
 * типа Thread, выполняющий
 * перемещение модели по
 * ячейкам массива.
 */
class MoveAct extends Thread {

    /**
     * поле, в котором
     * в случайном порядке
     * перемещается модель
     */
    private final Board board;

    /**
     * конструктор принимает
     * объект в котором
     * перемещается модель.
     * @param board - объект типа Board
     */
    public MoveAct(Board board) {
        this.board = board;
    }

    /**
     * в методе происходит имитация
     * перемещения некоторого объекта
     * по ячейкам массива,блокирующими
     * объектами.
     */
    @Override
    public void run() {
        int x = this.board.randomX();
        int y = this.board.randomY();
        try {

            if(this.board.getBoard()[y][x] == null) {
                this.board.getBoard()[y][x] = new ReentrantLock();
            }
            boolean tLock = this.board.getBoard()[y][x].tryLock(1000, TimeUnit.MILLISECONDS);
            if (tLock) {
                try {
                    System.out.print(String.format(
                            "Модели переместилась в ячейку  (%s)(%s)\n", y, x));
                }   finally {
                    this.board.getBoard()[y][x].unlock();
                }
            } else if (this.board.getBoard()[y][x].isLocked()) {
                Thread.sleep(5000);
                System.out.print(String.format(
                        "Ячейка  (%s)(%s) заблокирована, ожидаем \n", y, x));

                interrupt ();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}


/**
 * класс реализующий нить
 * "простоя" модели на ячейке
 */
class StayAct extends Thread {

    /**
     * объект -  игровое поле
     */
    private final Board board;

    /**
     * конструктор принимает
     * объект в котором
     * простаивает модель.
     * @param board - объект типа Board
     */
    public StayAct(Board board) {
        this.board = board;
    }

    @Override
    public void run() {
        int x = this.board.randomX();
        int y = this.board.randomY();
        if (this.board.getBoard()[y][x] == null) {
            this.board.getBoard()[y][x] = new ReentrantLock();
        }

        try {
            this.board.getBoard()[y][x].lockInterruptibly ();
            try {
                System.out.print(String.format(
                        "Ячейка  (%s)(%s) заблокирована \n", y, x));
            } finally {
                Thread.sleep (1100);
                this.board.getBoard()[y][x].unlock();

            }
        } catch (InterruptedException e) {
            System.out.println("поток пробудился");
        }
    }
}
