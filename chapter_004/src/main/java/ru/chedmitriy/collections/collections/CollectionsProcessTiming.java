package ru.chedmitriy.collections.collections;


import ru.chedmitriy.collections.modifiingTracker.objects.ConsoleInput;

import java.util.*;


public class CollectionsProcessTiming {
    ConsoleInput cIO = new ConsoleInput();

    /**.
     * Время начала действия
     * */
    private long start;
    /**
     * Добавляем строки в контейнере
     * общим для всех типов методом
     * @param collection - экземпляр объекта Collection
     *                   в который добавляются строки
     * @param line - добавляемая строка
     * @param amount - количество добавляемых строк
     * @return  - количество наносекунд,которое потребовалось на
     * выполнение действия
     * */

    public long add(final Collection<String> collection, final String line, final int amount) {
        start = System.nanoTime();
        for (int i = 0; i < amount; i++) {
            collection.add(line+i);
        }
        long endTime = System.nanoTime() - start;

        return endTime;
    }
    /**.
     * Метод удаляет строки из контейнера
     * @param collection - контейнер из
     *                   которого удаляются
     *                   строки
     *  @param amount - количество строк
     *                с начала контейнера
     *
     **/
    public long delete(Collection<String> collection, final int amount) {
        int index = 0;
        Iterator<String> iterator = collection.iterator();
        start = System.nanoTime();
        while (iterator.hasNext() && index < amount) {
            iterator.next();
            iterator.remove();
            index++;
        }
        long endTime = System.nanoTime() - start;
        cIO.outPrintln(String.format("%5s %5s %5s %5s%n",endTime,"-",collection.getClass().getCanonicalName(),
                "при операции удаления"));
               return endTime;
    }
}
