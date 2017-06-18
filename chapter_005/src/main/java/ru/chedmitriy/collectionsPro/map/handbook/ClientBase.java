package ru.chedmitriy.collectionsPro.map.handbook;



import java.util.Iterator;

/**
 * Created by d1msan on 18.06.2017.
 */
public  class ClientBase<T,V> implements Iterator {
    Client[] addressBook;
    T[] keySet;
    private int position = 0;
    public int nextIndex = 0;

    public ClientBase(int size) {
        this.addressBook = new Client[size];
        this.keySet = (T[])new Object[size];

    }

    @Override
    public boolean hasNext() {
        return this.addressBook.length > nextIndex;
    }

    @Override
    public Object next() {

        return this.addressBook[nextIndex++];
    }
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
    public boolean insert(T key,V value){
        if(checkKey(key) == -1){

            return false;
        }
        this.addressBook[position++] = new Client(key, value);
        next();

        return true;
    }
}
