package ru.chedmitriy.list.cyclicity;

public class Node<T>  {
    /**
     * элемент Ноды
     * */
    T value;
    /**
     * следующая Нода
     * */
    Node<T> next;

    /**
     * Конструктор новой Ноды
     * @param value - передаваемый
     *              параметр -элемент
     *              Ноды
     */
    public Node(T value) {
        this.value = value;
    }


    /**
     * Метод -алгоритм Флойда:
     * Создаются два состояния Ноды
     * в один шаг-slow
     * и два шага - fast.
     * При замкнутом цикле
     * состояние fast при повторном прохождении
     * цикла совпадет с соттояние slow -
     * что и будет отвечать
     * требованию замкнутости цикла.
     * Алгоритм:
     * создаются две Ноды -slow  и fast
     * стартовая Нода(first) - не null;
     * Далее,выбрав в качестве
     * старта для двух состояний
     * first ноду,присваиваем ее значение
     * нодам slow и fast.
     * Перебираем следующие
     * элементы для обеих Нод:
     * причем,для ноды slow
     * следующий элемент определяется с
     * интервалом в одну позицию,
     * а для fast - две...
     * соответственно,если цикл замкнут,
     * fast нода пройдет круг первой и будет
     * приближаться к завершающей
     * цикл slow Ноде.
     * Если же обе Ноды "встретятся",-
     * цикл замнкнут
     *
     *
     * @param first - стартовая Нода
     * @return - true если "быстрая" и "медленная" Ноды
     * встретятся
     */
    boolean hasCycle(Node<T> first) {
        if (first == null) {
            return false;
        }
        Node<T> slow, fast;
        slow = first;
        fast = slow;

        while (true) {
            slow = slow.next;
            if (fast.next != null) {
                fast = fast.next.next;
            } else {
                return false;
            }
            if (slow == null || fast == null) {
                return false;
            }
            if (slow == fast) {
                return true;
            }
        }
    }
}
