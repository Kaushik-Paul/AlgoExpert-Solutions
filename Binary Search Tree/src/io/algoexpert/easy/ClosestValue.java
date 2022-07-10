package io.algoexpert.easy;

import io.algoexpert.Node;

public class ClosestValue {
    Node root;

    public ClosestValue() {
        root = null;
    }

    public void insert(int new_data) {
        root = insertData(root, new_data);
    }

    private Node insertData(Node root, int new_data) {
        if (root == null) {
            root = new Node(new_data);
            return root;
        }
        if (new_data < root.data) {
            root.left = insertData(root.left, new_data);
        } else {
            root.right = insertData(root.right, new_data);
        }
        return root;
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

    //Helper function
    public void closestValue(int target) {
        System.out.println("The Closest Value to the " + target + " is : " + closestValueCalculate(root, target, Integer.MAX_VALUE));
    }

    //Using the Recursion Method
    private int closestValueCalculate(Node root, int target, int closest) {
        if (root == null) {
            return closest;
        }
        if (Math.abs(closest - target) > Math.abs(target - root.data)) {
            closest = root.data;
        }
        if (target < root.data) {
            closest = closestValueCalculate(root.left, target, closest);
        } else if (target > root.data) {
            closest = closestValueCalculate(root.right, target, closest);
        } else {
            return closest;
        }
        return closest;
    }

    //Using the Iteration Method
    public void closestValueIteration(int target) {
        Node currentNode = root;
        int closest = Integer.MAX_VALUE;
        while (currentNode != null) {
            if (Math.abs(closest - target) > Math.abs(target - currentNode.data)) {
                closest = currentNode.data;
            }
            if (target < currentNode.data) {
                currentNode = currentNode.left;
            } else if (target > currentNode.data) {
                currentNode = currentNode.right;
            } else {
                break;
            }
        }
        System.out.println("The Closest Value to the " + target + " is : " + closest);
    }

    public static void main(String[] args) {
        ClosestValue closestValue = new ClosestValue();
        closestValue.insert(10);
        closestValue.insert(5);
        closestValue.insert(15);
        closestValue.insert(2);
        closestValue.insert(5);
        closestValue.insert(13);
        closestValue.insert(22);
        closestValue.insert(1);
        closestValue.insert(14);
        closestValue.traversal();
        System.out.println();
        closestValue.closestValue(12);
        closestValue.closestValueIteration(12);

    }

}
