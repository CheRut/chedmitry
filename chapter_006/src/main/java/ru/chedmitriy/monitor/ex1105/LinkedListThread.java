package ru.chedmitriy.monitor.ex1105;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;
import ru.chedmitriy.monitor.ex1105.linkedlistlike.LinkedListContainer;


/**
 * ru.chedmitry.multithreading.threads.monitor.ex1105.
 *
 * @author cheDmitry
 * @version 1.0
 * @since 29.10.2017.
 *
 * 1. - Используем в качестве списка созданный ранее связный список
 * @see LinkedListContainer ;
 *
 *
 */
@ThreadSafe
class LinkedListThread {

    /**
     * коллекция типа  LinkedListContainer.
     */
    @GuardedBy("this")
    private final LinkedListContainer lList;

    /**
     * конструктор - инициализирует коллекцию.
     */
    public LinkedListThread() {
        this.lList = new LinkedListContainer();
    }

    /**
     * Добавляем элемент в конец коллекции.
     * @param someValue - добавляемый элемент
     */
    public synchronized void addLast(Object someValue) {
        if (Thread.currentThread().getName().equals("1")) {
            Thread.yield();
        }
        lList.addLast(someValue);
    }

    /**
     * добавлячем элемент в начало коллекции.
     * @param someValue - добавляемый элемент
     */
    public synchronized void  addFirst(Object someValue) {
        if (Thread.currentThread().getName().equals("1")) {
            Thread.yield();
        }
        lList.addFirst(someValue);
    }

    /**
     * находим элемент по индексу.
     * @param index искомое значение
     * @return - значение типа Object
     */
    public synchronized Object getNext(int index) {
        return  lList.getNext(index);
    }

     /**
     * удаляем элемент.     *
     * @return -  значение типа String
     */
    public synchronized String remove() {
        return  (String) lList.remove();
    }

    /**
     * получаем размер коллекции.
     * @return целое число
     */
    public  int getSize() {
        return  lList.getSize();
    }
}
