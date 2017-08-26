package ru.chedmitriy.collectionsPro.tree;

import java.util.List;

/**
 * @author Cherutsa Dmitry
 */
public interface SimpleTree< E extends Comparable<E>> extends Iterable<E> {
    boolean add(E parent,E child);
    boolean isBinary();

}
