package io.algoexpert.hard;

import java.util.HashMap;
import java.util.Map;

public class LargestRange {

    public static int[] largestRange(int[] array) {
        int[] currentLargestRange = new int[2];
        int longestRange = 0;
        Map<Integer, Boolean> map = new HashMap<>();
        for (int num : array) {
            map.put(num, false);
        }
        for (int num : array) {
            if (map.get(num)) {
                continue;
            }
            map.replace(num, true);
            int left = num - 1;
            int right = num + 1;
            int currentRange = 1;
            while (map.containsKey(left)) {
                map.replace(left, true);
                currentRange++;
                left--;
            }
            while (map.containsKey(right)) {
                map.replace(right, true);
                currentRange++;
                right++;
            }
            if (currentRange > longestRange) {
                longestRange = currentRange;
                currentLargestRange[0] = left + 1;
                currentLargestRange[1] = right - 1;
            }
        }
        return currentLargestRange;
    }

    public static void main(String[] args) {
        int[] array = new int[]{1, 11, 3, 0, 15, 5, 2, 4, 10, 7, 12, 6};
        int[] largestRange = largestRange(array);
        System.out.println("The Largest Range of the current array is : [" + largestRange[0] + " , " + largestRange[1] + "]");
    }

}
