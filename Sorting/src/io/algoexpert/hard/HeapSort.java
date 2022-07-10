package io.algoexpert.hard;

public class HeapSort {

    public void heapSort(int[] array) {
        maxHeap(array);
        for (int i = array.length - 1; i >= 1; i--) {
            swap(array, 0, i);
            shiftDown(array, 0, i - 1);
        }
    }

    private void maxHeap(int[] array) {
        int firstParentIdx = ((array.length) - 2) / 2;
        for (int currentIdx = firstParentIdx; currentIdx >= 0; currentIdx--) {
            shiftDown(array, currentIdx, array.length - 1);
        }
    }

    private void shiftDown(int[] array, int currentIdx, int endIdx) {
        int childOne = currentIdx * 2 + 1;
        int childTwo;
        int valueToSwap;
        while (childOne <= endIdx) {
            childTwo = currentIdx * 2 + 2;
            if (childTwo <= endIdx && array[childTwo] > array[childOne]) {
                valueToSwap = childTwo;
            }else {
                valueToSwap = childOne;
            }
            if (array[valueToSwap] > array[currentIdx]) {
                swap(array, currentIdx, valueToSwap);
                currentIdx = valueToSwap;
                childOne = currentIdx * 2 + 1;
            } else {
                return;
            }
        }
    }

    private void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void main(String[] args) {
        int[] array = new int[]{8, 5, 2, 9, 5, 6, 3};
        HeapSort heap = new HeapSort();
        heap.heapSort(array);
        System.out.println("Sorted array after heap sort : ");
        for (int arr : array) {
            System.out.print(arr + " , ");
        }
    }
}
