package ru.geekbrains;

public class DoubleList {
    Node head;
    Node tail;

    public class Node {
        int value;
        Node next;
        Node previous;

        @Override
        public String toString() {
            return "Node{" +
                    "value=" + value +
                    ", next=" + next +
                    '}';
        }
    }

    public void printList() {
        Node currentNode = head;
        while (currentNode != null) {
            System.out.print(currentNode.value + " ");
            currentNode = currentNode.next;
        }
        System.out.println();
    }

    public void addFirst(int value) {
        Node node = new Node();
        node.value = value;

        if (head == null) {
            head = node;
            tail = node;
        } else {
            head.previous = node;
            node.next = head;
            head = node;
        }
    }

    public void remove() {
        if (head != null && head.next != null) {
            head = head.next;
            head.previous = null;
        } else {
            head = null;
            tail = null;
        }
    }

    /**
     * @param value предаваемое значение
     * @return
     * @apiNote проверка, есть ли элемент
     */
    public boolean contains(int value) {
        Node currentNode = head;
        while (currentNode != null) {
            if (currentNode.value == value) {
                return true;
            }
            currentNode = currentNode.next;
        }
        return false;
    }

    public void addLast(int value) {
        Node node = new Node();
        node.value = value;
        if (tail != null) {
            tail.next = node;
            node.previous = tail;
            tail = node;
        } else {
            tail = node;
            head = node;
        }
    }

    public void removeLast() {
        if (tail != null && tail.previous != null) {
            tail.previous.next = null;
            tail = tail.previous;
        } else {
            head = null;
            tail = null;
        }
    }

    /**
     * Метод разворота двусвязного списка
     */

    public void reverseDoubleList() {
        if (!(head != null || head.next != null)) { // Если список пустой или состоит из одного эл-та
            return;  // Возвращаем список
        }  // Иначе
        Node currentNode  = head; // Принимаем как голову значение текущей ноды
        Node previous = null;  // Предыдущую ноду отсылаем на null

        while (currentNode != null) { // Пока в списке эл-ты имеют значения не null, т.е. не дошли до крайнего
            Node next = currentNode.next; // Значению следующей ноды присвоить значение текущей ссылки
            currentNode.next = previous; // Значению текущей ссылки присвоить значение предыдущей ноды
            previous = currentNode;  // Значению предыдущей ноды присвоить значение текущей
            currentNode = next; // Текущую ноду объявить следующей
        }
        head = previous; // Последнее значение объявить головй
    }
}