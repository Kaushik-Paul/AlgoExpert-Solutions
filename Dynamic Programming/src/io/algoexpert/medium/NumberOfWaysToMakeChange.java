package io.algoexpert.medium;

import java.util.Arrays;

public class NumberOfWaysToMakeChange {

    public static int numberOfWays(int n, int[] denoms) {
        int[] ways = new int[n + 1];
        Arrays.fill(ways, 0);
        ways[0] = 1;     //Very Important to Remember
        for (int denom : denoms) {
            for (int amount = 1; amount <= n; amount++) {
                if (denom <= amount) {
                    ways[amount] += ways[amount - denom];
                }
            }
        }
        return ways[n];
    }

    public static void main(String[] args) {
        int[] denoms = new int[]{1, 5, 10, 25};
        int amount = 10;
        System.out.println("Total number of ways to make the change is : " + numberOfWays(amount, denoms));
    }
}
