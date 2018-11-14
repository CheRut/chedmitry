package ru.chedmitriy.mapexample;


import java.util.HashMap;
import java.util.List;

/**
 * Класс,выполняющий
 * действия над объектами User
 * */
public class UserConvert {
/**
 * Метод,преобразующий List
 * в Map
 * В качестве ключа используется
 * id объекта User
 * @param list  -  передаваемый список
 * @return - HashMap
 * */

    public HashMap<Integer, User> process(List<User> list) {
        HashMap<Integer, User> resultMapList = new HashMap<>();
        for (User u:list) {
            resultMapList.put((u.getId()), u);
        }
            return resultMapList;
        }


}
