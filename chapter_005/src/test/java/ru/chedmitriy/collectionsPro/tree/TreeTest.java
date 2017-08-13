package ru.chedmitriy.collectionsPro.tree;

import org.junit.Before;
import org.junit.Test;
import ru.chedmitriy.collectionsPro.list.cyclicity.Node;

import java.util.Iterator;

import static org.junit.Assert.*;

/**
 * @author Cherutsa Dmitry
 */
public class TreeTest {
    Tree<String> tree;
    @Before
    public void init(){
        tree = new Tree<>("8");
    }
    @Test
    public void add() throws Exception {
        tree.add("8","9");
        tree.add("9","1");
        tree.add("1","4");
        tree.add("4","6");

        Iterator it = tree.iterator();
        while (it.hasNext()){
            System.out.println(it.next());
        }


    }

}