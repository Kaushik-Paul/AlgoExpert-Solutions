package io.algoexpert.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SmallestDifference {

    public static List<Integer> findDifference(int[] array1, int[] array2) {
        Arrays.sort(array1);
        Arrays.sort(array2);
        List<Integer> s = new ArrayList<>(2);
        int pointer1 = 0;
        int pointer2 = 0;
        int smallest = Integer.MAX_VALUE;
        int currentSum;
        while (pointer1 < array1.length && pointer2 < array2.length) {
            currentSum = Math.abs(array1[pointer1] - array2[pointer2]);
            if (smallest > currentSum) {
                smallest = currentSum;
                s.add(0,array1[pointer1]);
                s.add(1,array2[pointer2]);
            }
            if (array1[pointer1] < array2[pointer2]) {
                pointer1++;
            } else if (array1[pointer1] > array2[pointer2]) {
                pointer2++;
            } else {
                break;
            }
        }
        return s;
    }

    public static void main(String[] args) {
        List<Integer> s = new ArrayList<>();
        int[] array1 = new int[]{-1, 5, 10, 20, 28, 3};
        int[] array2 = new int[]{26, 134, 135, 15, 17};
        s = findDifference(array1, array2);
        System.out.println("The Smallest Difference value of the two arrays is : " + s.get(0) + " , " + s.get(1));
    }

}
