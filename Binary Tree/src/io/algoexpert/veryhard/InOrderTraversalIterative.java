package io.algoexpert.veryhard;

import io.algoexpert.Node;

import java.util.ArrayList;
import java.util.List;

public class InOrderTraversalIterative {
    private Node root;

    public InOrderTraversalIterative() {
        root = null;
    }

    public List<Integer> traversal() {
        Node currentNode = root;
        List<Integer> list = new ArrayList<>();
        while (currentNode != null) {
            if (currentNode.left == null) {
                list.add(currentNode.data);
                currentNode = currentNode.right;
            } else {
                Node prev = currentNode.left;
                while (prev.right != null) {
                    prev = prev.right;
                }
                prev.right = currentNode;
                Node temp = currentNode;
                currentNode = currentNode.left;
                temp.left = null;
            }
        }
        return list;
    }

    public static void main(String[] args) {
        InOrderTraversalIterative tree = new InOrderTraversalIterative();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.right.left = new Node(6);
        tree.root.right.right = new Node(7);
        tree.root.left.left.right = new Node(9);
        List<Integer> list = tree.traversal();
        list.forEach(st -> System.out.print(st + " -> "));
        System.out.println("NULL");
    }
}
