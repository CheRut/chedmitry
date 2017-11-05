package ru.chedmitriy.collectionsPro.list.arrayListLike;

import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;

import ru.chedmitriy.collectionsPro.exceptions.CatchArrayOutOfBoundException;

/**
 * Класс реализует
 *
 * @param <E>
 */

public class DynamicArray<E> implements Iterable<E>  {
    private  int size;
    /**
     * контейнер элементов
     * принимает информацию о размере
     * контейнера
     */
    private Object[] container ;
    /**
     * Параметр
     * */
    private final int CAPACITY_UP_ON_FOR_ONE_POSITION_HIGHER = 1;


    /**
     * индекс
     * элементов контейнера
     * */
    private  int index = 0;
    /**
     * итератор контейнера
     * */
    ArrayIterator dynamicArray;

    /**
     * конструктор контейнера
     * принимает размер контейнера,
     * инициализирует итератор
     * контейнера
     * @param size -  размер контейнера
     */
    public DynamicArray(int size) {
        this.container = (E[])new Object[size];
        dynamicArray = new ArrayIterator(container);


    }

    /**
     * возвращвет
     * итератор контейнера
     * @return - итератор.
     */
    @Override
    public Iterator<E> iterator() {
        return dynamicArray;
    }

    /**
     * метод работает с итератором
     * контейнера.Проверяет,
     * посредством методща hesNExt()
     * есть ли еще элементы в контейнере.
     * если нет,размер нового контейнера
     * увеличивается на 1
     * @param <E> обобщенный
     *           тип переменной
     * @return - контейнер значений с новым размером
     */
    public <E> E[] resizeContainer() {
        E[] containerBuffer = (E[])Arrays.copyOf(dynamicArray.objectsIterator,
                dynamicArray.objectsIterator.length+CAPACITY_UP_ON_FOR_ONE_POSITION_HIGHER);
        if(!dynamicArray.hasNext()) {
            dynamicArray.objectsIterator = containerBuffer;
        }
        size =  dynamicArray.objectsIterator.length;
        container = dynamicArray.objectsIterator;
        return (E[]) dynamicArray.objectsIterator;
    }

    /**
     * Добавляем элементы
     * согласно условию метода
     * resizeContainer()
     * @param value - добаввляемый элемент
     */
    public void add(E value) {
        resizeContainer();
        container[index++] = value;
        dynamicArray.next();
    }
   

    /**
     * метод возвращает
     * элемент контейнера
     * по индексу
     * @param index - позиция элемента
     * @param <E> - тип переменных контейнера
     * @return - элемент контейнера;
     * @throws CatchArrayOutOfBoundException
     */
    public <E> E get(int index) throws CatchArrayOutOfBoundException {
        if (index >= size || index < 0) throw new CatchArrayOutOfBoundException();
        return (E) container[index];
    }

    public int getSize() {
        return container.length;
    }


}