package io.algoexpert.easy;

public class BinarySearch {

    public static boolean check(int[] array, int target) {
        int left = 0;
        int right = array.length - 1;
        int middle;
        while (left <= right) {
            middle = (left + right) / 2;
            if (array[middle] == target) {
                return true;
            } else if (array[middle] > target) {
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] array = new int[]{0, 1, 21, 33, 45, 45, 61, 71, 72, 73};
        int target = 33;
        if (check(array, target)) {
            System.out.println("Number is present in the array");
        } else {
            System.out.println("NUmber is not present in the array");
        }
    }
}
