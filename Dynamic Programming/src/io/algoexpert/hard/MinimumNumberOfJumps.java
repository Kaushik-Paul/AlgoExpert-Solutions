package io.algoexpert.hard;

public class MinimumNumberOfJumps {

    public static int minimumNumberOfJumps(int[] array) {
        if (array.length == 1) {
            return 0;
        }
        int maxReach = array[0];
        int steps = array[0];
        int jumps = 0;
        for (int i = 1; i < array.length; i++) {
            maxReach = Math.max(maxReach, array[i] + i);
            steps--;
            if (steps == 0) {
                jumps++;
                steps = maxReach - i;
            }
        }
        return jumps + 1;
    }

    public static void main(String[] args) {
        int[] array = new int[]{3, 4, 2, 1, 2, 3, 7, 1, 1, 1, 3};
        System.out.println("The Minimum Amount of jumps required to reach the end of the array : "
                + minimumNumberOfJumps(array));
    }
}
