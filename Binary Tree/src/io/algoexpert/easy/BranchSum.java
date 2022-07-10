package io.algoexpert.easy;

import io.algoexpert.Node;

import java.util.ArrayList;
import java.util.List;

public class BranchSum {
    Node root;

    public BranchSum() {
        root = null;
    }

    public void Traversal() {
        inOrderTraversal(root);
    }

    private void inOrderTraversal(Node root) {
        if (root != null) {
            inOrderTraversal(root.left);
            System.out.print(root.data+" -> ");
            inOrderTraversal(root.right);
        }
    }

    public List<Integer> branchSum() {
        List<Integer> list = new ArrayList<>();
        branchSumCalculate(root, 0, list);
        return list;
    }

    private void branchSumCalculate(Node root, int runningSum, List<Integer> list) {
        if (root == null) {
            return;
        }
        int newRunningSum = runningSum + root.data;
        if (root.left == null && root.right == null) {
            list.add(newRunningSum);
        }
        branchSumCalculate(root.left, newRunningSum, list);
        branchSumCalculate(root.right, newRunningSum, list);
    }

    public static void main(String[] args) {
        BranchSum tree = new BranchSum();
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
        tree.Traversal();
        System.out.println();
        List<Integer> list = new ArrayList<>();
        list= tree.branchSum();
        System.out.println("The Branch Sum of these particular tree is : ");
        for (int i : list) {
            System.out.print(i+" , ");
        }
    }
}
