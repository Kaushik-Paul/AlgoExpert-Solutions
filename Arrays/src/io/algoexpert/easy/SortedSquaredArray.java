package io.algoexpert.easy;

import java.util.Arrays;

public class SortedSquaredArray {

    public static int[] sortedSquaredArray(int[] array) {
        int left = 0, right = array.length - 1;
        int[] sortedArray = new int[array.length];
        int sortedIdx = sortedArray.length - 1;
        while (left <= right) {
            if ((Math.abs(array[right])) >= Math.abs(array[left])) {
                sortedArray[sortedIdx] = (int) Math.pow(array[right], 2);
                right--;
                sortedIdx--;
            } else {
                sortedArray[sortedIdx] = (int) Math.pow(array[left], 2);
                left++;
                sortedIdx--;
            }
        }
        return sortedArray;
    }

    public static void main(String[] args) {
        int[] array = new int[]{-7, -5, -4, 3, 6, 8, 9};
        int[] array2 = new int[]{-8, -7, -6, -5, -4, -3, -2};
        int[] array3 = new int[]{2, 5, 8, 9, 10, 23};
        System.out.println("The Squared Sorted Array is: " + Arrays.toString(sortedSquaredArray(array)));
    }
}
