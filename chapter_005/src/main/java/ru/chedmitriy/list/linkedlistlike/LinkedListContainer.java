package ru.chedmitriy.list.linkedlistlike;

import java.util.Iterator;

/**
 * Класс-контейнер
 * @param <E>  переменных,содержащиххся
 *           в контейнере
 */
public class LinkedListContainer<E> implements Iterable<E> {
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
        lastListValue = new ListValue<E>(null,  firstListValue, null);
        firstListValue = new ListValue<E>(null, null,  lastListValue);
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
     * и инкрементируем счетчик.
     *
     *
     * @param someValue
     */
    public void addLast(E someValue) {
        ListValue<E> prev = lastListValue;
        prev.setCurrentElement(someValue);
        lastListValue = new ListValue<E>(null, prev, null);
        prev.setNextElement(lastListValue);
        size++;
    }

    /**
     * Метод вставляет элементы в контейнер,
     * наследующий свойства LinkedListContainer
     * на первую позицию
     * @param someValue - добавляемый элемент
     */
    public void addFirst(E someValue) {
        ListValue<E> next = firstListValue;
        next.setCurrentElement(someValue);
        firstListValue = new ListValue<E>(null, null, next);
        next.setPrevElement(firstListValue);
        size++;
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
    public E getNext(int index) {
        ListValue<E> target = firstListValue.getNextElement();
        for (int i = 0; i < index; i++) {
            target = getNxtElement(target);
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
    private ListValue<E> getNxtElement(ListValue<E> current) {
        return current.getNextElement();
    }
    /**
     * Метод извлекает элемент
     * из вершины стэка и декрементирует
     * размер
     * @return  - извлекаемый элемент
     *
     * */
    public E remove() {
        E removedElement = getNext(size - 1);
        lastListValue = null;
        size--;
        return removedElement;
    }


    /**
     * @return Если размер контейнера равен 0,-
     * контейнер пуст,вернет true;
     * в противном слуяае вернет false;
     */
    public boolean empty() {
        return size == 0;
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
                return getNext(index++);
            }

        };
    }



    /**
     * Класс описывающий структуру
     * объектов хранилища
     * @param <E>
     */
    public class ListValue<E>  {
        /**
         *текущее состояние
         */
        public E currentElement;
        /**
         * слкдующий элемент
         */
        public ListValue<E> nextElement;
        /**
         * предыдущий элемент
         */
        public ListValue<E> prevElement;


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
         * @return - следующий элемент
         */
        public ListValue<E> getNextElement() {
            return nextElement;
        }

        /**
         * @param nextElement - следующий элемент
         */
        public void setNextElement(ListValue<E> nextElement) {
            this.nextElement = nextElement;
        }

        /**
         * @param prevElement - предыдущий элемент
         */
        public void setPrevElement(ListValue<E> prevElement) {
            this.prevElement = prevElement;
        }
    }

    /**
     * @return  - мнимый размер(количество всех Нод)
     */
    public int getSize() {
        return size;
    }


}
