package io.algoexpert.hard;

public class LongestCommonSubsequence {

    public static String longestCommonSusequence(String str1, String str2) {
        String[][] lcs = new String[str1.length() + 1][str2.length() + 1];
        for (int i = 0; i < lcs.length; i++) {
            for (int j = 0; j < lcs[0].length; j++) {
                lcs[i][j] = "";
            }
        }
        for (int i = 1; i < lcs.length; i++) {
            for (int j = 1; j < lcs[0].length; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    lcs[i][j] = lcs[i - 1][j - 1] + str1.charAt(i - 1);
                } else {
                    lcs[i][j] = (lcs[i - 1][j].length() >= lcs[i][j - 1].length()) ? lcs[i - 1][j] : lcs[i][j - 1];
                }
            }
        }
        return lcs[str1.length()][str2.length()];
    }

    public static void main(String[] args) {
        String str1 = "zxvvyzw";
        String str2 = "xkykzpw";
        String result = longestCommonSusequence(str1, str2);
        System.out.println("The Longest Common Subsequence is : " + result);
    }
}
