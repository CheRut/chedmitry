package ru.chedmitriy.test.bomberman;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * ru.chedmitriy.multithreading.threads.test.bomberman
 *
 * @author cheDmitry
 * @version 1.0
 * @since 05.12.2017
 * запускаем приложение
 * модели премещаются хааотично,
 * блокировки устанавливаются в случайном порядке
 */
public class GamePlay {
        public static void main(String[] args) {
            final int threadCount = 2;

            final ExecutorService service = Executors.newFixedThreadPool(threadCount);
            final Board board = new Board();
            MoveAct moveAct = new MoveAct(board);
            StayAct stayAct = new StayAct(board);
            for (int i = 0; i < 10; i++) {
                service.execute(stayAct);
                service.execute(moveAct);
            }
            service.shutdown();
        }

}
