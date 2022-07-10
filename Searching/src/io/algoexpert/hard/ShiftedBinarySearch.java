package io.algoexpert.hard;

public class ShiftedBinarySearch {

    public static int shiftedBinarySearch(int[] array, int target) {
        int left = 0;
        int right = array.length - 1;
        while (left <= right) {
            int middle = (left + right) / 2;
            if (array[middle] == target) {
                return middle;
            } else if (array[left] <= array[middle]) {
                if (target < array[middle] && target >= array[left]) {
                    right = middle - 1;
                } else {
                    left = middle + 1;
                }
            } else {
                if (target > array[middle] && target <= array[right]) {
                    left = middle + 1;
                } else {
                    right = middle - 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] array = new int[]{45, 61, 71, 72, 73, 0, 1, 21, 33, 45};
        int index = shiftedBinarySearch(array, 33);
        if (index == -1) {
            System.out.println("Number is not present");
        } else {
            System.out.println("The number is present is present at : " + index);
        }
    }
}
