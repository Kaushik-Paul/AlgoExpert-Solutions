package io.algoexpert.hard;

import java.util.Arrays;

public class MinRewards {

    public static int minRewardsNaive(int[] array) {
        int[] rewards = new int[array.length];
        Arrays.fill(rewards, 1);
        for (int i = 1; i < array.length; i++) {
            int j = i - 1;
            if (array[i] > array[j]) {
                rewards[i] = rewards[j] + 1;
            } else {
                while (j >= 0 && array[j] > array[j + 1]) {
                    rewards[j] = Math.max(rewards[j], rewards[j + 1] + 1);
                    j--;
                }
            }
        }
        int sum = 0;
        for (int i : rewards) {
            sum += i;
        }
        return sum;
    }

    public static int minRewards(int[] array) {
        int[] rewards = new int[array.length];
        Arrays.fill(rewards, 1);
        for (int i = 1; i < array.length; i++) {
            if (array[i] > array[i - 1]) {
                rewards[i] = rewards[i - 1] + 1;
            }
        }
        for (int i = array.length - 2; i >= 0; i--) {
            if (array[i] > array[i + 1]) {
                rewards[i] = Math.max(rewards[i], rewards[i + 1] + 1);
            }
        }
        int sum = 0;
        for (int i : rewards) {
            sum += i;
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] array = new int[]{8, 4, 2, 1, 3, 6, 7, 9, 5};
        int sum = minRewardsNaive(array);
        System.out.println("The minimum rewards(using Naive solution) for this array is : " + sum);
        sum = minRewards(array);
        System.out.println("The minimum rewards(using optimal solution) for this array is : " + sum);

    }
}
