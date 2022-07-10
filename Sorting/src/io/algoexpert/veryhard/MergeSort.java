package io.algoexpert.veryhard;

public class MergeSort {

    private void merge(int[] array, int startIdx, int midIdx, int endIdx) {
        int left = midIdx - startIdx + 1;
        int right = endIdx - midIdx;
        int[] leftArray = new int[left];
        int[] rightArray = new int[right];
        for (int i = 0; i < left; i++) {
            leftArray[i] = array[startIdx + i];
        }
        for (int j = 0; j < right; j++) {
            rightArray[j] = array[midIdx + j + 1];
        }
        int i = 0, j = 0, k = startIdx;
        while (i < left && j < right) {
            if (leftArray[i] <= rightArray[j]) {
                array[k] = leftArray[i];
                i++;
            } else {
                array[k] = rightArray[j];
                j++;
            }
            k++;
        }
        while (i < left) {
            array[k] = leftArray[i];
            i++;
            k++;
        }
        while (j < right) {
            array[k] = rightArray[j];
            j++;
            k++;
        }
    }

    public void sort(int[] array, int startIdx, int endIdx) {
        if (startIdx >= endIdx) {
            return;
        }
        int midIdx = (startIdx + endIdx) / 2;
        sort(array, startIdx, midIdx);
        sort(array, midIdx + 1, endIdx);
        merge(array, startIdx, midIdx, endIdx);
    }

    public static void main(String[] args) {
        MergeSort mergeSort = new MergeSort();
        int[] array = new int[]{8, 5, 2, 9, 5, 6, 3};
        mergeSort.sort(array, 0, array.length - 1);
        System.out.println("The Sorted Array is : ");
        for (int i : array) {
            System.out.print(i + " , ");
        }
    }
}
