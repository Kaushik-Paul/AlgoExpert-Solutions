package io.algoexpert.medium;

import io.algoexpert.Node;

public class BSTTraversal {
    Node root;

    public BSTTraversal() {
        root = null;
    }
    public void insertion(int key) {
        root = insertNode(root, key);
    }

    private Node insertNode(Node root, int key) {
        if (root == null) {
            return new Node(key);
        }
        if (key < root.data) {
            root.left = insertNode(root.left, key);
        } else if (key >= root.data) {
            root.right = insertNode(root.right, key);
        }
        return root;
    }

    public void inOrderTraversal() {
        inOrderTraversalNode(root);
        System.out.print("NULL");
        System.out.println();
    }

    public void preOrderTraversal() {
        preOrderTraversalNode(root);
        System.out.print("NULL");
        System.out.println();
    }

    public void postOrderTraversal() {
        postOrderTraversalNode(root);
        System.out.print("NULL");
        System.out.println();
    }

    private Node inOrderTraversalNode(Node root) {
        if (root == null) {
            return root;
        }
        inOrderTraversalNode(root.left);
        System.out.print(root.data+" -> ");
        inOrderTraversalNode(root.right);
        return root;
    }

    private Node preOrderTraversalNode(Node root) {
        if (root == null) {
            return root;
        }
        System.out.print(root.data+" -> ");
        preOrderTraversalNode(root.left);
        preOrderTraversalNode(root.right);
        return root;
    }

    private Node postOrderTraversalNode(Node root) {
        if (root == null) {
            return root;
        }
        postOrderTraversalNode(root.left);
        postOrderTraversalNode(root.right);
        System.out.print(root.data + " -> ");
        return root;
    }

    public static void main(String[] args) {
        BSTTraversal bst = new BSTTraversal();
        bst.insertion(10);
        bst.insertion(5);
        bst.insertion(15);
        bst.insertion(2);
        bst.insertion(5);
        bst.insertion(1);
        bst.insertion(12);
        bst.insertion(13);
        bst.insertion(22);
        bst.insertion(14);
        bst.inOrderTraversal();
        bst.preOrderTraversal();
        bst.postOrderTraversal();

    }

}
