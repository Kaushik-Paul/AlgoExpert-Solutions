package io.algoexpert.medium;

public class FirstDuplicateValue {

    // constraints values would be 1 ... n, can mutate array
    // O(n) time and O(1) space
    public static int firstDuplicateValue(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int valueIndex = Math.abs(array[i]) - 1;
            if (array[valueIndex] < 0) {
                return Math.abs(array[i]);
            } else {
                array[valueIndex] *= -1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] array = new int[]{2, 1, 5, 2, 3, 3, 4};
        System.out.println("The First Duplicate Value is: " + firstDuplicateValue(array));
    }
}
