package io.algoexpert.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeOverlappingIntervals {

    public static List<int[]> mergeOverlappingIntervals(int[][] array) {
        Arrays.sort(array, (first, second) -> first[0] - second[0]);

        List<int[]> mergedIntervals = new ArrayList<>();
        int[] currentInterval = array[0];
        mergedIntervals.add(currentInterval);

        for (int[] nextInterval : array) {
            int currentIntervalEnd = currentInterval[1];
            int nextIntervalStart = nextInterval[0];
            int nextIntervalEnd = nextInterval[1];
            if (currentIntervalEnd >= nextIntervalStart) {
                currentInterval[1] = Math.max(currentIntervalEnd, nextIntervalEnd);
            } else {
                currentInterval = nextInterval;
                mergedIntervals.add(currentInterval);
            }
        }
        return mergedIntervals;
    }

    public static void main(String[] args) {
        int[][] array = new int[][]{
                {1, 2},
                {3, 5},
                {4, 7},
                {6, 8},
                {9, 10}
        };
        System.out.print("The Merged Intervals are: ");
        mergeOverlappingIntervals(array).forEach(a1 -> System.out.print(Arrays.toString(a1) + " , "));
    }
}
