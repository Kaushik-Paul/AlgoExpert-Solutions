package io.algoexpert.medium;

import java.util.ArrayList;
import java.util.List;

public class SpiralTraverse {

    public static void main(String[] args) {
        int[][] array = new int[][]{
                {1, 2, 3, 4},
                {12, 13, 14, 5},
                {11, 16, 15, 6},
                {10, 9, 8, 7}
        };
        List<Integer> s = new ArrayList<>();
        s = new SpiralTraverse().spiralTraverse(array);
        System.out.println("Spiral Traversal using Iteration : ");
        s.forEach((st) -> System.out.print(st + " , "));
        System.out.println();
        System.out.println("Spiral Traversal using Recursion : ");
        s = new SpiralTraverse().spiralTraverseRec(array);
        s.forEach((st) -> System.out.print(st + " , "));
    }

    public List<Integer> spiralTraverse(int[][] array) {
        List<Integer> s = new ArrayList<>();
        int startRow = 0, endRow = array.length - 1;
        int startCol = 0, endCol = array[0].length - 1;
        while (startRow <= endRow && startCol <= endCol) {
            for (int col = startCol; col <= endCol; col++) {
                s.add(array[startRow][col]);
            }
            for (int row = startRow + 1; row <= endRow; row++) {
                s.add(array[row][endCol]);
            }
            for (int col = endCol - 1; col >= startCol; col--) {
                s.add(array[endRow][col]);
            }
            for (int row = endRow - 1; row >= startRow + 1; row--) {
                s.add(array[row][startCol]);
            }
            startRow++;
            endRow--;
            startCol++;
            endCol--;
        }
        return s;
    }

    public List<Integer> spiralTraverseRec(int[][] array) {
        List<Integer> s = new ArrayList<>();
        traversal(array, 0, array.length - 1, 0, array[0].length - 1,s);
        return s;
    }

    private void traversal(int[][] array, int startRow, int endRow, int startCol, int endCol,List<Integer> s) {
        if (startRow > endRow || startCol > endCol) {
            return;
        }
        for (int col = startCol; col <= endCol; col++) {
            s.add(array[startRow][col]);
        }
        for (int row = startRow + 1; row <= endRow; row++) {
            s.add(array[row][endCol]);
        }
        for (int col = endCol - 1; col >= startCol; col--) {
            s.add(array[endRow][col]);
        }
        for (int row = endRow - 1; row >= startRow + 1; row--) {
            s.add(array[row][startCol]);
        }
        traversal(array, startRow+1, endRow-1, startCol+1, endCol-1, s);
    }

}
