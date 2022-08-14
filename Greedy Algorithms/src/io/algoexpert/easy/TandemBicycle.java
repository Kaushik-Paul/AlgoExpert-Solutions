package io.algoexpert.easy;

import java.util.Arrays;

public class TandemBicycle {

    public static int findTandemBicycleSpeed(int[] redShirtSpeeds, int[] blueShirtSpeeds, boolean fastest) {
        Arrays.sort(redShirtSpeeds);
        Arrays.sort(blueShirtSpeeds);
        int totalSpeed = 0;

        if (fastest) {
            reverseArray(redShirtSpeeds);
        }

        for (int i = 0; i < redShirtSpeeds.length; i++) {
            if (fastest) {
                totalSpeed += Math.max(redShirtSpeeds[i], blueShirtSpeeds[i]);
            } else {
                totalSpeed += Math.min(redShirtSpeeds[i], blueShirtSpeeds[i]);
            }
        }
        return totalSpeed;
    }

    private static void reverseArray(int[] array) {
        int left = 0;
        int right = array.length - 1;
        while (left < right) {
            int temp = array[left];
            array[left] = array[right];
            array[right] = temp;
            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        int[] redShirtSpeeds = new int[]{5, 5, 3, 9, 2};
        int[] blueShirtSpeeds = new int[]{3, 6, 7, 2, 1};
        System.out.println("The Fastest Speed for tandem bike is: " + findTandemBicycleSpeed(redShirtSpeeds, blueShirtSpeeds, true));
        System.out.println("The Slowest Speed for tandem bike is: " + findTandemBicycleSpeed(redShirtSpeeds, blueShirtSpeeds, false));

    }
}
