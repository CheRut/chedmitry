package ru.chedmitriy.collectionsPro.list.queue;

import ru.chedmitriy.collectionsPro.list.linkedListLike.LinkedListContainer;

import java.util.NoSuchElementException;


/**
 * Created by d1msan on 02.06.2017.
 * Класс - контейнер очередь
 */
public class QueueContainer<E> extends LinkedListContainer<E> {

    /**
     * добавляет элемент object в конец очереди.
     * Если элемент удачно добавлен,
     * возвращает true, иначе - false
     * @param object - добавляемый элемент
     * @return проверка наличия
     * добавленного элемента
     */
    public boolean offer(E object) {
        super.addFirst(object);
        int t = getSize();
        return super.getNext(t)!= null;
    }

    /**
     * удаляет элемент из верхушки очереди,
     * если очередь пуста генерирует исключение
     * @throws NoSuchElementException - выпадающее
     * исключение если очередь пуста
     * @return - удаляемый элемент
     * */
    public E remove() {
        if(super.empty())throw new NoSuchElementException();
        return super.remove();
    }


    /**
     * удаляет элемент из верхушки очереди,
     * если очередь пуста возвращает
     * null
     * @return - удаляемый элемент
     */
    public E poll() {
        return super.empty() ? null:super.remove();
    }


    /**
     * Возвращает элемент
     * верхушки очереди
     * Если очередь пуста вернет null;
     * @return при пустой очереди -null,
     * при непустой очереди - элемент верхушки
     */
    public E element() {
        return super.empty() ? null:super.getNext(getSize()-1);
    }


    /**
     * Возвращает элемент
     * верхушки очереди
     * Если очередь пуста сгенерирует исключение;
     * @throws NoSuchElementException -
     * исключение при пустой очереди
     * @return при пустой очереди -null,
     * при непустой очереди - элемент верхушки
     */
    public E peek() {
        if(super.empty())throw new NoSuchElementException();
        return getNext(getSize()-1);
    }
}
