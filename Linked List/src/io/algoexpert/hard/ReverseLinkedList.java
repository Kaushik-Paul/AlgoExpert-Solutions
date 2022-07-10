package io.algoexpert.hard;

public class ReverseLinkedList {
    Node head;

    private class Node {
        int value;
        Node next;

        public Node(int value) {
            this.value = value;
            next = null;
        }
    }

    public ReverseLinkedList() {
        head = null;
    }

    public void insertion(int newValue) {
        Node newNode = new Node(newValue);
        if (head == null) {
            head = newNode;
            return;
        }
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
    }

    public void traversal() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.value + " -> ");
            temp = temp.next;
        }
        System.out.print("NULL");
        System.out.println();
    }

    public void reverseLinkedList() {
        Node previous = null;
        Node present = head;
        Node next;
        while (present != null) {
            next = present.next;
            present.next = previous;
            previous = present;
            present = next;
        }
        head = previous;
    }

    public static void main(String[] args) {
        ReverseLinkedList linkedList = new ReverseLinkedList();
        linkedList.insertion(0);
        linkedList.insertion(1);
        linkedList.insertion(2);
        linkedList.insertion(3);
        linkedList.insertion(4);
        linkedList.insertion(5);
        System.out.println("Before Reverse of the linked list : ");
        linkedList.traversal();
        linkedList.reverseLinkedList();
        System.out.println("After reverse of the linked list : ");
        linkedList.traversal();
    }

}
