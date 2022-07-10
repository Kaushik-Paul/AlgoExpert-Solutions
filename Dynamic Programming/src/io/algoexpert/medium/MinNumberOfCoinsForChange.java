package io.algoexpert.medium;

import java.util.Arrays;

public class MinNumberOfCoinsForChange {

    public static int minChange(int n, int[] denoms) {
        int[] noOfCoins = new int[n+1];
        Arrays.fill(noOfCoins, Integer.MAX_VALUE);
        noOfCoins[0] = 0;    //Very Important to Remember
        for (int denom : denoms) {
            for (int amount = 1; amount < n + 1; amount++) {
                if (denom <= amount) {
                    noOfCoins[amount] = Math.min(noOfCoins[amount], 1 + noOfCoins[amount - denom]);
                }
            }
        }
        return noOfCoins[n];
    }

    public static void main(String[] args) {
        int[] denoms = new int[]{1, 2, 4};
        int amount = 6;
        System.out.println("The minimum number of coins needed to make the change is : " + minChange(amount, denoms));
    }

}
