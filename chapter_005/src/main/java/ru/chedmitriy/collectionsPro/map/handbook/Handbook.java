package ru.chedmitriy.collectionsPro.map.handbook;

import java.util.Iterator;
import java.util.Objects;


/**
 * Работа с Хэш таблицами
 * @author Cherutsa Dmitry
 *
 * */
public class Handbook<T,V> implements HandbookManage<T,V> {
    /**
     * справочник - массив
     * объектов Node
     */
    private Node<T, V>[] hashTable;
    /**
     * емкость массива
     * */
    private int capacity = 0;
    /**
     * параметр расширения массива:
     */
    private float arrayTreshould;

    /**
     * количество элементов
     * в массиве
     */
    private int size = 0;

    /**
     * конструктор справочника:
     * изначально создаем массив
     * размером 16.
     * Параметру arrayTreshould задаем
     * значение равное три четверти от
     * существующего размера массива
     * 0.75f-степень загрузки
     * параметру емкости  присваиваем
     * длину массива
     */
    public Handbook() {
        hashTable = new Node[16];
        arrayTreshould = hashTable.length * 0.75f;
        capacity = hashTable.length;
    }

    /**
     * итератор для работы со
     * справочником.
     * Здесь:создаем итератор самого справочника
     * метод next() возвращает значение ноды
     * Если нода в ячейке равна null,
     * инкрементируем индекс ячейки,
     * если не равна null, возвращаем значение
     * @return Iterator
     */
    @Override
    public Iterator<V> iterator() {
        return new Iterator<V>() {
            //счетчик элементов массива
            int position = 0;
            @Override
            public boolean hasNext() {
                return position < hashTable.length;
            }

            @Override
            public V next() {
                V value = null;
                if (hashTable[position] != null) {
                    value = hashTable[position].getValue();
                    position++;
                } else {
                    position++;
                }
                return value;
            }
        };
    }

    /**
     * класс объектов Node,
     * содержащихся в
     * справочнике
     * @param <T> - ключ
     * @param <V> - значение
     */
    private class Node<T, V> {
        /**
         * ключ
         */
        private T key;
        /**
         * значение
         */
        private V value;

        /**
         * хэшкод Ноды
         */
        private int hash;

        /**
         * конструктор объектов
         *
         * @param key   - ключ
         * @param value - значение
         */
        private Node(T key, V value) {
            this.key = key;
            this.value = value;
        }
        /**
         * @return ключ
         */
        public T getKey() {
            return key;
        }
        /**
         * @return - значение
         */
        public V getValue() {
            return value;
        }
        /**
         * @param key - ключ ноды
         */

        public void setKey(T key) {
            this.key = key;
        }
        /**
         * @param value - значение ноды
         */
        public void setValue(V value) {
            this.value = value;
        }

