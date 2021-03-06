package ru.chedmitriy.generic.storerealization.realizations;

import org.junit.Before;
import org.junit.Test;
import ru.chedmitriy.generic.storerealization.exeptions.WhenObjectNotFoundException;
import ru.chedmitriy.generic.storerealization.objects.User;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class UserStoreTest {
    UserStore userStore;
    @Before
    public void init() {
        userStore = new UserStore(10);
        userStore.add(new User("Dmitry"));
        userStore.add(new User("Oleg"));
        userStore.add(new User("Alex"));

    }

    @Test
    public void add() throws Exception {
        userStore.add(new User("newName"));
        assertThat(userStore.getById("4").getName(), is("newName"));
    }

    @Test
    public void update() throws Exception {
        User newUser = new User("senior");
        userStore.update(userStore.getById("2"), newUser);
        assertThat(userStore.getById("2").getName(), is("senior"));

    }

    @Test
    public void delete() throws WhenObjectNotFoundException {
        userStore.delete("1");
        assertNull(userStore.getObjects()[0]);
    }

    @Test
    public void getById() throws Exception {
        User user = userStore.getById("1");
        assertThat(user.getName(), is("Dmitry"));
    }

}