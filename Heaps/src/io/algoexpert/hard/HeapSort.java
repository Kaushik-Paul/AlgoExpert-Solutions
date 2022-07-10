package io.algoexpert.hard;

public class HeapSort {

    public void heapSort(int[] array) {
        buildMaxHeap(array);
        for (int currentIdx = array.length - 1; currentIdx >= 1; currentIdx--) {
            swap(0, currentIdx, array);
            shiftDown(0, currentIdx - 1, array);
        }
    }

    private void buildMaxHeap(int[] array) {
        int firstParentIdx = (array.length - 2) / 2;
        for (int currentIdx = firstParentIdx; currentIdx >= 0; currentIdx--) {
            shiftDown(currentIdx, array.length - 1, array);
        }
    }

    private void shiftDown(int currentIdx, int endIdx, int[] array) {
        int childOne = currentIdx * 2 + 1;
        int valueToSwap;
        while (childOne <= endIdx) {
            int childTwo = currentIdx * 2 + 2;
            if (childTwo <= endIdx && array[childTwo] > array[childOne]) {
                valueToSwap = childTwo;
            } else {
                valueToSwap = childOne;
            }
            if (array[valueToSwap] > array[currentIdx]) {
                swap(valueToSwap, currentIdx, array);
            }
            currentIdx = childOne;
            childOne = currentIdx * 2 + 1;
        }
    }

    private void swap(int left, int right, int[] array) {
        int temp = array[left];
        array[left] = array[right];
        array[right] = temp;
    }

    public static void main(String[] args) {
        HeapSort sort = new HeapSort();
        int[] array = new int[]{8, 5, 9, 5, 2, 4, 7};
        sort.heapSort(array);
        for (int arr : array) {
            System.out.print(arr + " , ");
        }
    }
}
