package ru.chedmitry.mapExample;

import org.junit.Before;
import org.junit.Test;
import ru.chedmitriy.collections.mapExample.User;
import ru.chedmitriy.collections.mapExample.UserConvert;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class UserListConvertToMapTest {
    List<User> u;
    HashMap<Integer,User> dataList;
    @Before
    public void initData() {
        u = new ArrayList<>();
        dataList = new HashMap<>();
        u.add(new User(1,"Dmitry","Yalta"));
        u.add(new User(2,"Alex","Moscow"));
        u.add(new User(3,"John","Piter"));
        u.add(new User(4,"Jack","Moscow"));
        u.add(new User(5,"Mary","Moscow"));

    }


    @Test
    public  void whenNeedFoundSomeUser() {
        UserConvert uc = new UserConvert();
        dataList = uc.process(u);
        String wantedNameById = "John";
       assertThat(dataList.get(3).getName(),is(wantedNameById));

    }

}
