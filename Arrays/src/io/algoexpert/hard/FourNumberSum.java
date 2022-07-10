package io.algoexpert.hard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FourNumberSum {

    public static List<Integer> fourNumberSum(int[] array, int target) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        List<Integer> result = new ArrayList<>();
        for (int i = 1; i < array.length - 1; i++) {
            for (int j = i + 1; j < array.length; j++) {
                int currentSum = array[i] + array[j];
                int difference = target - currentSum;
                if (map.containsKey(difference)) {
                    List<Integer> list = map.get(difference);
                    for (int k = 0; k < list.size(); k += 2) {
                        result.add(list.get(k));
                        result.add(list.get(k + 1));
                        result.add(array[i]);
                        result.add(array[j]);
                    }
                }
            }

            for (int j = 0; j < i; j++) {
                int currentSum = array[i] + array[j];
                if (!map.containsKey(currentSum)) {
                    map.put(currentSum, new ArrayList<>());
                    map.get(currentSum).add(array[i]);
                    map.get(currentSum).add(array[j]);
                } else {
                    map.get(currentSum).add(array[i]);
                    map.get(currentSum).add(array[j]);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] array = new int[]{7, 6, 4, -1, 1, 2};
        List<Integer> result = fourNumberSum(array, 16);
        System.out.println("The Four Numbers Pair are : ");
        for (int i = 0; i < result.size(); i += 4) {
            System.out.println("[" + result.get(i) + " , " + result.get(i + 1) + " , " +
                    result.get(i + 2) + " , " + result.get(i + 3) + "]");

        }
    }
}
