package io.algoexpert.medium;

import io.algoexpert.Node;

public class MinHeightBST {
    Node root;

    public MinHeightBST() {
        root = null;
    }

    public void minHeightBst(int[] array) {
        root = minHeightBstConstruction(root, array, 0, array.length - 1);
    }

    private Node minHeightBstConstruction(Node root, int[] array, int startInx, int endIdx) {
        if (startInx > endIdx) {
            return null;
        }
        int midIdx = (startInx + endIdx) / 2;
        root = new Node(array[midIdx]);
        root.left = minHeightBstConstruction(root.left, array, startInx, midIdx - 1);
        root.right = minHeightBstConstruction(root.right, array, midIdx + 1, endIdx);
        return root;
    }

    public void inOrderTraversal() {
        inOrderTraversalNode(root);
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

    public void preOrderTraversal() {
        preOrderTraversalNode(root);
        System.out.print("NULL");
        System.out.println();
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

    public static void main(String[] args) {
        MinHeightBST bst = new MinHeightBST();
        int[] array = new int[]{1, 2, 5, 7, 10, 13, 14, 15, 22};
        bst.minHeightBst(array);
        bst.inOrderTraversal();
        bst.preOrderTraversal();
    }

}
