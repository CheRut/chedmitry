package ru.chedmitry.multithreading.threads.monitor.ex1104;

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
    UserStorage us;
    ThreadOne one;
    ThreadTwo two;


    @Before
    public void init() throws InterruptedException {
        us = new UserStorage();
        us.add(new User(1, 10));
        us.add(new User(2, 20));
        us.add(new User(3, 30));
        us.add(new User(4, 40));
        us.add(new User(5, 50));
        us.add(new User(6, 60));
        one = new ThreadOne(us);
        two = new ThreadTwo(us);
        one.start();
        two.start();
        one.join();
        two.join();



    }
    @Test
    public void whenNewUserWasAdded() throws Exception {
        for (User user:us.getStorage()) {
            if (user.getId() == 10){
                assertThat(user.getAmount(), is(100));
            }
        }
        for (User user:us.getStorage()) {
            System.out.println(user);
        }
    }

    @Test
    public void whenFirstUserWasRemoved() throws Exception {
        assertThat(us.getStorage().size(), is(6));
    }
    @Test
    public void whenAmountWasTransferBetweenTwoUsers() {
        for (User user:us.getStorage()) {
            if (user.getId() == 5) {
                assertThat(user.getAmount(), is(49));
            }
            if (user.getId() == 4) {
                assertThat(user.getAmount(), is(41));
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
        us.add(new User(10, 100));
        us.transfer(5, 4, 1);
        us.remove();
        us.update();
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
        us.remove();
        us.transfer(6, 3, 20);
        us.add(new User(12, 120));
    }
}
