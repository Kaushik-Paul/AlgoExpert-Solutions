package io.algoexpert.hard;

public class KnapsackProblem {

    public static int[][] knapsackProblem(int[][] items, int capacity) {
        int[][] knapsackValues = new int[items.length + 1][capacity + 1];
        for (int i = 0; i < knapsackValues[0].length; i++) {
            knapsackValues[0][i] = 0;
        }
        for (int i = 1; i < knapsackValues.length; i++) {
            int currentValues = items[i - 1][0];
            int currentWeight = items[i - 1][1];
            for (int j = 0; j < knapsackValues[0].length; j++) {
                if (j < currentWeight) {
                    knapsackValues[i][j] = knapsackValues[i - 1][j];
                } else {
                    knapsackValues[i][j] = Math.max(knapsackValues[i - 1][j],
                            knapsackValues[i - 1][j - currentWeight] + currentValues);
                }
            }
        }
        return knapsackItems(knapsackValues, items);
    }

    private static int[][] knapsackItems(int[][] knapsackValues, int[][] items) {
        int[][] requiredItems = new int[items.length][items[0].length];
        int i = knapsackValues.length - 1;
        int j = knapsackValues[0].length - 1;
        int c = 0;
        while (i > 0) {
            if (knapsackValues[i][j] == knapsackValues[i - 1][j]) {
                i--;
            } else {
                requiredItems[c][0] = items[i - 1][0];
                requiredItems[c++][1] = items[i - 1][1];
                i--;
                j -= items[i][1];
            }
            if (j == 0) {
                break;
            }
        }
        return requiredItems;
    }

    public static void main(String[] args) {
        int[][] items = new int[][]{
                {1, 2},
                {4, 3},
                {5, 6},
                {6, 7}
        };
        int[][] requiredItems = knapsackProblem(items, 10);
        System.out.println("The Items are : ");
        for (int i = 0; i < requiredItems.length; i++) {
            System.out.println(requiredItems[i][0] + " , " + requiredItems[i][1]);
        }
    }
}
