package io.algoexpert.medium;

public class MaxSubsetNumNoAdjacent {

    // O(N) time  O(N) space
    public static int maxNum1(int[] array) {
        if (array.length == 1) {
            return array[0];
        }
        int[] maxSubset = array;
        maxSubset[1] = Math.max(maxSubset[0], array[1]);
        for (int i = 2; i < array.length; i++) {
            maxSubset[i] = Math.max(maxSubset[i - 1], maxSubset[i - 2] + array[i]);
        }
        return maxSubset[maxSubset.length - 1];
    }

    // O(N) time  O(1) space
    public static int maxNum(int[] array) {
        if (array.length == 1) {
            return array[0];
        }
        int second=array[0];
        int first = Math.max(second, array[1]);
        int current;
        for (int i = 2; i < array.length; i++) {
            current = Math.max(first, second + array[i]);
            second = first;
            first = current;
        }
        return first;
    }

    public static void main(String[] args) {
        int[] array = new int[]{7, 10, 12, 7, 9, 14};
        System.out.println("The max Sum of subset using 1st method is : " + maxNum(array));
        System.out.println("The max Sum of subset using 2nd method is : " + maxNum1(array));

    }

}
