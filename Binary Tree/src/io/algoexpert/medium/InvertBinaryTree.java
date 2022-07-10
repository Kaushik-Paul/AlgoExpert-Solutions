package io.algoexpert.medium;

import io.algoexpert.Node;

public class InvertBinaryTree {

    private Node root;

    public InvertBinaryTree() {
        root = null;
    }

    public void invertTree() {
        root = invertTreeNode(root);
    }

    private Node invertTreeNode(Node root) {
        if (root == null) {
            return null;
        }
        swapNode(root);
        invertTreeNode(root.left);
        invertTreeNode(root.right);
        return root;
    }

    private void swapNode(Node root) {
        Node temp = root.left;
        root.left = root.right;
        root.right = temp;
    }

    public void inOrdertraversal() {
        inOrderTraversalNode(root);
        System.out.println("NULL");
        System.out.println();
    }

    private void inOrderTraversalNode(Node root) {
        if (root == null) {
            return;
        }
        inOrderTraversalNode(root.left);
        System.out.print(root.data+" -> ");
        inOrderTraversalNode(root.right);
    }

    public static void main(String[] args) {
        InvertBinaryTree tree = new InvertBinaryTree();
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
        tree.inOrdertraversal();
        tree.invertTree();
        tree.inOrdertraversal();
    }

}
