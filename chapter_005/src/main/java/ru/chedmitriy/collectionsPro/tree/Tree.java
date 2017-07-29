package ru.chedmitriy.collectionsPro.tree;


import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Cherutsa Dmitry
 */
public class Tree<E extends Comparable<E>> implements SimpleTree<E> {
    private Node<E> root;
    private int size = 0;
    private int key = 0;
    Node<E>[] nodes;


    /**
     * Конструктор создает
     * новое дерево,где
     * сразу указывается корень
     * все остальные пары
     * будут добавляться
     * в список дочерних
     * Нод этого корня
     * @param value -
     *              корень дерева
     */
    public Tree(E value){

        root = new Node<>(null);
        root.value = value;
        nodes = new Node[16];

    }

    /**
     * Сначала определяем не пусто
     * ли значение root и равно ли оно
     * значению parent.
     * если значения равны,добавляем
     * в список root значение child.
     * Иначе делаем такое же сравнение с
     * дочерним элементом
     * В противном случае - вернется false
     * @param parent - родитель
     * @param child - дочерний элеент
     * @return -  true если добавление
     * прошло успешно
     */
    @Override
    public boolean add(E parent, E child) {
        if(root.getValue()!=null) {
            nodes[key++] = root;
        }
        Node<E> newRoot = null;
     if(root.getValue() != null && root.getValue().compareTo(parent)==0){
         root.children.add(new Node<>(child));
         size++;
     }
     else if(root.children.get(0).getValue()!= null && root.children.get(0).getValue().compareTo(parent)==0){
            newRoot = new Node<>(root.children.get(0).getValue());
            newRoot.children.add(new Node(child));
            root = newRoot;
            size++;
     }
     else return false;
     root = new Node<>(child);
     return true;
    }


    @Override
    public Iterator<E> iterator() {
     return new Iterator<E>() {
         int position = 0;

         @Override
         public boolean hasNext() {
             return nodes[position]!= null ? position < nodes.length:false;
         }

         @Override
         public E next() {
             return nodes[position++].getValue();
         }
     };
    }

    public Node<E> getRoot() {
        return root;
    }

    public void setRoot(Node<E> root) {
        this.root = root;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    /**
     * Класс Нод,
     * из которых состоит дерево
     * @param <E> - любая ссылочная переменная
     */
    public class Node<E>{
        private List<Node<E>> children;
        private E value;

        public Node() {
        }

        public Node(E value) {
            this.value = value;
            this.children = new LinkedList<>();
        }

        public E getValue() {
            return value;
        }
        public void setValue(E value) {
            this.value = value;
        }
    }

}
