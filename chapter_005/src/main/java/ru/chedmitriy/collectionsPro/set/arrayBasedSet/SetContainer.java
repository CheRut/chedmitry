package ru.chedmitriy.collectionsPro.set.arrayBasedSet;

import ru.chedmitriy.collectionsPro.list.arrayListLike.ArrayIterator;

import java.util.Arrays;
import java.util.Iterator;
/**
 * Класс - контейнер Сэт
 * @see ArrayIterator
 * */

public class SetContainer<E> implements Iterable<E>{

    /**
     * контейнер элементов
     * принимает информацию о размере
     * контейнера
     */
    private E[] container ;
    /**
     * массив всегда будет расти
     * на 1 позицию
     *
     * */
    private final int CAPACITY_UP_ON_FOR_ONE_POSITION_HIGHER = 1;


    /**
     * индекс
     * элементов контейнера
     * */
    private int index = 0;
    /**
     * итератор контейнера
     * */
    ArrayIterator setArrayIterator;

    /**
     * конструктор контейнера
     * принимает размер контейнера,
     * инициализирует итератор
     * контейнера
     * @param size -  размер контейнера
     */
    public SetContainer(int size) {
        this.container = (E[]) new Object[size];
        setArrayIterator = new ArrayIterator(container);
    }

    /**
     * возвращвет
     * итератор контейнера
     * @return - итератор.
     */
    @Override
    public Iterator<E> iterator() {
        return setArrayIterator;
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
        E[] temp = (E[]) Arrays.copyOf(setArrayIterator.objectsIterator,
                setArrayIterator.objectsIterator.length+CAPACITY_UP_ON_FOR_ONE_POSITION_HIGHER);
        if(!setArrayIterator.hasNext()) {
            setArrayIterator.objectsIterator = temp;
        }
        return (E[]) setArrayIterator.objectsIterator;
    }

    /**
     * Метод проверяет добавляемый элемент
     * на отсутствие такового в
     * сэте
     * @param checkingValue - проверяемый элемент
     *                      (в данном случае
     *                      при добавлении)
     * @return чмло 0 - совпадений нет
     * или -1 - совпадения есть
     */
    public int setHaveSuchValue(E checkingValue){
        int valueInTheSet = 0;
        for(Object o:setArrayIterator.objectsIterator){
            if(o!=null){
                if(o.equals(checkingValue)){
                    valueInTheSet = -1;
                }
            }
        }
        return valueInTheSet;
    }
    /**
     * Добавляем элементы
     * согласно условию метода
     * resizeContainer()
     * @param value - добаввляемый элемент
     */
    public void add(E value) {
        resizeContainer();
        if(setHaveSuchValue(value)!=-1) {
            setArrayIterator.objectsIterator[index++] = value;
            setArrayIterator.next();
        }
    }
}
