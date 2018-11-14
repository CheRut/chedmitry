package ru.chedmitriy.tree;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * @author Cherutsa Dmitry
 */
public class TreeTest {
    Tree<Integer> tree;

    @Before
    public void init() {
        tree = new Tree<>(8);
        tree.add(3);
        tree.add(10);
        tree.add(1);
        tree.add(14);
        tree.add(6);
        tree.add(4);
        tree.add(7);
        tree.add(13);
    }

    @Test
    public void whenParentNodeWasFound() throws Exception {
        for (Tree.Node n : tree.showNodeValues(10)) {
            assertThat(n.getValue(), is(14));
        }
    }

    @Test
    public void isBinaryTreeCheck() {
        assertTrue(tree.isBinary());
    }

    @Test
    public void isNotBinaryTree() {
        tree.add(8, 17);
        assertFalse(tree.isBinary());
    }

    @Test
    public void leafsCheck() {
        for (Tree.Node n : tree.getNodes()) {
            System.out.println("parent- "
                    + n.getValue() + ": " + "left - "
                    + n.left + "; " + "right - " + n.right);
        }
    }

    @Test
    public void whenLeafsChecking() {
        for (Tree.Node n : tree.showNodeValues(6)) {
            assertThat(n.getRight(), is(7));
            assertThat(n.getLeft(), is(4));

        }
    }
}
