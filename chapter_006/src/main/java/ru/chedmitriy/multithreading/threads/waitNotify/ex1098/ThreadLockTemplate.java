package ru.chedmitriy.multithreading.threads.waitNotify.ex1098;

/**
 * junior
 *
 * @author CheDmitry
 * @version 1.0
 * @since 09.11.17
 */
public class ThreadLockTemplate {
    public static void main(String[] args) {
        Store store = new Store(5);
        new Producer(store).start();
        new Customer(store).start();
    }


}

/**
 * класс - склад
 * определяет добавление
 * или получение товара
 */
class Store {

    /**
     * вместимость склада
     */
    private final int size;

    /**
     * счетчик товара
     */
    private int count = 0;


    /**
     * конструктор,
     * определяющий размер склада
     * @param size - значение типа int
     */
    public Store(int size) {
        this.size = size;

    }


    /**
     * добавляем товар на склад
     * @throws InterruptedException
     */
    public synchronized void add() throws InterruptedException {
        while (count >= 5) {
            wait();
        }
        this.count++;
        System.out.print(String.format("%s %s %s%n",
                "Счетчик хранилища увеличен на 1",
                     "количество на складе:",   count));
        notify();
    }

    /**
     * получаем товар со
     * склада
     * @throws InterruptedException
     */
    public synchronized void get() throws InterruptedException {
        while(this.count <= 0) {
            wait();
        }
        this.count--;
        System.out.print(String.format("%s %s%n",
                "Получена единица товара. На складе осталоь:",
                         count));


    }


    /**
     * получаем размер
     * хранилища
     * @return
     */
    public int getSize() {
        return size;
    }
}

/**
 * класс - поток
 * предназначен для того,чтобы
 * добавлять значения в
 * хранилище
 */
class Producer extends Thread {
    /**
     * объект хранилища
     */
    private final Store store;

    /**
     * конструктор потока
     * добавления значения
     * @param store - объект
     *              хранилища
     */
    Producer(Store store) {
        super();
        this.store = store;
    }

    @Override
    public void run() {
        for (int i = 0; i < this.store.getSize() ; i++) {
            try {
                this.store.add();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}

/**
 * контруктор потока
 * получения значений
 * хранилища
 *
 */
class Customer extends Thread {
    /**
     * объект хранилища
     */
    private final Store store;

    /**
     * конструктор потока
     * получающего, значения
     * из хранилища
     * @param store - объект
     *              хранилища
     */
    Customer(Store store) {
        super();
        this.store = store;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < 5 ; i++) {
                this.store.get();
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }

}