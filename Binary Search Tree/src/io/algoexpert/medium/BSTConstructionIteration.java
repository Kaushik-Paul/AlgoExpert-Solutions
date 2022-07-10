package io.algoexpert.medium;

import io.algoexpert.Node;

public class BSTConstructionIteration {
    Node root;

    public BSTConstructionIteration() {
        root = null;
    }

    public void insertion(int key) {
        if (root == null) {
            root = new Node(key);
            return;
        }
        Node currentNode = root;
        while (true) {
            if (key < currentNode.data) {
                if (currentNode.left == null) {
                    currentNode.left = new Node(key);
                    return;
                } else {
                    currentNode = currentNode.left;
                }
            } else {
                if (currentNode.right == null) {
                    currentNode.right = new Node(key);
                    return;
                } else {
                    currentNode = currentNode.right;
                }
            }
        }
    }

    public void searchKey(int key) {
        Node currentNode = root;
        while (currentNode != null) {
            if (key < currentNode.data) {
                currentNode = currentNode.left;
            } else if (key > currentNode.data) {
                currentNode = currentNode.right;
            } else {
                System.out.println("The element is present in the BST");
                return;
            }
        }
        System.out.println("The element is not present in the BST");
    }

    public void deletion(int key) {
        deleteNode(key, root);
    }

    private void deleteNode(int key,Node currentNode) {
        Node parentNode = null;
        while (currentNode != null) {
            if (key < currentNode.data) {
                parentNode = currentNode;
                currentNode = currentNode.left;
            } else if (key > currentNode.data) {
                parentNode = currentNode;
                currentNode = currentNode.right;
            } else {
                if (currentNode.left == null) {
                    parentNode = currentNode.right;
                } else if (currentNode.right == null) {
                    parentNode = currentNode.left;
                } else {
                    root.data = getMaxValue(root.left);
                    deleteNode(root.data, root.left);
                }
                break;
            }
        }
    }

    public int getMaxValue(Node node) {
        while (node.right != null) {
            node = node.right;
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
        BSTConstructionIteration bst = new BSTConstructionIteration();
        bst.insertion(10);
        bst.insertion(5);
        bst.insertion(15);
        bst.insertion(2);
        bst.insertion(5);
        bst.insertion(1);
        bst.insertion(13);
        bst.insertion(22);
        bst.insertion(14);
        bst.insertion(12);
        bst.inOrderTraversal();
        bst.searchKey(22);
        bst.searchKey(23);
        bst.deletion(22);
        bst.inOrderTraversal();
    }

}
