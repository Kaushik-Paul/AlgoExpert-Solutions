package io.algoexpert.hard;

import java.util.Arrays;

public class RadixSort {

    // O(d * (n + b)) time and O(n + b) space
    // d -> digit of the largest number
    // n -> size of array
    // b -> size of digits (0 - 9)
    public static void radixSort(int[] array) {
        if (array.length <= 1) {
            return;
        }
        int maxNumber = Arrays.stream(array).max().getAsInt();

        int digit = 0;
        while (maxNumber / Math.pow(10, digit) > 0) {
            countingSort(array, digit);
            digit++;
        }
    }

    private static void countingSort(int[] array, int digit) {
        int[] countingArray = new int[10];
        int[] sortedArray = new int[array.length];
        Arrays.fill(countingArray, 0);
        Arrays.fill(sortedArray, 0);

        int digitColumn = (int) Math.pow(10, digit);
        // Add the digit of occurrence to counting array
        for (int num : array) {
            int countIndex = (num / digitColumn) % 10;
            countingArray[countIndex]++;
        }
        // Add all the values of counting array
        for (int i = 1; i < countingArray.length; i++) {
            countingArray[i] = countingArray[i] + countingArray[i - 1];
        }

        // traverse from backwards to insert to sorted array
        for (int i = sortedArray.length - 1; i >= 0; i--) {
            int countIndex = (array[i] / digitColumn) % 10;
            int sortedIndex = --countingArray[countIndex];
            sortedArray[sortedIndex] = array[i];
        }

        // copy the value to original array
        System.arraycopy(sortedArray, 0, array, 0, array.length);

    }

    public static void main(String[] args) {
        int[] array = new int[]{8762, 654, 3008, 345, 87, 65, 234, 12, 2};
        radixSort(array);
        System.out.println("The Sorted Array is: " + Arrays.toString(array));
    }
}
