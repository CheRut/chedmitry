package ru.chedmitriy.generic.storerealization.models;


import ru.chedmitriy.generic.storerealization.exeptions.WhenObjectNotFoundException;

/**
 * Класс создает массив с заданным
 * размером
 * Тип объектов,хранимых в массиве обобщен
 * но находится в пределах класса Base
 * Также имеются методы для работы
 * с содержимым масива
 * */
public class SimpleArray<T extends Base> {

    private String id;
    /**
     * массив объектов
     * */
    T[] objects;
    /**
     * индекс элементов
     * */
    int index = 0;
    /**
     * Конструктор,принимающий
     * параметр размера массива
     * @param size -  размер массива
     * */
    public SimpleArray(int size) {
        this.objects = (T[]) new Base[size];
    }
    /**
     * метод добавления элемента в массив
     * @param value - обобщенный параметр
     *
     * */
    public void add(T value) {
        this.objects[index++] = value;
        id = String.valueOf(index);
    }
    /**
     * Метод обновляет состояние
     * объекта массива
     * @param oldValue - редактируемый элемент
     * @param newValue- новое значение
     * */
    public void update(T oldValue, T newValue) throws WhenObjectNotFoundException {
        if (oldValue == null) {
            throw new WhenObjectNotFoundException();
        }
        for (T ob : objects) {
            if (ob.getName().equals(oldValue.getName())) {
                ob.setName(newValue.getName());
                break;
            }
        }
    }

    /**
     *  Если объект
     *  содержит некий идентификатор
     *  Метод удаляет элемет массива
     *  по id
     *  @param id - искомый id
     *  */
    public void delete(String id) {
        for (int i = 0; i < objects.length; i++) {
            if (i == Integer.parseInt(id) - 1) {
                objects[i] = null;
            }
        }
    }

    /**
     *  Метод удаляет элемет массива
     *  по индексу
     *  @param position - индекс
     *                  удаляемого элемента
     * */
    public void delete(int position) {
        this.objects[position] = null;
    }
    /**
     *  Метод возвращает элемент
     *  по индексу
     *  @param position - индекс искомого
     *                  элемента
     *  @return - полученый элемент
     *
     * */
    public T get(int position) throws WhenObjectNotFoundException {
        if (this.objects[position] == null) {
            throw new WhenObjectNotFoundException();
        }
        return (T) this.objects[position];
    }
    /**
     * При необходимости обратиться
     * к массиву вне класса
     * создан геттер массива
     * @return - возвращаемый
     * массив объектов
     */
    public Object[] getObjects() {
        return objects;
    }
    /**
     * оъект массива
     * можно получить,зная
     * его id,также посредством данного метода
     * определяется доступ к полям объектаф
     * @param id - id объекта массива.
     * @return элемент обобщенного типа
     * */
    public T getById(String id) {
        T objectWasFound = null;
        for (T ob : objects) {
            if (ob.getId().equals(id)) {
                objectWasFound = ob;
                break;
            }
        }
        return objectWasFound;
    }
    /**
     * @return id - объекта
     * */
    public String getId() {
        return id;
    }


}
