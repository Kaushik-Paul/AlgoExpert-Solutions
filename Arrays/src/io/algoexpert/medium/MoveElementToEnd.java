package io.algoexpert.medium;

public class MoveElementToEnd {

    public static void moveElementToEnd(int[] array, int target) {
        int left = 0;
        int right = array.length - 1;
        int temp;
        while (left < right) {
            if (array[right] == target) {
                right--;
                continue;
            }
            if (array[left] == target) {
                temp = array[left];
                array[left] = array[right];
                array[right] = temp;
            }
            left++;
        }
    }

    public static void main(String[] args) {
        int[] array = new int[]{4, 1, 2, 2, 2, 3, 2, 2};
        int target = 2;
        moveElementToEnd(array, target);
        System.out.println("After moving "+target+" to the end. The resulting array is : ");
        for (int i : array) {
            System.out.print(i+" , ");
        }
    }

}
