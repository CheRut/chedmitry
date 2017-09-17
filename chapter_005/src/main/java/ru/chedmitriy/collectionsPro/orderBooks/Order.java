package ru.chedmitriy.collectionsPro.orderBooks;

import java.util.*;
/**
 * Класс,получающий
 * Заказы из файла.
 *
 * @author - cheDmitry
 * @since 16.09.2017
 * @version - 1.0
 */
class Order {
    /**
     * Уникальный ключ для
     * каждого объекта
     */
    private int hash;
    /**
     * Название типа книги
     * в заказе
     */
    private final String name;
    /**
     * Покупка или продажа в заказе
     */
    private final String operation;
    /**
     * цена проводимой операции
     */
    private final float price;
    /**
     * количество единиц товара в заказе
     */
    private final int volume;

    /**
     * порядковый номер заказа
     */
    private final int id;

    /** Конструктор заказов
     * @param name - имя книги в заказе
     * @param operation - операция в закакзе
     * @param price - стоимость сделки
     * @param volume - объем единиц товара
     * @param id - порядковый номер сделки
     */
    public Order(String name, String operation, float price, int volume, int id) {
        this.name = name;
        this.operation = operation;
        this.price = price;
        this.volume = volume;
        this.id = id;
    }

    /**
     * получаем имя
     * книги в заказе
     * @return - строка имя
     */
    public String getName() {
        return name;
    }

    /**
     * получаем состояние операции сделки
     * @return - строка BUY или SELL
     */
    public String getOperation() {
        return operation;
    }

    /**Получаем цену сделки
     * @return - число price
     */
    public float getPrice() {
        return price;
    }

    /**
     * получаем объем
     * единиц товара
     * @return -  число volume
     */
    public int getVolume() {
        return volume;
    }

    /**
     * получаем идентификатор сделки
     * @return - число id
     */
    public int getId() {
        return id;
    }

    /**
     * каждый объект типа Order
     * при запросе будет выводится
     * в соответствии с данным методом
     * @return - строка текст
     */
    @Override
    public String toString() {
        return volume +"@" + price+"\n";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o instanceof Order) {
            Order node = (Order) o;
            return (
                    Objects.equals(price, node.price) &&
                            Objects.equals(volume, node.volume)&&
                            Objects.equals(operation, node.operation)&&
                            Objects.equals(hash, node.hashCode()));
        }
        return false;
    }

    @Override
    public int hashCode() {
        hash = 31;
        hash = hash * 17 + id;
        return hash;
    }
}
