package io.algoexpert.medium;

public class KadanesAlgorithm {

    public static int kadanesAlgorithm(int[] array) {
        int maxEndingHere = Integer.MIN_VALUE;
        int maxSum = Integer.MIN_VALUE;
        for (int num : array) {
            maxEndingHere = Math.max(maxEndingHere + num, num);
            maxSum = Math.max(maxEndingHere, maxSum);
        }
        return maxSum;
    }


    public static void main(String[] args) {
        int[] array = new int[]{3, 5, -9, 1, 3, -2, 3, 4, 7, 2, -9, 6, 3, 1, -5, 4};
        System.out.println("The maximum value of the array is : " + kadanesAlgorithm(array));
    }
}
