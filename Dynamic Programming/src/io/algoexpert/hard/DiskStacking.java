package io.algoexpert.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DiskStacking {

    public static List<int[]> diskStacking(int[][] array) {
        int[] height = new int[array.length];
        int[] sequence = new int[array.length];
        int maxHeightIdx = 0;
        Arrays.fill(sequence, -1);
        for (int i = 0; i < array.length; i++) {
            height[i] = array[i][2];
            int[] currentDisk = array[i];
            for (int j = 0; j < i; j++) {
                int[] otherDisk = array[j];
                if (validDimensions(currentDisk, otherDisk)) {
                    if (height[i] < currentDisk[2] + height[j]) {
                        height[i] = currentDisk[2] + height[j];
                        sequence[i] = j;
                    }
                }
            }
            if (height[i] > height[maxHeightIdx]) {
                maxHeightIdx = i;
            }

        }
        System.out.println("The Maximum height that can be formed is : " + height[maxHeightIdx]);
        List<int[]> list = buildSequenceArray(array, sequence, maxHeightIdx);
        return list;
    }

    private static boolean validDimensions(int[] c, int[] o) {
        return o[0] < c[0] && o[1] < c[1] && o[2] < c[2];
    }

    private static List<int[]> buildSequenceArray(int[][] array, int[] sequence, int currentIdx) {
        List<int[]> list = new ArrayList<>();
        while (currentIdx != -1) {
            list.add(array[currentIdx]);
            currentIdx = sequence[currentIdx];
        }
        return list;
    }

    public static void main(String[] args) {
        int[][] array = new int[][]{
                {2, 2, 1},
                {2, 1, 2},
                {3, 2, 3},
                {2, 3, 4},
                {4, 4, 5},
                {2, 2, 8}
        };
        List<int[]> list = diskStacking(array);
        System.out.println("The Disks for this height is : ");
        list.forEach(st->{
            System.out.print("[");
            for (int arr : st) {
                System.out.print(arr + " ");
            }
            System.out.println("] , ");
        });
    }

}
