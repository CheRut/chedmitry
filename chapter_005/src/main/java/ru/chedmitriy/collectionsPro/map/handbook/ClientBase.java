package ru.chedmitriy.collectionsPro.map.handbook;
import java.util.Iterator;
/**
 * Класс,спарвочник клиентов
 * определенныых классом Client
 * @see Client;
 *
 */
public  class ClientBase<T,V> implements Iterator {
    /**
     * массив клиентов-
     * справочник
     * */
    Client[] addressBook;

    /**
     * позиция клиентов
     * в массиве - справочнике
     * */
    private int position = 0;
    /**
     * индекс -значение при
     * перечислении
     * */
    public int nextIndex = 0;

    /**
     * констуктор,определяющий
     * начальное состояние справочника
     * @param size - задаем размер справочнику
     */
    public ClientBase(int size) {
        this.addressBook = new Client[size];
    }
    /**
     * переопределим метод
     * hasNext()
     * @return true если в массиве есть элементы
     */
    @Override
    public boolean hasNext() {
        return this.addressBook.length > nextIndex;
    }

    /**
     * перечисление элементов
     * @return - следующий элемент массива
     */
    @Override
    public Object next() {
        return this.addressBook[nextIndex++];
    }
    /**
     * Метод проверяет наличие
     * передаваемого ключа
     * в справочнике.
     * @param key - передаваемый ключ
     * @return 0 если ключа нет и -1
     * если такой ключ уже
     * содержится в массиве
     */
    public int checkKey(T key){
        int checker = 0;
        for(Client c:addressBook)
        {
            if(c!=null){
                if(c.getKey().equals(key)){
                    checker = -1;
                }
            }
        }
        return checker;
    }
    /**
     * Добавляем новых
     * клиентов в справочник
     * после проверки условия
     * наличия ключа
     * @param key - ключ
     * @param value - значение
     * @return true если значения с
     * ключом key нет в справочнике,
     * в противном случае - вернет false
     * и значение не добавится
     */
    public boolean insert(T key,V value){
        if(checkKey(key) == -1){
            return false;
        }
        this.addressBook[position++] = new Client(key, value);
        return true;
    }
    /**
     * получаем значение
     * по ключу;
     * @param key
     * @return
     */
    public V get(T key){
        Client cli = null;
        while(hasNext()){
            cli = (Client)next();
            if(cli.getKey().equals(key))break;
        }
        return (V)cli.getValue();
    }
    /**удаляем
     * клиента по
     * ключу*/
    public  boolean delete(T key){
        for(Client c:addressBook){
            if(c.getKey().equals(key)){
                c.setKey(null);
                c.setValue(null);
                return true;
            }
        }
        return false;
    }
}
