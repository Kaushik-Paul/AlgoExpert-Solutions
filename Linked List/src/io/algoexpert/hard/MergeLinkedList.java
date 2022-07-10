package io.algoexpert.hard;

public class MergeLinkedList {
    Node headOne;

    private class Node {
        int value;
        Node next;

        public Node(int value) {
            this.value = value;
            next = null;
        }
    }

    public MergeLinkedList() {
        headOne = null;
    }

    public void insertion(int newValue) {
        Node newNode = new Node(newValue);
        if (headOne == null) {
            headOne = newNode;
            return;
        }
        Node temp = headOne;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
    }

    public void traversal() {
        Node temp = headOne;
        while (temp != null) {
            System.out.print(temp.value + " -> ");
            temp = temp.next;
        }
        System.out.print("NULL");
        System.out.println();
    }

    public void mergeLinkedList(Node headTwo) {
        Node prev = null;
        Node p1 = headOne;
        Node p2 = headTwo;
        while (p1 != null && p2 != null) {
            if (p1.value <= p2.value) {
                prev = p1;
                p1 = p1.next;
            } else {
                if (prev != null) {
                    prev.next = p2;
                }
                prev = p2;
                p2 = p2.next;
                prev.next = p1;
            }
        }
        if (p1 == null) {
            prev.next = p2;
        }
        if (headOne.value > headTwo.value) {
            headOne = headTwo;
        }

    }

    public static void main(String[] args) {
        MergeLinkedList list1 = new MergeLinkedList();
        list1.insertion(2);
        list1.insertion(6);
        list1.insertion(7);
        list1.insertion(8);
        System.out.println("The Linked List 1 is consist of : ");
        list1.traversal();
        MergeLinkedList list2 = new MergeLinkedList();
        list2.insertion(1);
        list2.insertion(3);
        list2.insertion(4);
        list2.insertion(5);
        list2.insertion(9);
        list2.insertion(10);
        System.out.println("The Linked List 2 is consist of : ");
        list2.traversal();
        list1.mergeLinkedList(list2.headOne);
        System.out.println("After merging linked list 1 with linked list 2 we get : ");
        list1.traversal();
    }
}
