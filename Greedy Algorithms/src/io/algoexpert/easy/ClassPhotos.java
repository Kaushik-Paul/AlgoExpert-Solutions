package io.algoexpert.easy;

import java.util.Arrays;

public class ClassPhotos {

    public static boolean isClassPhotoPossible(int[] redShirtHeights, int[] blueShirtHeights) {
        Arrays.sort(redShirtHeights);
        Arrays.sort(blueShirtHeights);

        boolean redShirtInFirstRow = redShirtHeights[redShirtHeights.length - 1] < blueShirtHeights[blueShirtHeights.length - 1];

        for (int i = 0; i < redShirtHeights.length; i++) {
            if (redShirtInFirstRow) {
                if (redShirtHeights[i] >= blueShirtHeights[i]) {
                    return false;
                }
            } else {
                if (blueShirtHeights[i] >= redShirtHeights[i]) {
                    return false;
                }
            }
        }
        return true;

    }

    public static void main(String[] args) {
        int[] redShirtHeights = new int[]{5, 8, 1, 3, 4};
        int[] blueShirtHeights = new int[]{6, 9, 2, 4, 5};

        System.out.println("Is Class Photo Possible: " + isClassPhotoPossible(redShirtHeights, blueShirtHeights));
    }
}
