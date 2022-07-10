package io.algoexpert.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class TwoNumberSum {
    public static void main(String[] args) {
        int[] array = new int[]{3, 5, -4, 8, 11, -1, 6};
        int sum = 10;
        List<Integer> s = new ArrayList<>();
        TwoNumberSum twoNumberSum = new TwoNumberSum();
        s = twoNumberSum.check2(array, sum);
        if (s.size() == 2) {
            System.out.println("The two number sum if : " + s.get(0) + "," + s.get(1));
        } else {
            System.out.println("Two Number sum is not available");
        }
    }

    public List<Integer> check(int[] array, int sum) {
        HashSet<Integer> s = new HashSet<>();
        List<Integer> arrayList = new ArrayList<>(2);
        int target = 0;
        for (int i = 0; i < array.length; i++) {
            target = sum - array[i];
            if (s.contains(target)) {
                arrayList.add(array[i]);
                arrayList.add(target);
                break;
            } else {
                s.add(array[i]);
            }
        }
        return arrayList;
    }

    public List<Integer> check2(int[] array, int sum) {
        Arrays.sort(array);
        List<Integer> s = new ArrayList<>();
        int left = 0;
        int right = array.length - 1;
        while (left < right) {
            if (array[left] + array[right] > sum) {
                right--;
            } else if (array[left] + array[right] < sum) {
                left++;
            } else {
                s.add(array[left]);
                s.add(array[right]);
                break;
            }
        }
        return s;
    }
}
