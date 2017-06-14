package ru.chedmitriy.collectionsPro.map.handbook;

import ru.chedmitriy.collectionsPro.list.arrayListLike.ArrayIterator;

import javax.xml.crypto.Data;
import java.util.Iterator;

/**
 * Created by d1msan on 13.06.2017.
 */
public class Handbook<T,V> implements Iterable{
    ArrayIterator mapIterator;
    /**
     *
     */
    public Database<T,V>[] mapDataBase;

    /**
     *
     */
    public int position = 0;

    /**
     * @param size
     */
    public Handbook(int size) {
        this.mapDataBase = new Database[size];
        mapIterator = new ArrayIterator(mapDataBase);
    }

    /**
     * метод добавляет
     * новую пару ключ-значение
     * в массив данных
     * @param key - ключ нового объекта
     * @param value - значение нового объекта
     * @return - true если такого ключа нет
     *           в массиве
     * */
    boolean insert(T key, V value){
        this.mapDataBase[position++] = new Database(key,value);
        return true;
    }

    /**
     *
     * @param key
     * @return
     */
    V get (T key) {
        Database db = null;
        while(mapIterator.hasNext()){
            db = (Database) mapIterator.next();
            if(db.getKey().equals(key))
                break;
        }
        return (V)db.value;
    }

    /**
     * @param key
     * @return
     */
    boolean delete(T key){
        int index = 0;
        while(mapIterator.hasNext()){
           if(mapDataBase[index].equals(mapIterator.next())){
               System.out.println("удалено"+" - "+mapDataBase[index].getValue());
               mapDataBase[index] = null;
               break;
           }
           index++;
        }
        return false;
    }

    @Override
    public Iterator iterator() {
        return mapIterator;
    }


    /**
     *
     */
    public class Database<T,V>{
        T key;
        V value;

        /**
         * @param key
         * @param value
         */
        public Database(T key, V value) {
            this.key = key;
            this.value = value;
        }

        /**
         * @return
         */
        public T getKey() {
            return key;
        }

        /**
         * @param key
         */
        public void setKey(T key) {
            this.key = key;
        }

        /**
         * @return
         */
        public V getValue() {
            return value;
        }

        /**
         * @param value
         */
        public void setValue(V value) {
            this.value = value;
        }
    }
}
