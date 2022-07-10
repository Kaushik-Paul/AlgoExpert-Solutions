package io.algoexpert.hard;

public class FindLoop {
    Node head;

    private class Node {
        int value;
        Node next;

        public Node(int value) {
            this.value = value;
            next = null;
        }
    }

    public FindLoop() {
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

    public void findLoop() {
        Node slowPointer = head.next;
        Node fastPointer = head.next.next;
        while (slowPointer != fastPointer) {
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next.next;
        }
        slowPointer = head;
        while (slowPointer != fastPointer) {
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next;
        }
        System.out.println("The loop in the linked list if found on Node : " + slowPointer.value);
    }

    public static void main(String[] args) {
        FindLoop loop = new FindLoop();
        loop.insertion(0);
        loop.insertion(1);
        loop.insertion(2);
        loop.insertion(4);
        loop.insertion(5);
        loop.insertion(6);
        loop.insertion(7);
        loop.insertion(8);
        loop.insertion(9);

//        Trying to add loop in the linked list
        Node temp = loop.head;
        while (temp.next != null) {
            temp = temp.next;
        }
        Node temp2 = loop.head;
        while (temp2.value != 4) {
            temp2 = temp2.next;
        }
        temp.next = temp2;

//        End of implementation

        loop.findLoop();
    }
}
