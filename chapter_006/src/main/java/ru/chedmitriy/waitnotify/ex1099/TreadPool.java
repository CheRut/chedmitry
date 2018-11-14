package ru.chedmitriy.waitnotify.ex1099;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * junior
 *
 * @author CheDmitry
 * @version 1.0
 * @since 12.11.17
 */
public class TreadPool {
    private final Work work;
    List<Work> workList;


    public TreadPool(Work work) {
        this.work = work;
        this.workList = new ArrayList<>();
    }

    public synchronized void add(Work work) {
        ExecutorService service = Executors.newFixedThreadPool(4);
        service.execute(new Runnable() {

            @Override
            public void run() {

            }
        });
    }
}
class Work extends Thread {

}