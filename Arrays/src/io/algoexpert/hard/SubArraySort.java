package io.algoexpert.hard;

public class SubArraySort {

    public static int[] subArraySort(int[] array) {
        int minOutOfOrder = Integer.MAX_VALUE;
        int maxOutOfOrder = Integer.MIN_VALUE;
        for (int i = 0; i < array.length; i++) {
            int num = array[i];
            if (isOutOfOrder(i, array)) {
                minOutOfOrder = Math.min(num, minOutOfOrder);
                maxOutOfOrder = Math.max(num, maxOutOfOrder);
            }
        }
        if (minOutOfOrder == Integer.MAX_VALUE) {
            return new int[]{-1, -1};
        }
        int leftOutOfOrder = 0;
        while (array[leftOutOfOrder] <= minOutOfOrder) {
            leftOutOfOrder++;
        }
        int rightOutOfOrder = array.length - 1;
        while (array[rightOutOfOrder] >= maxOutOfOrder) {
            rightOutOfOrder--;
        }
        return new int[]{leftOutOfOrder, rightOutOfOrder};
    }

    private static boolean isOutOfOrder(int i, int[] array) {
        int num = array[i];
        if (i == 0) {
            return num > array[i + 1];
        }
        if (i == array.length - 1) {
            return num < array[i - 1];
        }
        return num > array[i + 1] || num < array[i - 1];
    }

    public static void main(String[] args) {
        int[] array = new int[]{1, 2, 4, 7, 10, 11, 7, 12, 6, 7, 16, 18, 19};
        int[] index = subArraySort(array);
        System.out.println("The index to which sorting has to be done is : [" + index[0] + " , " + index[1] + "]");
    }
}
