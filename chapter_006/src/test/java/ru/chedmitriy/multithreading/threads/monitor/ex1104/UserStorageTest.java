package ru.chedmitriy.multithreading.threads.monitor.ex1104;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * ru.chedmitry.multithreading.threads.monitor.ex1104
 *
 * @author cheDmitry
 * @version 1.0
 * @since 29.10.2017
 */
public class UserStorageTest {
    private UserStorage us;
    private ThreadOne one;
    private ThreadTwo two;


    @Before
    public void init() throws InterruptedException {
        us = new UserStorage();
        us.add(new User(1, 10));
        us.add(new User(2, 20));
        us.add(new User(3, 30));
        us.add(new User(4, 40));
        us.add(new User(5, 50));
        us.add(new User(6, 60));
        us.add(new User(7, 70));
        us.add(new User(8, 80));
        us.add(new User(9, 90));
        us.add(new User(10, 100));
        us.add(new User(11, 110));
        us.add(new User(12, 120));
        one = new ThreadOne(us);
        two = new ThreadTwo(us);
        one.start();
        two.start();
        one.join();
        two.join();



    }
    @Test
    public void whenNewUserWasAdded() throws Exception {

                assertThat(us.getStorage().get(11).getAmount(), is(140));


        for (User user:us.getStorage()) {
            System.out.print(user);
        }
    }

    @Test
    public void whenFirstUserWasRemoved() throws Exception {

        assertThat(us.getStorage().size(), is(12));
    }
    @Test
    public void whenAmountWasTransferBetweenTwoUsers() {
        for (User user:us.getStorage()) {
            if (user.getId() == 3) {

                assertThat(user.getAmount(), is(45));
            }
            if (user.getId() == 4) {
                assertThat(user.getAmount(), is(25));
            }
        }

    }
}

class ThreadOne extends Thread {

    private final UserStorage us;

    public ThreadOne(UserStorage us) {
        super();
        this.us = us;
        Thread.currentThread().setName("one");
    }

    @Override
    public void run() {
        us.add(new User(13, 130));
        us.transfer(4, 3, 15);
        us.remove(6);
        us.update(1);
    }
}
class ThreadTwo extends Thread {
    private final UserStorage us;
    public ThreadTwo(UserStorage us) {
        super();
        this.us = us;
    }

    @Override
    public void run() {
        us.remove(5);
        us.transfer(10, 9, 20);
        us.add(new User(14, 140));
    }
}
