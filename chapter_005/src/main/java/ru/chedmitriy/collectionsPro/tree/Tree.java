package ru.chedmitriy.collectionsPro.tree;



import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeSet;

/**
 * @author Cherutsa Dmitry
 */
public class Tree<E extends Comparable<E>> implements SimpleTree<E> {
    private Node<E> root;
    private Node<E> rootNode;
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
        root = new Node<>(value);
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
        if(dfs(root,parent))
            root.children.add(new Node<>(child));
        else {
            root = new Node<>(parent);
            root.children.add(new Node<>(child));
        }
        System.out.println(root.value);

        return true;

    }

    public boolean dfs(Node<E> root,E parent) {
        if (root.value.equals(parent)) {
            System.out.println(root.value);

            return true;
        } else for (Node<E> v : root.children) {
            if (v.value.equals(parent)) {
                System.out.println(v.value);
                return true;
            }
            return dfs(v, parent);
        }
        return false;
    }
    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {

            int position = 0;


            E value = null;

            @Override
            public boolean hasNext() {
                return nodes[position]!= null ? position < size:false;
            }

            @Override
            public E next() {
                value = root.value;


                if (nodes[position].children.get(0) != null) {
                    value = nodes[position].children.get(0).getValue();
                }
                else {
                    value = nodes[position].value;
                }

                position++;
                return value;
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
