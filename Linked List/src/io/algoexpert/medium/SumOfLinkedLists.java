package io.algoexpert.medium;

public class SumOfLinkedLists {

    private Node head;

    private static class Node {
        int value;
        Node next;

        public Node(int value) {
            this.value = value;
            this.next = null;
        }
    }

    public SumOfLinkedLists() {
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
            System.out.print(temp.value + " --> ");
            temp = temp.next;
        }
        System.out.println("NULL");
    }

    public void addLinkedList(Node head1, Node head2) {
        if (head1 == null) {
            head = head2;
            return;
        }
        if (head2 == null) {
            head = head1;
            return;
        }
        int carry = 0;
        Node temp1 = head1, temp2 = head2;
        while (temp1 != null && temp2 != null) {
            int value = temp1.value + temp2.value + carry;
            insertion(value % 10);
            carry = value / 10;
            temp1 = temp1.next;
            temp2 = temp2.next;
        }
        while (temp1 != null) {
            int value = temp1.value + carry;
            insertion(value % 10);
            carry = value / 10;
            temp1 = temp1.next;
        }
        while (temp2 != null) {
            int value = temp2.value + carry;
            insertion(value % 10);
            carry = value / 10;
            temp2 = temp2.next;
        }
    }

    public static void main(String[] args) {
        SumOfLinkedLists ll1 = new SumOfLinkedLists();
        ll1.insertion(2);
        ll1.insertion(4);
        ll1.insertion(7);
        ll1.insertion(1);
        ll1.traversal();
        SumOfLinkedLists ll2 = new SumOfLinkedLists();
        ll2.insertion(9);
        ll2.insertion(4);
        ll2.insertion(5);
        ll2.traversal();
        SumOfLinkedLists sumOfLinkedLists = new SumOfLinkedLists();
        sumOfLinkedLists.addLinkedList(ll1.head, ll2.head);
        sumOfLinkedLists.traversal();
    }
}
