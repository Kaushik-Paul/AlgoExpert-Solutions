package io.algoexpert.easy;

public class BubbleSort {
    public static void sort(int[] array) {
        int temp;
        boolean isSorted;
        for (int i = 0; i < array.length - 1; i++) {
            isSorted = true;
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    isSorted = false;
                    temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
            if (isSorted) {
                break;
            }
        }
    }

    public static void main(String[] args) {
        int[] array = new int[]{8, 5, 2, 9, 5, 6, 3};
        int[] arr = new int[]{3, 6, 9, 10, 11, 45, 88};
        sort(array);
        System.out.print("The sorted array is : ");
        for (int i : array) {
            System.out.print(i+" , ");
        }
    }
}
