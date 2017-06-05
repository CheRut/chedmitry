package ru.chedmitriy.collectionsPro.list.cyclicity;

import org.junit.Test;

import static org.junit.Assert.*;

public class NodeTest {
    @Test
    public void hasCycle() throws Exception {
        Node first = new Node(1);
        Node two = new Node(2);
        Node third = new Node(3);
        Node four = new Node(4);

        first.next = two;
        two.next = third;
        third.next = four;
        four.next = first;
        assertTrue(four.hasCycle(two));
    }

}