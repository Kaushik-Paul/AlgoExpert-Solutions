package io.algoexpert.easy;

public class InsertionSort {

    public static void sort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int temp;
            for (int j = i; j >= 1; j--) {
                if (array[j] < array[j - 1]) {
                    temp = array[j];
                    array[j] = array[j - 1];
                    array[j - 1] = temp;
                }
            }
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
