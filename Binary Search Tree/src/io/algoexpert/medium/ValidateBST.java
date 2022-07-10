package io.algoexpert.medium;

import io.algoexpert.Node;

public class ValidateBST {
    Node root;

    public ValidateBST() {
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

    public boolean validateBst() {
        return validateBstHelper(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean validateBstHelper(Node root, int min, int max) {
        if (root == null) {
            return true;
        }
        if (root.data < min || root.data >= max) {
            return false;
        }
        return validateBstHelper(root.left, min, root.data) && validateBstHelper(root.right, root.data, max);
    }

    public static void main(String[] args) {
        ValidateBST bst = new ValidateBST();
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
        bst.insertion(13);
        System.out.println(bst.validateBst());
    }

}
