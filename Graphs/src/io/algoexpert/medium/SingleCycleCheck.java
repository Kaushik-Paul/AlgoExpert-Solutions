package io.algoexpert.medium;

public class SingleCycleCheck {

    public static boolean hasSingleCycle(int[] array, int startingIndex) {
        int currentIndex = startingIndex;
        int noOfNodesVisited = 0;
        while (noOfNodesVisited < array.length) {
            if (noOfNodesVisited > 0 && currentIndex == startingIndex) {
                return false;
            }
            noOfNodesVisited++;
            currentIndex = getNextIndex(array, currentIndex);
        }
        return currentIndex == startingIndex;
    }

    public static int getNextIndex(int[] array, int currentIndex) {
        int jump = array[currentIndex];
        int nextIndex = (currentIndex + jump) % array.length;
        if (nextIndex >= 0) {
            return nextIndex;
        }
        return nextIndex + array.length;
    }

    public static void main(String[] args) {
        int[] array = new int[]{2, 3, 1, -4, -4, 2};
        if (hasSingleCycle(array, 0)) {
            System.out.println("The array has single cycle");
        } else {
            System.out.println("The array does not have a single cycle");
        }
    }
}
