package io.algoexpert.hard;

public class QuickSort {
    public void quickSort(int[] array) {
        quickSortHelper(array, 0, array.length - 1);
    }

    private void quickSortHelper(int[] array, int startIdx, int endIdx) {
        if (endIdx <= startIdx) {
            return;
        }
        int pivotIdx = startIdx;
        int leftIdx = startIdx + 1;
        int rightIdx = endIdx;
        while (leftIdx <= rightIdx) {
            if (array[leftIdx] > array[pivotIdx] && array[rightIdx] < array[pivotIdx]) {
                swap(array, leftIdx, rightIdx);
            }
            if (array[leftIdx] <= array[pivotIdx]) {
                leftIdx++;
            }
            if (array[rightIdx] >= array[pivotIdx]) {
                rightIdx--;
            }
        }
        swap(array, pivotIdx, rightIdx);

        // Optional done to optimise code
        boolean isLeftSubarraySmaller = (rightIdx - 1 - startIdx) < (endIdx - (rightIdx + 1));
        if (isLeftSubarraySmaller) {
            quickSortHelper(array, startIdx, rightIdx - 1);
            quickSortHelper(array, rightIdx + 1, endIdx);
        } else {
            quickSortHelper(array, rightIdx + 1, endIdx);
            quickSortHelper(array, startIdx, rightIdx - 1);
        }
    }

    private void swap(int[] array, int leftIdx, int rightIdx) {
        int temp = array[leftIdx];
        array[leftIdx] = array[rightIdx];
        array[rightIdx] = temp;
    }

    public static void main(String[] args) {
        int[] array = new int[]{8, 5, 2, 9, 5, 6, 3};
        QuickSort sort = new QuickSort();
        sort.quickSort(array);
        System.out.println("After sorting the array : ");
        for (int i : array) {
            System.out.print(i + " , ");
        }
        
    }
}
