package sqlJdbc.jdbc.tracker;

/**
 * Created by dimsan on 18.09.2016.
 */
public class TrackerJDBC extends DataBaseOperating {


    /**
     * определяет подключение к базе
     */
    public TrackerJDBC() {
        super();
    }

    /**
     * опрекделяет хранилище - таблицу в установленной базе данных
     */
    public void itemStore() {
            super.createTable();
        }

    /**
     * добавляет новую заявку
     * @param item - заявка
     */
    public void add(Item item) {super.addItem(item);}

    /**
     * обновляет заявку
     * @param id - искомый идентификатор
     * @param item - заявка
     * @return - измененный параметр item
     */
    public Item replace(String id, Item item) {return super.updateItem(id, item.getName(), item.getCreateDate());}

    /**
     * отображавет вписок всех заявок
     */
    public void findAll() {super.showAllItems();}

    /**
     * удаляет заявку по id
     * @param id - искомый иднтификатор
     */
    public void deleteById(String id) {
           super.deleteItem(id);
    }

    /**
     * поиск по id
     * @param id - искомый идентификатор
     * @return - найденная заявка
     */
    public Item findById(String id) {
         return  super.getElementById(id);
    }
    /**
     * поиск по названию
     * @param name - искомая заявка по названию
     * @return - найденная заявка
     */
    public Item findByName(String name) {
            return super.getElementByName(name);
    }







}



