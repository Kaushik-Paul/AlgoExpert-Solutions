package io.algoexpert.hard;

import io.algoexpert.Node;

public class MaxPathSum {
    private Node root;

    public MaxPathSum() {
        root = null;
    }

    public void maxPathSum() {
        int[] temp = findMaxPath(root);
        System.out.println("The Max Path of this tree is : " + temp[1]);
    }

    private int[] findMaxPath(Node root) {
        if (root == null) {
            return new int[]{0, 0};
        }
        int[] temp1 = findMaxPath(root.left);
        int[] temp2 = findMaxPath(root.right);
        int leftMaxSumAsBranch = temp1[0];
        int leftMaxSum = temp1[1];
        int rightMaxSumAsBranch = temp2[0];
        int rightMaxSum = temp2[1];
        int maxChildSumAsBranch = Math.max(leftMaxSumAsBranch, rightMaxSumAsBranch);
        int value = root.data;
        int maxSumAsBranch = Math.max(maxChildSumAsBranch + value, value);
        int maxSumAsTree = Math.max(maxSumAsBranch, leftMaxSumAsBranch + value + rightMaxSumAsBranch);
        int runningMaxPathSum = Math.max(Math.max(leftMaxSum, rightMaxSum), maxSumAsTree);
        return new int[]{maxSumAsBranch, runningMaxPathSum};
    }

    public static void main(String[] args) {
        MaxPathSum tree = new MaxPathSum();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.right.left = new Node(6);
        tree.root.right.right = new Node(7);
        tree.maxPathSum();

    }
}
