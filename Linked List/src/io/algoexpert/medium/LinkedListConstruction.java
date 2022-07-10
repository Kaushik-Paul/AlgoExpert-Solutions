package io.algoexpert.medium;

// This is a Extensive Doubly Linked list implementation

public class LinkedListConstruction {
    private Node head;
    private Node tail;

    private class Node {
        int value;
        Node previous;
        Node next;

        public Node(int value) {
            this.value = value;
            previous = null;
            next = null;
        }
    }

    public LinkedListConstruction() {
        head = null;
        tail = null;
    }

    public Node returnNodeOfValue(int value) {
        Node temp = head;
        while (temp != null && temp.value != value) {
            temp = temp.next;
        }
        if (temp == null) {
            return null;
        }
        return temp;
    }

    public void insertion(int newValue) {
        Node newNode = new Node(newValue);
        if (head == null) {
            head = newNode;
            tail = newNode;
            return;
        }
        newNode.previous = tail;    // One single fucking line and everything fucked up.
        tail.next = newNode;
        tail = newNode;
    }

    public void insertBefore(int insertBefore, int new_value) {
        Node afterNode = returnNodeOfValue(insertBefore);
        if (afterNode == null) {
            System.out.println("Invalid value");
            return;
        }
        Node new_node = new Node(new_value);
        addNodeBindings(afterNode, new_node);
        if (afterNode == head) {
            head = new_node;
        }
    }

    public void insertAfter(int insertAfter, int newValue) {
        Node beforeNode = returnNodeOfValue(insertAfter);
        if (beforeNode == null) {
            System.out.println("Invalid value");
            return;
        }
        if (beforeNode.next != null) {
            Node newNode = new Node(newValue);
            addNodeBindings(beforeNode.next, newNode);
        } else {
            insertion(newValue);
        }
    }

    private void addNodeBindings(Node afterNode, Node newNode) {
        newNode.next = afterNode;
        newNode.previous = afterNode.previous;
        if (afterNode.previous != null) {
            afterNode.previous.next = newNode;
        }
        afterNode.previous = newNode;
    }

    public void remove(int value) {
        Node nodeToRemove = returnNodeOfValue(value);
        if (nodeToRemove == null) {
            System.out.println("Invalid value!!!!");
            return;
        }
        if (head == null) {
            System.out.println("Linked list is empty!!!!");
            return;
        }
        removeNodeBindings(nodeToRemove);
    }

    private void removeNodeBindings(Node node) {
        if (node == head) {
            head = head.next;
        }
        if (node == tail) {
            tail = tail.previous;
        }
        if (node.previous != null) {
            node.previous.next = node.next;
        }
        if (node.next != null) {
            node.next.previous = node.previous;
        }

        // Garbage Collection
        node.previous = null;
        node.next = null;
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
        LinkedListConstruction lst = new LinkedListConstruction();
        lst.insertion(10);
        lst.insertion(20);
        lst.insertion(30);
        lst.insertion(40);
        lst.insertion(50);
        lst.traversal();
        lst.insertBefore(20, 60);
        lst.traversal();
        lst.insertAfter(40, 70);
        lst.traversal();
        lst.remove(20);
        lst.traversal();
        lst.insertBefore(10, 100);
        lst.traversal();
        lst.insertAfter(50, 110);
        lst.traversal();
    }
}
