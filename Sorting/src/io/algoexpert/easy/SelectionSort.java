package io.algoexpert.easy;

public class SelectionSort {

    public static void sort(int[] array) {
        int pos;
        int temp;
        for (int i = 0; i < array.length - 1; i++) {
            pos = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[pos] > array[j]) {
                    pos = j;
                }
            }
            temp = array[pos];
            array[pos] = array[i];
            array[i] = temp;
        }
    }

    public static void main(String[] args) {
        int[] array = new int[]{8, 5, 2, 9, 5, 6, 3};
        int[] arr = new int[]{3, 6, 9, 10, 11, 45, 88};
        sort(array);     // Sorting the array
        System.out.print("The sorted array is : ");
        for (int i : array) {
            System.out.print(i + " , ");
        }
    }
}
