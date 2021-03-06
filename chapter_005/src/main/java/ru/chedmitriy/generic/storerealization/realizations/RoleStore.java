package ru.chedmitriy.generic.storerealization.realizations;

import ru.chedmitriy.generic.storerealization.exeptions.WhenObjectNotFoundException;
import ru.chedmitriy.generic.storerealization.models.Store;
import ru.chedmitriy.generic.storerealization.models.SimpleArray;
import ru.chedmitriy.generic.storerealization.objects.Role;

/**
 * Класс-хранилище объектов Role;
 */
public class RoleStore extends SimpleArray<Role> implements Store<Role> {
    /**
     * Конструктор задает
     * размер массива объектов
     * @param size
     */
    public RoleStore(int size) {
        super(size);
    }
    /**
     * метод добавляет
     * новый объект в массив
     * @param value
     */
    @Override
    public void add(Role value) {
        super.add(value);
        value.setId(getId());
    }
    /**
     * В массиве находится объект
     * и заменяется новым
     * @param oldValue - искомый объект
     * @param newValue - новое знаяение
     *                 искомого объекта
     * @throws WhenObjectNotFoundException
     */
    @Override
    public void update(Role oldValue, Role newValue) throws WhenObjectNotFoundException {
       super.update(oldValue, newValue);
    }
    /**
     * метод удаляет
     * объект из массива по его id
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
    public Role getById(String id) {
        return super.getById(id);
    }
}
