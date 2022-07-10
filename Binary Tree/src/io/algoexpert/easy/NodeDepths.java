package io.algoexpert.easy;

import io.algoexpert.Node;

public class NodeDepths {
    Node root;

    public NodeDepths() {
        root = null;
    }

    public void traversal() {
        inOrderTraversal(root);
    }

    private void inOrderTraversal(Node root) {
        if (root == null) {
            return;
        }
        inOrderTraversal(root.left);
        System.out.print(root.data+" -> ");
        inOrderTraversal(root.right);
    }

    public void nodeDepth() {
        int sum = calculateNodeDepth(root, 0);
        System.out.println("The Node depth is : " + sum);
    }

    private int calculateNodeDepth(Node root, int d) {
        if (root == null) {
            return 0;
        }
        return d + calculateNodeDepth(root.left, d + 1) + calculateNodeDepth(root.right, d + 1);
    }

    public static void main(String[] args) {
        NodeDepths tree = new NodeDepths();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.right.left = new Node(6);
        tree.root.right.right = new Node(7);
        tree.root.left.left.left = new Node(8);
        tree.root.left.left.right = new Node(9);
        tree.root.left.right.left = new Node(10);
        System.out.println("The tree is ");
        tree.traversal();
        System.out.println();
        tree.nodeDepth();
    }

}
