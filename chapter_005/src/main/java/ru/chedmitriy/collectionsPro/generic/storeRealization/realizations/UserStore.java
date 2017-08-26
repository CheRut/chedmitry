package ru.chedmitriy.collectionsPro.generic.storeRealization.realizations;


import ru.chedmitriy.collectionsPro.generic.storeRealization.exeptions.WhenObjectNotFoundException;
import ru.chedmitriy.collectionsPro.generic.storeRealization.models.SimpleArray;
import ru.chedmitriy.collectionsPro.generic.storeRealization.models.Store;
import ru.chedmitriy.collectionsPro.generic.storeRealization.objects.User;

/**
 * Класс - хрнилище объектов Node
 */
public class UserStore extends SimpleArray<User> implements Store<User> {
    /**
     * Конструктор,принимающий
     * параметр размера массива     *
     * @param  -  размер массива
     */
    public UserStore(int size) {
        super(size);
    }
    /**
     * метод добавления
     * элемента в массив
     * @param value -
     *              добавляемый элемент
     *
     * */
    @Override
    public void add(User value) {
        super.add(value);
        value.setId(getId());
    }
    /**
     * В массиве
     * находится объект
     * и заменяется новым
     * @param oldValue - искомый объект
     * @param newValue - новое знаяение
     *                 искомого объекта
     * @throws WhenObjectNotFoundException
     */
    @Override
    public void update(User oldValue, User newValue) throws WhenObjectNotFoundException {
        super.update(oldValue,newValue);
    }
    /**
     * метод удаляет
     * объект из массива
     * по его id
     * @param id
     */
    @Override
    public void delete(String id)  {
        super.delete(id);
    }
    /**
     * оъект массива
     * можно получить,зная
     * его id,также посредством данного метода
     * определяется доступ к полям объектаф
     * @param id - id объекта массива.
     * @return элемент обобщенного типа
     * */
    @Override
    public User getById(String id) {
        return super.getById(id);
    }
}
