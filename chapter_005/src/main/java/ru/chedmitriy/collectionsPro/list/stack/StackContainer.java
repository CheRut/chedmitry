package ru.chedmitriy.collectionsPro.list.stack;

import ru.chedmitriy.collectionsPro.list.linkedListLike.LinkedListContainer;

/**
 * Created by d1msan on 30.05.2017.
 * Класс - контейнер Стэк
 */
public class StackContainer<E> extends LinkedListContainer<E> {
    /**
     *
     * Конструктор
     * создает пустой стэк
     * */
    public StackContainer(){

    }
    /**
     * Метод возврвщает верхний
     * элемент,не удаляя его из стэка
     *
     * */
    public E peek(){
        return super.getNext(getSize()-1);
    }
    /**
     *
     *  Метод извлекает
     * верхний элемент из стэка
     * */
    public E pop(){
        return super.remove();
    }
    /**
     * Метод добаввляет
     * элемент в вершину стэка
     * */
    public E push(E lValue){
        super.addLast(lValue);
        return lValue;
    }
    /** Метод ищет заданный элемент в стеке,
     * возвращая количество операций pop,
     * которые требуются
     *  для того чтобы перевести искомый
     *  элемент в вершину стека.
     *  Если заданный элемент в стеке
     *  отсутствует, этот метод возвращает -1.
     *
     * */
    public int search(E searchingElement){
        int counter = 0 ;
        int index = getSize()-1;
        int popOperationNeedToDo = -1;
        while(index>=0){

            if(getNext(index).equals(searchingElement)){
                popOperationNeedToDo = counter;
                break;
            }
            counter++;
            index--;

        }
        return popOperationNeedToDo;
    }
    public boolean isEmpty(){
        return super.empty();
    }
}
