package io.algoexpert.hard;

import java.util.ArrayList;
import java.util.List;

public class MaxSumIncreasingSubsequence {
    public static void maxSumIncreasingSubsequence(int[] array) {
        int[] sums = new int[array.length];
        int[] sequence = new int[array.length];
        int maxIdx = 0;
        for (int i = 0; i < array.length; i++) {
            sequence[i] = -1;
            sums[i] = array[i];
        }
        for (int i = 0; i < array.length; i++) {
            int currentSum = array[i];
            for (int j = 0; j < i; j++) {
                int otherSum = array[j];
                if (currentSum > otherSum && sums[j] + currentSum > sums[i]) {
                    sums[i] = currentSum + sums[j];
                    sequence[i] = j;
                }
            }
            if (sums[i] > sums[maxIdx]) {
                maxIdx = i;
            }
        }
        int maxSum = sums[maxIdx];
        List<Integer> list = builtSequence(array, maxIdx, sequence);
        System.out.println("The maximum Number of the sequence is : " + maxSum);
        System.out.println("And The Numbers are : " + list);
    }

    private static List<Integer> builtSequence(int[] array, int currentIdx, int[] sequence) {
        List<Integer> list = new ArrayList<>();
        while (currentIdx != -1) {
            list.add(array[currentIdx]);
            currentIdx = sequence[currentIdx];
        }
        return list;
    }

    public static void main(String[] args) {
        int[] array = new int[]{8, 12, 2, 3, 15, 5, 7};
        maxSumIncreasingSubsequence(array);

    }
}

