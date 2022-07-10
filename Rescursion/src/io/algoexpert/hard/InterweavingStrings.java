package io.algoexpert.hard;

import java.util.Arrays;

public class InterweavingStrings {

    static int count = 0;

    public boolean interweavingStringsNaive(String first, String second, String third) {
        char[] one = first.toCharArray();
        char[] two = second.toCharArray();
        char[] three = third.toCharArray();
        if (three.length != one.length + two.length) {
            return false;
        }
        return areInterwovenNaive(one, two, three, 0, 0);
    }

    private boolean areInterwovenNaive(char[] one, char[] two, char[] three, int i, int j) {
        count++;
        int k = i + j;
        if (k == three.length) {
            return true;
        }
        if (i < one.length && one[i] == three[j]) {
            if (areInterwovenNaive(one, two, three, i + 1, j)) {
                return true;
            }
        }
        if (j < two.length && two[j] == three[k]) {
            return areInterwovenNaive(one, two, three, i, j + 1);
        }
        return false;
    }

    public boolean interweavingStrings(String first, String second, String third) {
        char[] one = first.toCharArray();
        char[] two = second.toCharArray();
        char[] three = third.toCharArray();
        if (three.length != one.length + two.length) {
            return false;
        }
        boolean[][] cache = new boolean[one.length + 1][two.length + 1];
        for (boolean[] arr : cache) {
            Arrays.fill(arr, false);
        }
        return areInterwoven(one, two, three, 0, 0, cache);
    }

    private boolean areInterwoven(char[] one, char[] two, char[] three, int i, int j, boolean[][] cache) {
        if (cache[i][j]) {
            return false;
        }
        cache[i][j] = true;
        int k = i + j;
        if (i < one.length && one[i] == three[k]) {
            if (areInterwoven(one, two, three, i + 1, j, cache)) {
                return true;
            }
        }
        if (j < two.length && two[j] == three[k]) {
            return areInterwoven(one, two, three, i, j + 1, cache);
        }
        return false;
    }


    public static void main(String[] args) {
        String one = "aaa";
        String two = "aaaf";
        String three = "aaafaaa";
        InterweavingStrings strings = new InterweavingStrings();
        if (strings.interweavingStringsNaive(one, two, three)) {
            System.out.println("The Strings are Interwoven");
        } else {
            System.out.println("The Strings are not interwoven");
        }
        System.out.println("The count : " + count);
//        if (strings.interweavingStrings(one, two, three)) {
//            System.out.println("The Strings are Interwoven");
//        } else {
//            System.out.println("The Strings are not interwoven");
//        }
    }
}
