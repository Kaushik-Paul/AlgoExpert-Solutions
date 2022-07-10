package io.algoexpert.medium;

public class LongestPalindromeSubstring {
    public static String longestPalindromeSubstring(String string) {
        String currentLargestString = string.substring(0, 1);
        int currentLargest = 1;
        String even;
        String odd;

        for (int i = 1; i < string.length(); i++) {
            odd = getLongestPalindromeFrom(string, i - 1, i + 1);
            even = getLongestPalindromeFrom(string, i - 1, i);
            int longest = Math.max(odd.length(), even.length());
            currentLargest = Math.max(currentLargestString.length(), longest);
            if (currentLargest != currentLargestString.length()) {
                if (longest == odd.length()) {
                    currentLargestString = odd;
                } else {
                    currentLargestString = even;
                }
            }
        }
        return currentLargestString;
    }

    private static String getLongestPalindromeFrom(String string, int startIdx, int endIdx) {
        while (startIdx >= 0 && endIdx < string.length()) {
            if (string.charAt(startIdx) != string.charAt(endIdx)) {
                break;
            }
            startIdx--;
            endIdx++;
        }
        return string.substring(startIdx + 1, endIdx);
    }

    public static void main(String[] args) {
        String string = "abaxyzzyxf";
        System.out.println("The Longest Palindrome Substring of " + string + " is : " + longestPalindromeSubstring(string));

    }
}
