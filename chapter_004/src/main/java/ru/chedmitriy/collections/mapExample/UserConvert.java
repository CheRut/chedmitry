package ru.chedmitriy.collections.mapExample;


import java.util.HashMap;
import java.util.List;


public class UserConvert {
    public HashMap<Integer, User> process(List<User> list) {
        HashMap<Integer,User> resultMapList= new HashMap<>();
        for(User u:list) {
            resultMapList.put((u.getId()),u);
        }
            return resultMapList;
        }


}
