package ru.chedmitriy.collectionsPro.generic.storeRealization.models;

import ru.chedmitriy.collectionsPro.generic.storeRealization.exeptions.WhenObjectNotFoundException;

/**
 * Интерфейс добавления,удаления,
 * редактирования объектов Role и Node
 * @param <T> - объект класса Role или Node
 */
public interface Store<T extends Base> {
    /**
     * метод добавляет
     * новый объект в массив
     * @param value
     */
    public void add(T value);
    /**
     * В массиве
     * находится объект
     * и заменяется новым
     * @param oldValue - искомый объект
     * @param newValue - новое знаяение
     *                 искомого объекта
     * @throws WhenObjectNotFoundException
     */
    public void update (T oldValue, T newValue) throws WhenObjectNotFoundException;
    /**
     * метод удаляет
     * объект из массива
     * по его id
     * @param id
     */
    public void delete(String id) throws WhenObjectNotFoundException;




}
