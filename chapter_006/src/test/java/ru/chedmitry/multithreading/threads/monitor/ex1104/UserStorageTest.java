package ru.chedmitry.multithreading.threads.monitor.ex1104;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class UserStorageTest {
    @Test
    public void createAndCheck() throws InterruptedException {
        List<User> storeList = Arrays.asList(
                new User(0, 0),
                new User(1, 100),
                new User(2, 300),
                new User(3, 400),
                new User(4, 500),
                new User(12, 0),
                new User(13, 100),
                new User(15, 300),
                new User(16, 0),
                new User(20, 500));
        UserStorage us = new UserStorage();
        AddUser addUser = new AddUser(us, storeList);
        Editor editor = new Editor(us);
        addUser.start();
        editor.start();
        addUser.join();
        editor.join();

        for (User user:us.getStore()) {
            System.out.println(user);
        }
    }

    private static final class AddUser extends Thread {
        private final UserStorage us;
        private final List<User> store;

        public AddUser(final UserStorage us, final List<User> store) {
            super();
            this.store = store;
            this.us = us;
        }

        @Override
        public void run() {
            for (User user:this.store) {
                this.us.add(user);
            }
        }
    }
    private static class Editor extends Thread {
        private final UserStorage us;

        public Editor(final UserStorage us) {
            super();
            this.us = us;
        }
        @Override
        public void run() {
            us.update();
            us.delete();
            us.transfer(1, 4, 65);
        }
    }
}