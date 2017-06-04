package ru.chedmitriy.collectionsPro.list.queue;

import ru.chedmitriy.collectionsPro.list.linkedListLike.LinkedListContainer;

import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Queue;

public class QueueContainer<E> extends LinkedListContainer<E>{

    /**
     *
     *  возвращает, но не удаляет,
     *  элемент из начала очереди.
     *  Если очередь пуста,
     *  генерирует
     *  исключение NoSuchElementException
     *
     * @return E
     */
    public E element() throws NoSuchElementException{
        if(get(0) == null) throw new NoSuchElementException();
        return get(0);
    }
    /**
     *
     * добавляет элемент element в конец очереди.
     * Если элемент удачно добавлен,
     * возвращает true, иначе - false
     * @param element
     * @return boolean
     */
    boolean offer(E element){
        addLast(element);
        return get(getSize()-1)!=null ? true:false;
    }

    /**
     * возвращает без удаления элемент
     * из начала очереди.
     * Если очередь пуста, возвращает значение null
     * @return
     */
    public E peek() {
        return !this.iterator().hasNext()? null : get(0);
    }

    /**
     *
     * возвращает с удалением
     * элемент из начала очереди.
     * Если очередь пуста,
     * возвращает значение null
     * @return E
     */
    public E pol() {
        return poll();
    }


    /**
     * возвращает с удалением
     * элемент из начала очереди.
     * Если очередь пуста,
     * генерирует исключение NoSuchElementException
     */
    public E remove() {
        if(!this.iterator().hasNext()) throw new NoSuchElementException();
        return removeFirstElement();
    }
}
