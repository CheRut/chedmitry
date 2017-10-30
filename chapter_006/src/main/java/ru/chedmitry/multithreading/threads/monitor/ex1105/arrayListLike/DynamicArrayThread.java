package ru.chedmitry.multithreading.threads.monitor.ex1105.arrayListLike;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;
import ru.chedmitriy.collectionsPro.list.arrayListLike.DynamicArray;

/**
 * ru.chedmitry.multithreading.threads.monitor.ex1105.arrayListLike
 *
 * @author cheDmitry
 * @version 1.0
 * @since 29.10.2017
 * используем в качестве списка
 * созданный ранее динамический список
 *
 */
@ThreadSafe
public class DynamicArrayThread {

    /**
     * параметр,соответствующий
     * динамическому списку
     * @see ru.chedmitriy.collectionsPro.list.arrayListLike.DynamicArray
     */
    @GuardedBy("this")
   private final  DynamicArray array;

    /**
     * конструктор принимающий
     * начальный размер
     *
     * @param size - размер списка
     */
    public DynamicArrayThread(final int size) {
        array = new DynamicArray<>(size);

    }

    /**
     * метод, добавляет
     * строку в список
     * при достижении предельного размера
     * список увеличивается на 1
     *
     * условие в методе передает
     * выполнение из одного потока другому,
     * что увеличивает вероятность
     * исключения если таковое может случиться
     * @param value
     */
    public synchronized void add(String value) {
        if (Thread.currentThread().getName().equals("firstThread")) {
            Thread.yield();
        }
        this.array.add(value);
    }

    /**
     * возвращаем параметр
     * @return - array:DynamicArray
     */
    public DynamicArray getArray() {
        return array;
    }
}
