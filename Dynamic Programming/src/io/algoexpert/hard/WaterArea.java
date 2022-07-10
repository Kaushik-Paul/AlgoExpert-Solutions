package io.algoexpert.hard;

public class WaterArea {

    public static int waterArea(int[] array) {
        int[] maxes = new int[array.length];
        int leftMax = 0;
        for (int i = 0; i < array.length; i++) {
            int height = array[i];
            maxes[i] = leftMax;
            leftMax = Math.max(leftMax, height);
        }
        int rightMax = 0;
        for (int i = array.length - 1; i >= 0; i--) {
            int height = array[i];
            maxes[i] = Math.min(rightMax, maxes[i]);
            if (height < maxes[i]) {
                maxes[i] = maxes[i] - height;
            } else {
                maxes[i] = 0;
            }
            rightMax = Math.max(height, rightMax);
        }
        int sum = 0;
        for (int i : maxes) {
            sum += i;
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] array = new int[]{0, 8, 0, 0, 5, 0, 0, 10, 0, 0, 1, 1, 0, 3};
        int waterArea = waterArea(array);
        System.out.println("The Water that can be held is : " + waterArea);
    }
}
