package io.algoexpert.hard;

import java.util.ArrayList;
import java.util.List;

public class ZigzagTraversal {
    public static List<Integer> zigzagTraversal(int[][] array) {
        List<Integer> list = new ArrayList<>();
        int height = array.length - 1;
        int width = array[0].length - 1;
        int row = 0, col = 0;
        boolean goingDown = true;
        while (!outOfBounds(row, col, height, width)) {
            list.add(array[row][col]);
            if (goingDown) {
                if (col == 0 || row == height) {
                    goingDown = false;
                    if (row == height) {
                        col += 1;
                    }
                    if (col == 0) {
                        row += 1;
                    }
                } else {
                    row++;
                    col--;
                }
            } else {
                if (row == 0 || col == width) {
                    goingDown = true;
                    if (col == width) {
                        row++;
                    }
                    if (row == 0) {
                        col++;
                    }
                } else {
                    row--;
                    col++;
                }
            }
        }
        return list;
    }

    private static boolean outOfBounds(int row, int col, int height, int width) {
        return row < 0 || row > height || col < 0 || col > width;
    }

    public static void main(String[] args) {
        int[][] array = new int[][]{
                {1, 3, 4, 10},
                {2, 5, 9, 11},
                {6, 8, 12, 15},
                {7, 13, 14, 16}
        };
        List<Integer> result = zigzagTraversal(array);
        System.out.println(result);
    }
}
