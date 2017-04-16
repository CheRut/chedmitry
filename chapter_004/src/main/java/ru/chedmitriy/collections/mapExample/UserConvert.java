package ru.chedmitriy.collections.mapExample;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author Dmitry Cherutsa
 * @project junior
 * @date 4/11/17.
 * @sinse
 * @description:
 */
public class UserConvert {
    public HashMap<Integer, User> process(List<User> list) {
        HashMap<Integer,User> resultMapList= new HashMap<>();
        for(User u:list) {
            resultMapList.put((u.id),u);
        }
            return resultMapList;
        }

    public static void main(String[] args) {
        List<User> u = new ArrayList<User>();
        HashMap<Integer,User> dataList= new HashMap<>();
        u.add(new User(1,"Dmitry","Yalta"));
        u.add(new User(2,"Alex","Moscow"));
        u.add(new User(3,"John","Piter"));
        u.add(new User(4,"Jack","Moscow"));
        u.add(new User(5,"Mary","Moscow"));
        UserConvert uc = new UserConvert();
        dataList = uc.process(u);
        System.out.println(dataList.get(3).name+" city is "+dataList.get(3).city);

    }
}
