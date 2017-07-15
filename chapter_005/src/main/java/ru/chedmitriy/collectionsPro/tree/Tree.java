package ru.chedmitriy.collectionsPro.tree;


import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Cherutsa Dmitry
 */
public class Tree<E extends Comparable<E>> implements SimpleTree<E> {
    private Node<E>root;
    private int size = 0;

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

    }

    /**
     * Если текущий root
     * равен parent,добавляем
     * в список children элемнт
     * child-инкрементируем параметр size
     * возвращаем true...
     * В противном случае - вернется false
     * @param parent - родитель
     * @param child - дочерний элеент
     * @return -  true если добавление
     * прошло успешно
     */
    @Override
    public boolean add(E parent, E child) {
        if (root.value.compareTo(parent)!=0){
            return false;
        }
        if(root.value.compareTo(parent)==0){
            root.children.add(new Node<>(child));
            root = new Node<>(child);
            size++;
        }

        return true;
    }


    @Override
    public Iterator<E> iterator() {
     return null;
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
    private class Node<E>{
        private List<Node<E>> children;
        private E value;

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
