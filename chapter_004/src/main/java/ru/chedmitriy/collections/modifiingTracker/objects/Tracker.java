package ru.chedmitriy.collections.modifiingTracker.objects;



import java.util.ArrayList;
import java.util.logging.Logger;

/**
 *
 * Главный класс,содержащий методы,выполняющие действия
 * над объектами
 */
public class Tracker {
    /**
     * объект класса Logger -
     * выводит информацию о проблеме
     * */
    private final Logger lg = Logger.getLogger(getClass().getName());
    /**
     * Все объекты содержатся в
     * этом списке
     * */
    private final ArrayList<Item> items = new ArrayList<>();
    /**
     * класс ввода/вывода
     * */
    private final ConsoleInput cInput = new ConsoleInput();


    /**
     *Метод добавляет новые элементы в список
     * @param item - добавляемый элемент
     * @return  список с добавленным элементом
     *
     * */
    public ArrayList<Item> add(Item item) {
        this.items.add(item);
        return this.items;
    }
    /**
     * Метод возвращает элемент списка
     * по введенному идентификатору
     * @param id - идентификатор(порядковый номер в списке)
     * @return - найденный элемент
     * */

    public Item findById(String id) {
        Item itemWhichFinding = null;
        if(this.items.get(Integer.parseInt(id))!=null) {
            itemWhichFinding = this.items.get(Integer.parseInt(id));
        }
        else {
            lg.info("item with id "+id+" is not found!\nCheck the correctness of the input data");
        }
        return itemWhichFinding;
    }

    public ArrayList<Item> getAll() {
        return this.items;
    }

    public ArrayList<Item> getItems() {
        return this.items;
    }

    /**
     * Метод принимает объект,
     * затем изменяет его параметры:
     * имя и описание
     * @param name - имя объекта
     * @param description - описание
     * @param item - редактируемый объект
     *
     * */

    public void editById(Item item,String name,String description) {
        for (Item item1 : this.items) {
            if (item.equals(item1)) {
                item1.setName(name);
                item1.setDescription(description);
            }
        }
    }
    /**
     * Метод удаляет элемент
     * @param item - удаляемый элемент
     * */
    public void deleteById(Item item) {
        this.items.remove(item);
    }
    /**
     * Метод добавляет комментарии
     * @param item - элемент,куда
     *             будут добавляться комментарии
     * */

    public void addComments(Item item) {
        for (Item it:this.items) {
            if (it.equals(item)&& it instanceof Comments) {
                Comments comments = (Comments) it;
                comments.setComments(cInput.ask("please add the comments: "));
            }

        }

    }
    /**
     * Метод отображает список в
     * соответствии с фильтром
     * @return - список по фильтру
     *
     * */

    public ArrayList<Item> findByFilter() {
        ArrayList<Item> result = new ArrayList<>();
        for (int i = 0; i <this.items.size() ; i++) {
            if(i%2!=0){
                result.add(items.get(i));
            }
        }
        return result;
    }


}



