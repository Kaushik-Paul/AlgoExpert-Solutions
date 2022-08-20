package io.algoexpert.easy;

import java.util.Arrays;

public class NonConstructibleChange {

    public static int nonConstructibleChange(int[] array) {
        Arrays.sort(array);
        int change = 0;
        for (int coin : array) {
            if (change + 1 >= coin) {
                change += coin;
            } else {
                return change + 1;
            }
        }
        return change + 1;
    }

    public static void main(String[] args) {
        int[] array = new int[]{5, 7, 1, 1, 2, 3, 22};
        System.out.println("The least Non Constructible change is: " + nonConstructibleChange(array));

    }
}
