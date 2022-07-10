package io.algoexpert.medium;

import io.algoexpert.Node;

public class BSTConstructionRecursion {

    private Node root;

    public BSTConstructionRecursion() {
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

    public void searchKey(int key) {
        Node node = searchNode(root, key);
        if (node == null) {
            System.out.println("The element " + key + " is not present in the BST");
        } else if (node.data == key) {
            System.out.println("The element " + key + " is present in the BST");
        }
    }

    private Node searchNode(Node root, int key) {
        if (root == null || root.data == key) {
            return root;
        }
        if (key < root.data) {
            return searchNode(root.left, key);
        }
        return searchNode(root.right, key);
    }

    public void deletion(int key) {
        root = deleteNode(root, key);
    }

    private Node deleteNode(Node root, int key) {
        if (root == null) {
            return root;
        }
        if (key < root.data) {
            root.left = deleteNode(root.left, key);
        } else if (key > root.data) {
            root.right = deleteNode(root.right, key);
        } else {
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            } else {
                root.data = getMinValue(root.right);
                root.right = deleteNode(root.right, root.data);
            }
        }
        return root;
    }

    public int getMinValue(Node node) {
        while (node.left != null) {
            node = node.left;
        }
        return node.data;
    }

    public void inOrderTraversal() {
        inOrderTraversalNode(root);
        System.out.print("NULL");
        System.out.println();
    }

    private void inOrderTraversalNode(Node root) {
        if (root == null) {
            return;
        }
        inOrderTraversalNode(root.left);
        System.out.print(root.data + " -> ");
        inOrderTraversalNode(root.right);
    }

    public static void main(String[] args) {
        BSTConstructionRecursion bst = new BSTConstructionRecursion();
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
        bst.searchKey(22);
        bst.searchKey(23);
//        bst.deletion(5);
        bst.deletion(10);
        bst.inOrderTraversal();
    }

}
