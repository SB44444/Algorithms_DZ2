package ru.geekbrains;

public class LinkedList {
    Node head;

    public class Node {
        int value;
        Node next;

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
        } else {
            node.next = head;
            head = node;
        }
    }

    public void remove() {
        if (head != null) {
            head = head.next;
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
        if (head == null) {
            head = node;
        } else {
            Node currentNode = head;
            while (currentNode.next != null) {
                currentNode = currentNode.next;
            }
            currentNode.next = node;
        }
    }

    public void removeLast() {
        if (head != null) {
            Node currentNode = head;
            if (currentNode.next == null) {
                head = null;
            }
            while (currentNode.next != null) {
                if (currentNode.next.next == null) {
                    currentNode.next = null;
                    return;
                }
                currentNode = currentNode.next;
            }
        }
    }
    /**
     * Метод разворота односвязного списка
     */
    public void reverseLinkedList() {
        if (!(head != null || head.next != null)) { // Если список пустой или состоит из одного эл-та
            return;  // Возвращаем список
        }  // Иначе
        LinkedList.Node currentNode  = head; // Принимаем как голову значение текущей ноды
        LinkedList.Node previous = null;  // Предыдущую ноду отсылаем на null

        while (currentNode != null) { // Пока в списке эл-ты имеют значения не null, т.е. не дошли до крайнего
            LinkedList.Node next = currentNode.next; // Значению следующей ноды присвоить значение текущей ссылки
            currentNode.next = previous; // Значению текущей ссылки присвоить значение предыдущей ноды
            previous = currentNode;  // Значению предыдущей ноды присвоить значение текущей
            currentNode = next; // Текущую ноду объявить следующей
        }
        head = previous; // Последнее значение объявить головй
    }

    /**
     * Метод поиска n эл-та от края списка
     */

    public void nToEndLinkedList(int n) {
         if (head == null) {  // Если список пустой
             return; // Выход из программы
        }
        LinkedList.Node firstNode = head; // Принимаем стартовое значение для первой переменной
        LinkedList.Node secondNode = head; // Принимаем стартовое значение для второй переменной

        for (int i = 0; i < n; ++i) {  // Идем второй переменной по списку n раз
            if (firstNode == null) { // Если дошли до края, но не прошли n шагов
                System.out.println("Номер в списке отсутствует"); // Выводим
            }
            secondNode = secondNode.next;  // Перебираем по одному эл-ту
        }
        while (secondNode != null) { // Пока не дошли второй переменной до края
            firstNode = firstNode.next; // Присваиваем каждому эл-ту следующее значение
            secondNode = secondNode.next;
        }
        System.out.println(firstNode); // Выводим значение n эл-та от конца списка Сложность алгоритма О(n)
    }
}
