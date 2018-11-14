package ru.chedmitriy.set.linkedlistbasedset;



import java.util.Iterator;


public class SetLinkedList<E> implements Iterable<E> {
    /**
     *  значение первого
     *  элемента контейнера
     */
    private Node<E> firstListValue;
    /**
     * значение последнего
     * элемента контейнера
     */
    private Node<E> lastListValue;
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
    public SetLinkedList() {
        lastListValue = new Node<E>(null, firstListValue, null);
        firstListValue = new Node<E>(null, null,  lastListValue);
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
        if (contains(someValue) == 0) {
            Node<E> prev = lastListValue;
            prev.setCurrentElement(someValue);
            lastListValue = new Node<E>(null,  prev,  null);
            prev.setNextElement(lastListValue);
            size++;
        }
    }
    public int contains(E checkingValue) {
        int nodeContainsSuchValue = 0;
        for (int i = 0; i < size; i++) {
            if (getNext(i).equals(checkingValue)) {
                nodeContainsSuchValue = -1;
                break;
            }
        }
        return nodeContainsSuchValue;
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
    public E getNext(int index) {
        Node<E> target = firstListValue.getNextElement();
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
    private Node<E> getNxtElement(Node<E> current) {
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
                return getNext(index++);
            }
        };
    }
    /**
     * Класс описывающий структуру
     * объектов хранилища
     * @param <E>
     */
    public class Node<E>  {
        /**
         *текущее состояние
         */
        public E currentElement;
        /**
         * слкдующий элемент
         */
        public Node<E> nextElement;
        /**
         * предыдущий элемент
         */
        public Node<E> prevElement;


        /**
         * конструктор состояния
         * объектов в связанном списке
         * @param currentElement - текущий элемент
         * @param prevElement - предыдущий элемент
         * @param nextElement - следующий элемент
         */
        public Node(E currentElement, Node<E> prevElement, Node<E> nextElement) {
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
        public Node<E> getNextElement() {
            return nextElement;
        }

        /**
         * @param nextElement - следующий элемент
         */
        public void setNextElement(Node<E> nextElement) {
            this.nextElement = nextElement;
        }
        /**
         * @param prevElement - предыдущий элемент
         */
        public void setPrevElement(Node<E> prevElement) {
            this.prevElement = prevElement;
        }
    }

}
