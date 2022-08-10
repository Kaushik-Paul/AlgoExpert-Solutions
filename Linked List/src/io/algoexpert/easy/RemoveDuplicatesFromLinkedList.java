package io.algoexpert.easy;

import io.algoexpert.medium.RemoveNthNodeFromEnd;

public class RemoveDuplicatesFromLinkedList {

    private Node head;

    private class Node {
        int value;
        Node next;

        public Node(int value) {
            this.value = value;
            next = null;
        }
    }

    public RemoveDuplicatesFromLinkedList() {
        this.head = null;
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

    public void removeDuplicate() {
        Node currentNode = this.head;
        while (currentNode != null) {
            Node nextDistinctNode = currentNode.next;
            while (nextDistinctNode != null && nextDistinctNode.value == currentNode.value) {
                nextDistinctNode = nextDistinctNode.next;
            }
            currentNode.next = nextDistinctNode;
            currentNode = nextDistinctNode;
        }
    }

    public static void main(String[] args) {
        RemoveDuplicatesFromLinkedList lst = new RemoveDuplicatesFromLinkedList();
        lst.insertion(1);
        lst.insertion(1);
        lst.insertion(3);
        lst.insertion(4);
        lst.insertion(4);
        lst.insertion(4);
        lst.insertion(5);
        lst.insertion(6);
        lst.insertion(6);
        lst.traversal();
        lst.removeDuplicate();
        lst.traversal();
    }
}
