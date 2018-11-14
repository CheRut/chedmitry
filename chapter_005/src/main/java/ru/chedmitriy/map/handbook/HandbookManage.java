package ru.chedmitriy.map.handbook;

/**
 * интерфейс справочника
 * здесь предложен перечень методов,которые будут использоваться
 * при работе с хэш - таблицей
 */
public interface HandbookManage<T, V> extends Iterable<V> {

    /**
     * Метод добавляет объекты
     * @param key - ключ
     * @param value - значение
     * @return - true или false;
     */
    boolean insert(T key, V value);

    /**
     * метод удаляет объекты
     * по ключу
     * @param key - ключ
     * @return - true или false
     */
    boolean delete(T key);

    /**
     * Метод вовращает
     * значение по ключу
     * @param key - ключ
     * @return - значение
     */
    V get(T key);

    /**
     * метод возвращает
     * количество объектов
     * в таблице
     * @return число элементов
     */
    int size();
}