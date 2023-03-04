package brunoyam;

import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        MyLinkedList<Integer> myLinkedList = new MyLinkedList<>();
        myLinkedList.addLast(3);
        myLinkedList.print();
//        myLinkedList.remove(9);
//        System.out.println("after removing: ");
//        myLinkedList.print();
//        System.out.println("size: " + myLinkedList.getSize());
//        System.out.println("reverse list: ");
//        myLinkedList.reverseList();
//        myLinkedList.print();
    }
}

class MyLinkedList<E> {
    private Node<E> head;
    private Node<E> tail;
    private int size;
    private static class Node<E> {
        E item;
        Node<E> next;

        Node(E element, Node<E> next) {
            this.item = element;
            this.next = next;
        }
    }

    public void addLast(E e) {
        Node<E> newNode = new Node<>(e, null);

        if (head == null)
        {
            head = newNode;
        }
        else
        {
            tail.next = newNode;
        }
        tail = newNode;
        size++;
    }

    public void remove(E e) {
        if(head == null) {
            return;
        }

        if(head.item == e) {
            head = head.next;
            return;
        }

        Node<E> currentNode = head;

        while (currentNode.next != null) {
            if (currentNode.next.item.equals(e)) {
                currentNode.next = currentNode.next.next;
                return;
            }
            currentNode = currentNode.next;
        }
        size--;
    }

    public int getSize() {
        return size;
    }

    public void print() {
        Node<E> currentNode = head;
        if (head != null) {
            System.out.println(head.item);

            while (currentNode.next != null) {
                currentNode = currentNode.next;
                System.out.println(currentNode.item);
            }
        }
    }

    public void reverseList() {
        Node<E> prev = null;
        Node<E> current = head;

        while(current != null) {
            Node<E> next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        head = prev;
    }
}



















