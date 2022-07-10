package io.algoexpert.hard;

import java.util.NoSuchElementException;

public class QuickSelect {

    public static void quickSelect(int[] array, int pos) {
        int num = quickSelectHelper(array, 0, array.length - 1, pos - 1);
        System.out.println("The " + pos + "th smallest element in the array is : " + num);
    }

    private static int quickSelectHelper(int[] array, int startIdx, int endIdx, int pos) {
        while (startIdx <= endIdx) {
            int pivotIdx = startIdx;
            int leftIdx = startIdx + 1;
            int rightIdx = endIdx;
            while (leftIdx <= rightIdx) {
                if (array[leftIdx] > array[pivotIdx] && array[rightIdx] < array[pivotIdx]) {
                    swap(leftIdx, rightIdx, array);
                }
                if (array[leftIdx] <= array[pivotIdx]) {
                    leftIdx++;
                }
                if (array[rightIdx] >= array[pivotIdx]) {
                    rightIdx--;
                }
            }
            swap(pivotIdx, rightIdx, array);
            if (rightIdx == pos) {
                return array[rightIdx];
            } else if (pos < rightIdx) {
                endIdx = rightIdx - 1;
            } else {
                startIdx = rightIdx + 1;
            }
        }
        throw new NoSuchElementException("There is something wrong in the algorithm");
    }

    private static void swap(int leftIdx, int rightIdx, int[] array) {
        int temp = array[leftIdx];
        array[leftIdx] = array[rightIdx];
        array[rightIdx] = temp;
    }

    public static void main(String[] args) {
        int[] array = new int[]{8, 5, 2, 9, 7, 6, 3};
        quickSelect(array, 3);
    }

}
