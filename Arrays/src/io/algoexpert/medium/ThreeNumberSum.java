package io.algoexpert.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeNumberSum {

    public static List<Integer> check(int[] array, int target) {
        List<Integer> s = new ArrayList<>();
        int left;
        int right;
        int currentSum;
        Arrays.sort(array);
        for (int i = 0; i < array.length - 2; i++) {
            left = i + 1;
            right = array.length - 1;
            while (left < right) {
                currentSum = array[i] + array[left] + array[right];
                if (currentSum == target) {
                    s.add(array[i]);
                    s.add(array[left]);
                    s.add(array[right]);
                    left++;
                    right--;
                } else if (currentSum < target) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return s;
    }

    public static void main(String[] args) {
        List<Integer> s = new ArrayList<>();
        int[] array = new int[]{12, 3, 1, 2, -6, 5, -8, 6};
        int target = 0;
        s = check(array, target);
        System.out.println("All possible Three Nmber Sum is : ");
        for (int i = 0; i < s.size(); i += 3) {
            System.out.print(s.get(i) + " , " + s.get(i + 1) + " , " + s.get(i + 2));
            System.out.println();
        }
    }

}
