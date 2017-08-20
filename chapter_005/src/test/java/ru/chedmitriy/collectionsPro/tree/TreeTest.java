package ru.chedmitriy.collectionsPro.tree;

import org.junit.Before;
import org.junit.Test;
import ru.chedmitriy.collectionsPro.list.cyclicity.Node;

import java.util.Iterator;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * @author Cherutsa Dmitry
 */
public class TreeTest {
    Tree<String> tree;
    @Before
    public void init(){
        tree = new Tree<>("8");
        tree.add("8","9");
        tree.add("9","1");
        tree.add("8","4");
        tree.add("4","6");
        tree.add("9","3");
        tree.add("1","7");
        tree.add("7","12");
        tree.add("12","14");
    }
    @Test
    public void whenParentNodeWasFound() throws Exception {
        for (Tree.Node n:tree.showNodeValues("4")){
            assertThat(n.getValue(),is("6"));
        }

  }
  @Test
    public void isBinaryTreeCheck(){
        assertTrue(tree.isBinary());

  }
  @Test
    public void isNotBinaryTree(){
      tree.add("8","17");
      assertFalse(tree.isBinary());
  }

}