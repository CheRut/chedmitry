package ru.chedmitriy.collectionsPro.coins;

import java.util.*;

/**
 * ru.chedmitriy.collectionsPro.coins
 *
 * @author cheDmitry
 * @version 1.0
 * @since 23.11.2017
 *
 * имитируем выдачу сдачи
 * кофейным терминалов,
 * используя наименьшее количество
 * монет имеющегося номинала
 */
public class CoffeeMachine implements ListIterator<Integer> {

    /**
     * значение индекса списка
     * номиналов монет.
     */
    private int nominalsPosition = 0;
    /**
     * список значений имеющихся.
     * монет
     */
    private  int[] nominals;
    /**
     * монеты,полученные на сдачу.
     */
    private int[] coins;
    /**
     * номинал монеты,
     * получченной на сдачу.
     */
    private int changeNominal;
    /**
     * индекс - позиция элемента,
     * куда добавляется соответствующий
     * номинал монеты
     */
    private int pos;

    /**
     * определяем начальные условия
     */
      CoffeeMachine() {
        nominals = new int[] {10,5,2,1};
        coins = new int[10];
        changeNominal = 0;
        pos = 0;
    }

    /**
     * суммирум значения в списке
     * выданных на сдачу монет.
     * @return - сумма всех монет,полученных на сдачу
     *
     */

    private int summArrArguments() {
        int result = 0;
        for(int i: coins) {
            result += i;
        }
        return result;
    }

    /**
     * определяем мнимальное количество монет,
     * выдаваемых на сдачу.
     *
     * @param value - значение
     *              номинала внесенной купюры
     * @param price - цена
     *
     * @return - монеты,
     * выданные на сдачу
     */
    public int[] changes(int value,int price) {
        int c = value - price;

        while (true) {
            if (summArrArguments() >= value - price ) {
                break;
            }
            changeNominal = next ();
            if (changeNominal > c) {
                changeNominal = next ();
            } else {
                coins[pos++] = changeNominal;
                c -= changeNominal;

            }
            if (changeNominal < c) {
                previous ();
            }

        }

        return coins;
    }


    @Override
    public boolean hasNext () {
        return nominalsPosition < nominals.length;
    }

    @Override
    public Integer next () {
        return nominals[nominalsPosition++];
    }

    /**
     * @return - true, если значение
     * индекса в списке номиналов не меньше нуля.
     *
     * */

    @Override
    public boolean hasPrevious () {
        return nominalsPosition >= 0;
    }

    /**
     * @return - Возвращает предыдущий элемент в списке
     * и перемещает позицию курсора назад.
     * */

    @Override
    public Integer previous () {
        return nominals[nominalsPosition--];
    }

    @Override
    public int nextIndex () {

        // Возвращаем индекс элемента,
        // который был бы возвращен
        // последующим звонком next().
        return 0;
    }

    @Override
    public int previousIndex () {

        // Возвращаем индекс элемента,
        // который был бы возвращен
        // последующим звонком previous().
        return 0;
    }

    @Override
    public void remove () {

        //Удаляем из списка последний элемент,
        // который был возвращен next() или previous()
    }

    @Override
    public void set (Integer integer) {

        //Заменяем последний элемент,
        // возвращенный next() или previous()
        // с указанным элементом.
    }

    @Override
    public void add (Integer integer) {

        //Вставляем указанный элемент в список.
    }


}
