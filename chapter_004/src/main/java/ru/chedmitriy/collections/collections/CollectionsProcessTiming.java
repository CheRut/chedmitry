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
            collection.add(line);
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
     * Алгоритм:
     * Так как все типы коллекций отличаются,
     * решено использовать вспомогательный объект
     * Vector,позволяющий удалять объекты по индексу.
     * При удалении,в коллекции не образуется "дыр"(как
     * например в Array,которые заменяются
     * null при удалении) поэтому достаточно n раз удалить
     * первый элемент массива; однако это правило будет плохо сказываться
     * на TreeSet, где при каждом вызове метода,будет разный результат.
     * Это объясняется тем,что в TreeSet объекты хранятся отсортированными
     * по возрастанию в порядке сравнения.
     * Далее,я просто очищаю принятый контейнер и заношу в него
     * элементы Vector
     **/

    public long delete(Collection<String> collection, final int amount) {
        int index = 0;
        Vector<String> vector = new Vector<>();
        start = System.nanoTime();
        for (String lines:collection) {
            vector.add(lines);
        }
        while(index<amount) {
            vector.remove(0);
            index++;
        }
        long endTime = System.nanoTime() - start;
        collection.clear();
        collection.addAll(vector);
        cIO.outPrintln(endTime+" - "+collection.getClass().getCanonicalName()+" при операции удаления");
        return endTime;
    }

}
