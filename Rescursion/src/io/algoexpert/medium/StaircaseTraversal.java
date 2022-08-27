package io.algoexpert.medium;

import java.util.Arrays;

public class StaircaseTraversal {

    // O(k * n) time and O(n) space
    public static int staircaseTraversal(int height, int maxSteps) {
        int[] numberOfWays = new int[height + 1];
        Arrays.fill(numberOfWays, 0);
        numberOfWays[height] = 1;
        numberOfWays[height - 1] = 1;
        for (int i = height - 2; i >= 0; i--) {
            for (int j = 1; j <= maxSteps; j++) {
                if (i + j <= height) {
                    numberOfWays[i] += numberOfWays[i + j];
                }
            }
        }
        return numberOfWays[0];
    }

    public static void main(String[] args) {
        int height = 4;
        int maxSteps = 3;
        System.out.println("The Max number of Steps possible: " + staircaseTraversal(height, maxSteps));
    }
}
