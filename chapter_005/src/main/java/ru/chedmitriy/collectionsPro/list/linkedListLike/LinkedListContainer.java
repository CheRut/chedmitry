package ru.chedmitriy.collectionsPro.list.linkedListLike;

import java.util.Iterator;

/**
 * Класс-контейнер
 * @param <E>  переменных,содержащиххся
 *           в контейнере
 */
public class LinkedListContainer<E> implements Iterable<E>{
    /**
     *  значение первого
     *  элемента контейнера
     */
    private ListValue<E> firstListValue;
    /**
     * значение последнего
     * элемента контейнера
     */
    private ListValue<E> lastListValue;
    /**
     * счетчик(размер контейнера)
     */
    private int size = 0;

    /**
     * конструктор - в котором генерируются
     * два состояния хранилища для
     * связанного списка
     * Смысл заключается в том, что первый элемент указывает на последний,
     * а последний - на первый
     * lastValue говорит о том,что текущий элемент равен null и следующий элемент
     * равен null, предыдущий элемент будет соответствовать
     * значению firstValue.
     * firstValue принимает текущее состоние null, предыдущее состояние null,а
     * следующее - lastValue
     */
    public LinkedListContainer() {
        lastListValue = new ListValue<E>(null, firstListValue,null);
        firstListValue = new ListValue<E>(null,null, lastListValue);
    }

    /**
     * алгоритм метода:
     * создаем новое состояние
     * - prev,- указатель на объект который
     * соответствует последнему значению,
     * в него заносим значение передаваемого
     * параметра.
     * Значению lastListValue
     * присваиваем состояние,соответствующее
     * последнему значению( описание в конструкторе),
     * где:предыдущему значению соответствует
     * состояние prev(указатель на первый элемент),
     * текущему соответствует null, и,так как элемент
     * последний nextValue также null;
     * и инкрементируем счетчик
     *
     *
     * @param someValue
     */
    public void add(E someValue) {
        ListValue<E> prev = lastListValue;
        prev.setCurrentElement(someValue);
        lastListValue = new ListValue<E>(null,prev,null);
        prev.setNextElement(lastListValue);
        size++;
    }

    /**
     *Метод создает новое состояние
     * объекта,начиная с первого элемента, проверяем
     * его указатель на последний элемент(состояние,
     * которое соответствует реальному значению)
     *одновременно инкрементируем счетчик до тех пор,
     * пока он меньше index
     * @param index искомое значение
     * @return найденное значение
     */
    public E get (int index) {
        ListValue<E> target = firstListValue.getNextElement();
        for (int i = 0; i <index; i++) {
            target = getNextElement(target);
        }
        return target.getCurrentElement();
    }

    /**
     * вспомогательный метод-
     * помогает определить,относительно
     * какого текущего значения,будет
     * находиться указатель на
     * следующий элемент
     * @param current
     * @return - текущий элемент
     */
    private ListValue<E> getNextElement(ListValue<E> current){
        return current.getNextElement();
    }

    /**
     * итератор
     * @return - значение
     */
    @Override
    public Iterator<E> iterator() {
      return lastListValue;
    }

    /**
     * Класс описывающий структуру
     * объектов хранилища
     * @param <E>
     */
    public class ListValue<E> implements Iterator<E> {
        /**
         *текущее состояние
         */
        private E currentElement;
        /**
         * слкдующий элемент
         */
        private ListValue<E> nextElement;
        /**
         * предыдущий элемент
         */
        private ListValue<E> prevElement;
        /**
         * индекс-счетчик
         * */
        private int index = 0;

        /**
         * конструктор состояния
         * объектов в связанном списке
         * @param currentElement - текущий элемент
         * @param prevElement - предыдущий элемент
         * @param nextElement - следующий элемент
         */
        public ListValue(E currentElement, ListValue<E> prevElement, ListValue<E> nextElement) {
            this.currentElement = currentElement;
            this.nextElement = nextElement;
            this.prevElement = prevElement;
        }

        /**
         * @return- текущий элемент
         */
        public E getCurrentElement() {
            return currentElement;
        }

        /**
         * @param currentElement - текущий элемент
         */
        public void setCurrentElement(E currentElement) {
            this.currentElement = currentElement;
        }

        /**
         * @return
         */
        public ListValue<E> getNextElement() {
            return nextElement;
        }

        /**
         * @param nextElement
         */
        public void setNextElement(ListValue<E> nextElement) {
            this.nextElement = nextElement;
        }


        /**
         * если индекс вне диапазона
         * значений - false
         * @return сравниваем счетчики
         */
        @Override
        public boolean hasNext() {
            return index < size;
        }

        /**
         * возвращаем елемент
         * по индексу
         * @return
         */
        @Override
        public E next() {
            return (E)get(index++);
        }


    }

}
