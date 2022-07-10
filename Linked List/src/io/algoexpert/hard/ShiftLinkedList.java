package io.algoexpert.hard;

public class ShiftLinkedList {
    Node head;

    private class Node {
        int value;
        Node next;

        public Node(int value) {
            this.value = value;
            next = null;
        }
    }

    public ShiftLinkedList() {
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

    public void shiftLinkedList(int k) {
        Node listTail = head;
        int length = 0;
        while (listTail.next != null) {
            listTail = listTail.next;
            length++;
        }
        int offset = Math.abs(k) % length;
        int newTailPosition = (k > 0) ? length - offset : offset - 1;
        Node newTail = head;
        for (int i = 1; i <= newTailPosition; i++) {
            newTail = newTail.next;
        }
        Node newHead = newTail.next;
        newTail.next = null;
        listTail.next = head;
        head = newHead;
    }

    public static void main(String[] args) {
        ShiftLinkedList list = new ShiftLinkedList();
        list.insertion(0);
        list.insertion(1);
        list.insertion(2);
        list.insertion(3);
        list.insertion(4);
        list.insertion(5);
        System.out.println("Before Shifting the linked List : ");
        list.traversal();
        int k = 2;
        list.shiftLinkedList(k);
        System.out.println("After shifting the linked list by " + k + " positions : ");
        list.traversal();
    }
}
