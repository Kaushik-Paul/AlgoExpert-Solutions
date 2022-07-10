package io.algoexpert.easy;

public class ValidateSubsequence {

    public static void main(String[] args) {
        ValidateSubsequence validateSubsequence = new ValidateSubsequence();
        int[] array = new int[]{5, 1, 22, 25, 6, -1, 8, 10};
        int[] subsequence = new int[]{1, 6, -1, 10};
        if (validateSubsequence.check(array, subsequence)) {
            System.out.println("Its a valid subsequence");
        } else {
            System.out.println("Not a valid subsequence");
        }
    }

    public boolean check(int[] array, int[] subsequence) {
        int arrIndex = 0, subIndex = 0;
        while (arrIndex < array.length && subIndex < subsequence.length) {
            if (array[arrIndex] == subsequence[subIndex]) {
                subIndex++;
            }
            arrIndex++;
        }
        return subIndex == subsequence.length;
    }

}
