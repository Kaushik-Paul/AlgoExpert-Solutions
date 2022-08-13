package io.algoexpert.easy;

import java.util.Arrays;

public class MinimumWaitingTime {

    public static int minimumWaitingTime(int[] array) {
        if (array.length == 1) {
            return array[0];
        }

        Arrays.sort(array);

        int duration = 0;
        int totalWaitingTime = 0;
        for (int i = 1; i < array.length; i++) {
            duration += array[i - 1];
            totalWaitingTime += duration;
        }
        return totalWaitingTime;
    }

    public static void main(String[] args) {
        int[] array = new int[]{3, 2, 1, 2, 6};
        System.out.println("The Minimum Waiting Time is: " + minimumWaitingTime(array));
    }
}
