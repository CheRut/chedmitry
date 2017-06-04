package ru.chedmitriy.collectionsPro.list.linkedListLike;

import ru.chedmitriy.collectionsPro.list.stack.BackIterator;

import java.util.Iterator;

/**
 * Класс-контейнер
 * @param <E>  переменных,содержащиххся
 *           в контейнере
 */
public class LinkedListContainer<E> implements Iterable<E>,BackIterator<E>{
    /**
     *  значение первого
     *  элемента контейнера
     */
    protected ListValue<E> firstListValue;
    /**
     * значение последнего
     * элемента контейнера
     */
    protected ListValue<E> lastListValue;
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
    public void linkLast(E someValue) {
        final ListValue<E> l = lastListValue;
        final ListValue<E> newNode = new ListValue<>(l, someValue, null);
        lastListValue = newNode;
        if (l == null)
            firstListValue = newNode;
        else
            l.nextElement = newNode;
        size++;
    }
    public void addLast(E e) {
        linkLast(e);
    }
    /**
     * Метод добавляет
     * элемент в начало контейнера
     * @param someValue
     */
    public void linkFirst(E someValue) {
        final ListValue<E> f = firstListValue;
        final ListValue<E> newNode = new ListValue<E>(null, someValue, f);
        firstListValue = newNode;
        if (f == null)
            lastListValue = newNode;
        else
            f.prevElement = newNode;
        size++;
    }
    public void addFirst(E e) {
        linkFirst(e);
    }

    public E poll() {
        final ListValue<E> f = firstListValue;
        return (f == null) ? null : unlinkFirst(f);
    }

    private E unlinkFirst(ListValue<E> f) {
        // assert f == first && f != null;
        final E element = f.currentElement;
        final ListValue<E> next = f.nextElement;
        f.currentElement = null;
        f.nextElement = null; // help GC
        firstListValue = next;
        if (next == null)
            lastListValue = null;
        else
            next.prevElement = null;
        size--;
        return element;
    }
    private E unlinkLast(ListValue<E> l) {
        // assert l == last && l != null;
        final E element = l.currentElement;
        final ListValue<E> prev = l.prevElement;
        l.currentElement = null;
        l.prevElement = null; // help GC
        lastListValue = prev;
        if (prev == null)
            firstListValue = null;
        else
            prev.nextElement = null;
        size--;

        return element;
    }
     /**
     * Удаляем последний элемент
     * @return - удаляемый элемент
     */
    public  E removeLastElement(){
        ListValue<E>last = lastListValue.getPrevElement();
        lastListValue = new ListValue<E>(null,null,null);
         size--;
        return last.getCurrentElement();
    }
    public E removeFirstElement(){
      firstListValue.setPrevElement(null);
      return firstListValue.getCurrentElement();

    }
    /**
     * @return размер контейнера
     */
    public int getSize() {
        return size;
    }

    /**
     * метод для изменения
     * параметра размера контейнера
     * @param size
     */
    public void setSize(int size) {
        this.size = size;
    }

    /**
     * Метод создает новое состояние
     * объекта,начиная с первого элемента, проверяем
     * его указатель на последний элемент(состояние,
     * которое соответствует реальному значению)
     * одновременно инкрементируем счетчик до тех пор,
     * пока он меньше index
     * @param index искомое значение
     * @return найденное значение
     */
    public E get (int index) {
        ListValue<E> target = firstListValue.getNextElement();
            for (int i = 0; i < index; i++) {
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

        return new Iterator<E>() {
            int index = 0;
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
                return get(index++);
            }
        };
    }

    @Override
    public Iterator<E> backIterator() {
        return new Iterator<E>() {
            int index = size - 1;
            @Override
            public boolean hasNext() {
                return index >= 0;
            }
            @Override
            public E next() {
                return get(index--);
            }
        };
    }

    /**
     * Класс описывающий структуру
     * объектов хранилища
     * @param <E>
     */
    public class ListValue<E> {
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
        public ListValue(ListValue<E> prevElement, E currentElement, ListValue<E> nextElement) {
            this.currentElement = currentElement;
            this.nextElement = nextElement;
            this.prevElement = prevElement;
        }

        public ListValue<E> getPrevElement() {
            return prevElement;
        }

        public void setPrevElement(ListValue<E> prevElement) {
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
         * @return ListValue<E>
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





    }

}
