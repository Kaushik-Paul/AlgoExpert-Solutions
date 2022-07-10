package io.algoexpert.hard;

public class SearchForRange {

    public void searchForRange(int[] array, int target) {
        int[] range = new int[]{-1, -1};
        alteredBinarySearch(array, target, range, true);
        alteredBinarySearch(array, target, range, false);
        if (range[0] == -1) {
            System.out.println("The Number is Not found");
        } else {
            System.out.println("The Range of the number is : [" + range[0] + " , " + range[1] + "]");
        }
    }

    private void alteredBinarySearch(int[] array, int target, int[] range, boolean goLeft) {
        int left = 0;
        int right = array.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (target > array[mid]) {
                left = mid + 1;
            } else if (target < array[mid]) {
                right = mid - 1;
            } else {
                if (goLeft) {
                    if (mid == 0 || array[mid - 1] != target) {
                        range[0] = mid;
                        return;
                    } else {
                        right = mid - 1;
                    }
                } else {
                    if (mid == array.length - 1 || array[mid + 1] != target) {
                        range[1] = mid;
                        return;
                    } else {
                        left = mid + 1;
                    }
                }

            }
        }
    }

    public static void main(String[] args) {
        int[] array = new int[]{0, 1, 21, 33, 45, 45, 45, 45, 45, 45, 61, 71, 73};
        int target = 45;
        new SearchForRange().searchForRange(array, target);
    }
}
