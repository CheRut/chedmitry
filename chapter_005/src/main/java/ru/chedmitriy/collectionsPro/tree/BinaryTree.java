package ru.chedmitriy.collectionsPro.tree;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by dimsan on 20.08.17.
 */
public class BinaryTree<E extends Comparable<E>>implements SimpleTree<E> {
    private Node<E> root;
    private List<Node<E>> nodes;

    public BinaryTree(E rootValue){
        this.root = new Node<>(rootValue);
        nodes = new LinkedList<>();
    }
    @Override
    public boolean add(E parent, E child) {
        return false;
    }

    @Override
    public boolean isBinary() {
        return false;
    }
    public boolean add(E e){
        return false;
    }
    public Node<E> findNode(E e){
        Node<E> findingNode = new Node<E>(e);
        depthFirstSearch(findingNode);
        for (Node<E>n:nodes){
            if (n.value.compareTo(e)==0){
                return n;
            }
        }
       return null;
    }
    public void depthFirstSearch(Node<E> root){
        if(root.visited){
            nodes.add(root);
        }
        for (Node<E> node:root.children){
            if (node == null ){
                root.visited = true;
            }
            else {
                depthFirstSearch(node);
                node.visited = true;
            }
        }
    }
    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            int index = 0;
            @Override
            public boolean hasNext() {
                return false;
            }

            @Override
            public E next() {
                return null;
            }
        };
    }
    public class Node<E>{
        private  E value;
        private Node<E> right;
        private Node<E> left;
        private List<Node<E>> children;
        boolean visited = false;

        public Node(E value){
            this.value = value;
            this.children = new LinkedList<>();
        }
    }

}
