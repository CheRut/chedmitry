package ru.chedmitriy.collectionsPro.list.stack;

import ru.chedmitriy.collectionsPro.list.linkedListLike.LinkedListContainer;

/**
 * Класс - контейнер Stack,в
 * котором объекты расположены
 * по принципу
 * Last in first out(LIFO)
 *
 * @param <E>
 *
 */
public class StackContainer<E> extends LinkedListContainer<E>{
    /**
     * Помещаем элемент
     * в контейнер.Метод
     * родительского класса
     * addFirst дает возможность
     * всегда вставлять значения
     * в начало,перед ранее вставленным
     * элементом
     * @param element - вставляемый
     *                в контейнер
     *                элемент
     */
    public void push(E element){
        this.addFirst(element);
    }
    /**
     * Метод извлекает
     * элементы из стэка
     * по одному
     * @return - возвращает
     * текущий элемент контейнера
     */
    public E pop() {
        return this.removeLastElement();
    }
    /**
     * Возвращает верхний элемент,
     * не удаляя его из стека
     * @return - E
     * */
    public E peek(){
        return get(getSize()-1);
        }
    /**
     * Служит для проверки стека
     * на наличие элементов —
     * он возвращает true, если стек пуст
     * @return boolean
     * */
    public boolean empty(){
        return this.iterator().hasNext() ? false : true;
    }
    /**
     * Метод ищет заданный
     * элемент в стеке и возвращает
     * количество операций pop
     * для вывода элемента на вершину
     * стэка.Если заданный
     * элемент в стеке отсутствует,
     * этот метод возвращает -1
     * @param element
     * @return int
     */
    public int search(E element){
        int popOperationsIsNeededToDone = -1;
        int count = 0;
        while (!empty()){
            count++;
            if(element.equals(peek())) {
                popOperationsIsNeededToDone = count;
                break;
            }
            setSize(getSize()-1);
        }
        return popOperationsIsNeededToDone;
    }
}
