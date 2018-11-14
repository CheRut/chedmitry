package ru.chedmitriy.monitor.ex1105;

import java.util.List;
import java.util.ArrayList;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;
import ru.chedmitriy.collectionspro.exceptions.CatchArrayOutOfBoundException;


/**
 * ru.chedmitry.multithreading.threads.monitor.ex1105.
 *
 * @author cheDmitry
 * @version 1.0
 * @since 29.10.2017
 * используем в качестве списка
 * созданный ранее динамический список.
 *
 * 1. - Динамический список на основе которого создается
 * контейнер
 * @see ru.chedmitriy.collectionspro.list.arraylistlike.DynamicArray
 *
 * 2. - Тип выбрасываемого исключения
 * @see ru.chedmitriy.collectionspro.exceptions.CatchArrayOutOfBoundException
 *
 */

@ThreadSafe
class DynamicArrayThread {

    /**
     * параметр,соответствующий
     * динамическому списку.
     *
     */
    @GuardedBy("this")
    private final DynamicArray array;

    /**
     * коллекция - клон
     * для занесения в нее
     * элементов коллекции array.
     */
    @GuardedBy("this")
    private final List<String> cloneArray;



    /**
     * конструктор принимающий
     * начальный размер.
     * @param size - размер списка
     */
    public DynamicArrayThread(final int size) {
        array = new DynamicArray<>(size);
        cloneArray = new ArrayList<>();
    }



    /**
     * метод, добавляет строку в список.
     * при достижении предельного размера
     * список увеличивается на 1
     * условие в методе передает
     * выполнение из одного потока другому,
     * что увеличивает вероятность
     * исключения если таковое может случиться
     * @param value - строка для добавления.
     */

    public synchronized void add(final String value) {
        if (Thread.currentThread().getName().equals("firstThread")) {
            Thread.yield();
        }
        this.array.add(value);
    }


    /**
     * получаем элемент
     * по индексу.
     * @param index - целое число
     * @return - значение привиденного типа
     * @throws  CatchArrayOutOfBoundException
     */
    public synchronized Object get(int index) throws CatchArrayOutOfBoundException {
        if (Thread.currentThread().getName().equals("firstThread")) {
            Thread.yield();
        }
        return this.array.get(index);
    }



    /**
     * возвращаем параметр.
     * @return - array:DynamicArray
     */
    public synchronized DynamicArray getArray() {
        return array;
    }



    /**
     * получаем список - клон
     * cloneArray:List
     * @return - список List
     */
    public List getCloneArray() {
        return cloneArray;
    }




    /**
     * получаем размер контейнера
     * @return - целое числа типа int
     */
    public synchronized int getSize() {
        return array.getSize();
    }
}
