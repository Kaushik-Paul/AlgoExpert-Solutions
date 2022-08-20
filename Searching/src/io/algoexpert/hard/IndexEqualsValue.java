package io.algoexpert.hard;

public class IndexEqualsValue {

    // O(log(n)) time and O(1) space
    public static int indexEqualsValue(int[] array) {
        int left = 0;
        int right = array.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (array[mid] < mid) {
                left = mid + 1;
            } else if (array[mid] > mid) {
                right = mid - 1;
            } else {
                if (mid == 0 || mid - 1 > array[mid - 1]) {
                    return mid;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] array = new int[]{-5, -3, 0, 3, 4, 5, 9};
        int[] array2 = new int[]{-5, -3, 2, 3, 4, 5, 9};
        System.out.println("The Index Equals Value is: " + indexEqualsValue(array2));
    }
}
