package ru.chedmitry.collectionsPro.generic.simpleListArray;

public class SimpleList<T >{
    private String id;

     /**
     * массив объектов
     * */
   Object[]objects;
    /**
     * индекс элементов
     * */
    int index = 0;
    /**
     * Конструктор,принимающий
     * параметр размера массива
     * @param size -  размер массива
     * */
    public SimpleList(int size) {
        this.objects = new Object[size];
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
     * @param position - индекс искомого элемента
     * @param value- новое значение
     * */
    public void update(int position,T value) {
        for (int i = 0; i < objects.length; i++) {
            if (i==position){
                objects[i] = value;
            }
        }
    }
    /**
     *  Метод удаляет элемет массива
     *  по индексу
     *  @param position - индекс
     *                  удаляемого элемента
     * */
    public void delete (int position) {
       this.objects[position]=null;

      }
    /**
     *  Метод возвращает элемент
     *  по индексу
     *  @param position - индекс искомого
     *                  элемента
     * @return - полученый элемент
     *
     * */
    public T get (int position) {
        return (T) this.objects[position];
    }

    public Object[] getObjects() {
        return objects;
    }

    public String getId() {
        return id;
    }



}
