package io.algoexpert.medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class RiverSizes {

    public void riverSizes(int[][] matrix) {
        List<Integer> sizes = new ArrayList<>();
        boolean visited[][] = new boolean[matrix.length][matrix[0].length];
        for (int i = 0; i < visited.length; i++) {
            for (int j = 0; j < visited[0].length; j++) {
                visited[i][j] = false;
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (visited[i][j]) {
                    continue;
                }
                traverseNode(i, j, matrix, visited, sizes);
            }
        }
        System.out.println("The River Sizes are : ");
        System.out.println(sizes);
    }

    private void traverseNode(int i, int j, int[][] matrix, boolean[][] visited, List<Integer> sizes) {
        int currentRiverSize = 0;
        Stack<Integer[]> nodesToExplore = new Stack<>();
        nodesToExplore.push(new Integer[]{i, j});
        while (!nodesToExplore.isEmpty()) {
            Integer[] currentNode = nodesToExplore.pop();
            i = currentNode[0];
            j = currentNode[1];
            if (visited[i][j]) {
                continue;
            }
            visited[i][j] = true;
            if (matrix[i][j] == 0) {
                continue;
            }
            currentRiverSize++;
            List<Integer[]> unVisitedNode;
            unVisitedNode = getUnVisitedNode(i, j, matrix, visited);
            unVisitedNode.forEach(nodesToExplore::push);

        }
        if (currentRiverSize > 0) {
            sizes.add(currentRiverSize);
        }
    }

    private List<Integer[]> getUnVisitedNode(int i, int j, int[][] matrix, boolean[][] visited) {
        List<Integer[]> unVisitedNeighbours = new ArrayList<>();
        if (i > 0 && !visited[i - 1][j]) {
            unVisitedNeighbours.add(new Integer[]{i - 1, j});
        }
        if (i < matrix.length - 1 && !visited[i + 1][j]) {
            unVisitedNeighbours.add(new Integer[]{i + 1, j});
        }
        if (j > 0 && !visited[i][j - 1]) {
            unVisitedNeighbours.add(new Integer[]{i, j - 1});
        }
        if (j < matrix[0].length - 1 && !visited[i][j + 1]) {
            unVisitedNeighbours.add(new Integer[]{i, j + 1});
        }
        return unVisitedNeighbours;

    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {1, 0, 0, 1, 0},
                {1, 0, 1, 0, 0},
                {0, 0, 1, 0, 1},
                {1, 0, 1, 0, 1},
                {1, 0, 1, 1, 0}
        };
        RiverSizes riverSizes = new RiverSizes();
        riverSizes.riverSizes(matrix);
    }
}
