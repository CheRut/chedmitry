package ru.chedmitriy.collectionsPro.tree;




import java.util.*;

/**
 * @author Cherutsa Dmitry
 */

public class Tree<E extends Comparable<E>> implements SimpleTree<E> {

    /**
     * корнево элемент дерева
     */
    private final Node<E> root;
    /**
     * множество всех нод
     * */
    private final Set<Node<E>> nodes;
    /**
     * список всех нод
     * */
    private final ArrayList<Node<E>> list;

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
        nodes = new HashSet<>();
        list = new ArrayList();
    }

    /**
     * Сначала определяем  равно ли значение корня
     * значению parent.
     * если значения равны,добавляем
     * в список root значение child.
     * Иначе делаем такое же сравнение с
     * дочерним элементом
     * @param parent - родитель
     * @param child - дочерний элемент
     * @return -  true если добавление
     * прошло успешно
     */
    @Override
    public boolean add(E parent, E child) {
        if(this.root.value.compareTo(parent)==0 ){
            this.root.children.add(new Node<>(child));
            nodes.add(root);
        }
        else {
            add(this.root,parent,child);
        }
        return true;
    }

    /**
     * добавляем элемент
     * в наше бинарное
     * дерево поиска
     * Здесь на первом этапе
     * определяем последнюю ноду
     * далее сравниваем компоратором
     * и заполняем "Листья" дерева
     *
     * @param e - добавляемый элемент
     * @return - true если все условия
     * выполнились
     */
    @Override
    public boolean add(E e) {
        Node<E> newNode = new Node<>(e);
        Node<E> lastNode = findLastNode(this.root, newNode);

        if (lastNode == null) { return false; }

        newNode.parent = lastNode;
        if (lastNode.value.compareTo(newNode.value) < 0) {
            lastNode.right = newNode;
            return true;
        } else {
            lastNode.left = newNode;
            return true;
        }
    }

    /**
     * поиск последней ноды
     * сравниваем компоратором
     * ранее существующие ноды и
     * ноду созданную на основе нового
     * значения
     * и по результату работы компоратора
     * рекурсивно смотрим либо правый лист ноды,либо левый.
     * @param root
     * @param newNode
     * @return
     */
    private Node<E> findLastNode(Node<E> root, Node<E> newNode) {
        Node<E> lastNode = root;
        int comp = root.value.compareTo(newNode.value);

        if(comp < 0 && root.right != null){
            lastNode = findLastNode(root.right,newNode);
        }
        if(comp>0&&root.left != null){
            lastNode = findLastNode(root.left,newNode);
        }
        if (comp == 0){
            return null;
        }
        depthFirstSearch(root);
        return lastNode;
    }

    /**
     * вспомогательный метод
     * проверяем равенство значения parent
     * со значением передаваемой
     * в параметр ноды
     * если значения не равны,рекурсивно
     * проверяем дочерние элементы по этому условию
     * @param findingNode - передаваемая в параметр нода
     * @param parent - искомое значение
     * @param child - значение дочернего элемента
     */
    private void add(Node<E> findingNode, E parent, E child){
        if(findingNode.value.compareTo(parent)==0){
            findingNode.children.add(new Node<>(child));
        }
        else {
            for (Node<E> v:findingNode.children){
                add(v,parent,child);
            }
        }
        depthFirstSearch(findingNode);
    }

    /**
     * Обход в глубину.
     * Здесь если  элемент дочернего
     * списка равен null помечаем
     * всю ноду посещенной если нет -
     * рекурсивное проходимся по списку
     * Также в этом методе заполняем множество
     * значений nodes
     * @param root переаваемый в параметр
     *             метода родитель
     * @return - true
     */
    private void depthFirstSearch(Node<E> root){
        nodes.add(root);
        for (Node<E> node:root.children){
            if (node==null ){
                return;
            }
            else {
                depthFirstSearch(node);
            }
        }
    }

    /**
     * циклический проход в глубину был
     * произведен ранее при наполнении множества
     * поэтому,просто проверяю в множестве нод
     * размеры дочерних списков
     *
     * @return true, если дерево бинарное
     */
    public boolean isBinary() {
        for(Node<E> node:nodes){
            if (node.children.size()>2){
                return false;
            }
        }
        return true;
    }

    /**
     * меткод по значению
     * находит ноду и возвращает
     * список дочерних
     * элементов
     * @param parentValue - искомый родитель
     * @return
     */
    public List<Node<E>>showNodeValues(E parentValue){
        for(Node<E> n:nodes){
            if (n.value.equals(parentValue)){
                return n.children;
            }
        }
        return null;
    }

    /**
     * переопределенный итератор
     * для списка элемента нод
     * Здесь в список нод заносим
     * элементы множества,
     * далее обращаясь к списку нод
     * получаем значения
     * @return
     */
    @Override
    public Iterator<E> iterator() {
        list.addAll(nodes);
        return new Iterator<E>() {
            int position = 0;
            @Override
            public boolean hasNext() {
                return  position < list.size();
            }
            @Override
            public E next() {
                return list.get(position++).value;
            }
        };
    }
    /**
     * Класс Нод,
     * из которых состоит дерево
     * @param <E> - любая ссылочная переменная
     */
    class Node<E> {

        /**
         * Список дочерних нод
         */
        private final List<Node<E>> children;

        /**
         * значение Ноды
         */
        private final E value;

        /**
         * уникальное число значения ноды
         */
        private int hash;

        /**
         * Левый лист
         */
        public Node<E> left;

        /**
         * правый лист
         */
        public Node<E> right;

        /**
         * родитель
         */
        public Node<E> parent;

        /**
         * конструктор нод
         * Каждая нода должна иметь какое-то
         * значение
         * @param value - значение ноды
         */
        public Node(E value) {
            this.value = value;
            this.children = new LinkedList<>();
        }

        /**
         * геттер
         * @return
         */
        public E getValue() {
            return value;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o instanceof Node) {
                Node<E> node = (Node<E>) o;
                return (
                        Objects.equals(value, node.getValue()) &&
                                Objects.equals(hash, node.hashCode()));
            }
            return false;
        }

        @Override
        public int hashCode() {
            hash = 31;
            hash = hash * 17 + value.hashCode();
            return hash;
        }

        public Node<E> getLeft() {
            return left;
        }

        public Node<E> getRight() {
            return right;
        }
    }

    public Set<Node<E>> getNodes() {
        return nodes;
    }
}