        /**
         * переопределяем метод equals();
         * Сначала сравниваем ссылки
         * на объекты если они не равны
         * проверяем тип параметра.
         * Если типы объектов равны,сравниваем поля
         * и параметр hash()
         *
         * @param o - передаваемый объект
         * @return false, если объекты по
         * какому-то из полей не равны
         */
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o instanceof Node) {
                Node<T, V> node = (Node) o;
                return (Objects.equals(key, node.getKey()) &&
                        Objects.equals(value, node.getValue()) &&
                        Objects.equals(hash, node.hashCode()));
            }
            return false;
        }

        /**
         * Для мимнимализации
         * вероятности выпадания колизий,
         * переопределяем hashCode()
         * таким образом:
         * берем число 31 и умножаем его
         * на 17(чтобы еще больше снизить
         * вероятность колизий) и суммируем
         * значение с hash-кодом ключа
         * Тоже самое выполняем для значения
         * и суммируем результаты.
         *
         * @return - полученный результат
         */
        @Override
        public int hashCode() {
            hash = 31;
            hash = hash * 17 + key.hashCode();
            hash = hash * 17 + value.hashCode();
            return hash;
        }
    }

    /**
     * hash - функция
     * для получения индекса
     * ячейки массива,где
     * будет располагаться  список объектов
     *
     * @param key - ключ объекта Node
     * @return - номер ячейки
     */
    private int hash(final T key) {
        int hash = 31;
        hash = hash * 17 + key.hashCode();
        return hash % hashTable.length;
    }

    /**
     * метод обеспечивает вставку
     * новой пары ключ-значение
     * Здесь:
     * расширяем массив если необходимо;
     * создаем параметр index(индекс ячейки)
     * присваиваем ему значение hash по ключу
     * Если ячейка по этому индексу пуста,
     * добавляем объект Node с
     * ключом и значением,переданными
     * методу.
     *
     *
     * @param key - ключ
     * @param value - значение
     * @return true при успешном добавлении
     */
    @Override
    public boolean insert(T key, V value) {
        if (size + 1 >= arrayTreshould) {
            arrayTreshould *= 2;
            arrayDoubling();
        }
        Node<T, V> newNode = new Node<>(key, value);
        int index = hash(key);
        return add(index, newNode);
    }

    /**
     * добаление Объекта по индексу
     * сначала проверяем наличие такого ключа,
     * находим ячейку,которая ссответствует
     * параметру index,
     * создаем в ней пустой объект Node(null,null)
     * инкрементируем размер
     *
     * @param index   - значение индекс
     *                уже определено в
     *                методе insert,поэтому передаем
     *                просто его значение.
     * @param newNode - добавляемый объект
     * @return - true если успех.
     */
    private boolean add(int index, Node<T, V> newNode) {
        if (!keyWasFound(index, newNode)) {
            return false;
        }
        hashTable[index] = new Node<>(null, null);
        hashTable[index].setValue(newNode.getValue());
        hashTable[index].setKey(newNode.getKey());
        size++;
        return true;
    }

    /**
     * если ключ добавляемого объекта совпадает
     * с ключом существующего в списке
     * объекта,при этом их значения разные,тогда
     * перезаписываем значение этого объекта
     * новым
     *
     * @param newNode      - новый объект
     * @return - true, если ключи совпадают
     */
    private boolean keyWasFound(final int index, final Node<T, V> newNode) {
        if (hashTable[index]!=null){
            if (newNode.getKey().equals(hashTable[index].getKey())){
                size--;
                return false;
            }
        }
        return true;
    }



    /**
     * Метод находит объект по ключу
     * и удаляет его,возвращая true
     * Алгоритм:
     * получаем индекс по хэш функции ключа
     * если ячейка с таким индексом null,
     * удалять нечего,возвращаем false
     *
     * @param key - искомый ключ
     * @return - true при нахождении объекта с таким ключом
     */
    @Override
    public boolean delete(T key) {

        int index = hash(key);
        if (hashTable[index] == null) {
            return false;
        }
        else {
            hashTable[index] = null;
            size--;
        }
        return true;
    }

    /**
     * Метод для получения
     * объекта по ключу
     * Алгоритм:
     * создаем параметр index,
     * присваиваем ему хэш-функцию по ключу
     * проверяем условие:
     * если ячейка под этим индексом не равна null
     * возвращаем  значение.
     *
     * @param key - ключ
     * @return - значение или null при отстутствии содержимого в ноде
     */
    @Override
    public V get(T key) {
        int index = hash(key);
        if (index < hashTable.length &&
                hashTable[index] != null) {
            return hashTable[index].getValue();
        }
        return null;
    }

    /**
     * @return размер массива
     */
    @Override
    public int size () { return size;
    }
    /**
     * увеличиваем размер массива в два раза
     * пуутем создания нового массива
     * и записи в него значений из старого массива
     */

    private void arrayDoubling() {
        Node<T, V>[] oldHandBook = hashTable;
        capacity = oldHandBook.length*2;
        hashTable = new Node[capacity];

        size = 0;
        for (Node<T,V> node :oldHandBook){
            if(node !=null){
                insert(node.key,node.value);
            }
        }

    }

    /**
     * @return - емкость массива
     */
    public int getCapacity() {
        return capacity;
    }
}
