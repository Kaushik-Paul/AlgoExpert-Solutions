package io.algoexpert.medium;

public class LongestPeak {

    public static int longestPeak(int[] array) {
        int longestPeakLength = 0;
        int currentPeakLength;
        int leftIndex;
        int rightIndex;
        int i = 1;
        while (i < array.length - 1) {
            if (array[i] > array[i - 1] && array[i] > array[i + 1]) {
                leftIndex = i - 1;
                while (array[leftIndex] > array[leftIndex - 1]) {
                    leftIndex--;
                }
                rightIndex = i + 1;
                while (array[rightIndex] > array[rightIndex + 1]) {
                    rightIndex++;
                }
                currentPeakLength = rightIndex - leftIndex + 1;
                longestPeakLength = Math.max(longestPeakLength, currentPeakLength);
                i = rightIndex + 1;
            } else {
                i++;
            }
        }
        return longestPeakLength;
    }

    public static void main(String[] args) {
        int[] array = new int[]{1, 2, 3, 3, 4, 0, 10, 6, 5, -1, -3, 2, 3};
        System.out.println("The Longest Peak of the current array is : " + longestPeak(array));
    }

}
