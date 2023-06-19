package ru.geekbrains;

public class Main {
    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        linkedList.addFirst(1);
        linkedList.addFirst(20);
        linkedList.addFirst(11);
        linkedList.addFirst(34);
        linkedList.addLast(55);
        linkedList.printList();
        linkedList.reverseLinkedList();
        linkedList.printList();
        System.out.println();

        linkedList.nToEndLinkedList(3);
        System.out.println();

        DoubleList doubleList = new DoubleList();
        doubleList.addFirst(15);
       doubleList.addFirst(20);
        doubleList.addFirst(120);
        doubleList.addLast(3);
        doubleList.addLast(213);
        doubleList.addLast(54);
        doubleList.printList();
        doubleList.reverseDoubleList();
        doubleList.printList();
    }
}