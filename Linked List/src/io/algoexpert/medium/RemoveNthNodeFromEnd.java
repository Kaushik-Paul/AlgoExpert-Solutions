package io.algoexpert.medium;

public class RemoveNthNodeFromEnd {
    Node head;

    private class Node {
        int value;
        Node next;

        public Node(int value) {
            this.value = value;
            next = null;
        }
    }

    public RemoveNthNodeFromEnd() {
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

    public void removeKthFromEnd(int N) {
        int counter = 1;
        Node first = head;
        Node second = head;
        while (second != null && counter <= N) {
            second = second.next;
            counter++;
        }
        if (second == null) {
            head = head.next;
            return;
        }
//        Node prev = first;
//        while (second != null) {
//            prev = first;
//            first = first.next;
//            second = second.next;
//        }
//        prev.next = first.next;
//        first.next = null;

        while (second.next != null) {
            first = first.next;
            second = second.next;
        }
        first.next = first.next.next;
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

    public static void main(String[] args) {
        RemoveNthNodeFromEnd lst = new RemoveNthNodeFromEnd();
        lst.insertion(10);
        lst.insertion(20);
        lst.insertion(30);
        lst.insertion(40);
        lst.insertion(50);
        lst.insertion(60);
        lst.insertion(70);
        lst.insertion(80);
        lst.insertion(90);
        lst.insertion(100);
        lst.traversal();
        lst.removeKthFromEnd(4);
        lst.traversal();
        lst.removeKthFromEnd(9);
        lst.traversal();
    }
}
