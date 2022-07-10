package io.algoexpert.easy;

public class Palindrome {

    public boolean isPalindrome1(String string) {
        StringBuilder input = new StringBuilder();
        input.append(string);
        input.reverse();
        String rev = input.toString();
        return rev.equals(string);
    }

    public boolean isPalindrome(String string) {
        char[] arr = string.toCharArray();
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            if (arr[left] != arr[right]) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public boolean isPalindromeRec(String string, int i) {
        int left = i;
        int right = string.length() - 1 - i;

        if (string.charAt(left) != string.charAt(right)) {
            return false;
        }

        if (left <= right) {
            return isPalindromeRec(string, i + 1);
        }
        return true;
    }

    public static void main(String[] args) {
        Palindrome palindrome = new Palindrome();
        String str = "abcdcba";
        if (palindrome.isPalindrome1(str)) {
            System.out.println("It is Palindrome (using the built in function)");
        } else {
            System.out.println("Not a Palindrome (using the built in function)");
        }
        if (palindrome.isPalindrome(str)) {
            System.out.println("It is Palindrome (using the iteration function)");
        } else {
            System.out.println("Not a Palindrome (using the iteration function)");
        }
        if (palindrome.isPalindromeRec(str,0)) {
            System.out.println("It is Palindrome (using the recursion function)");
        } else {
            System.out.println("Not a Palindrome (using the recursion function)");
        }
    }

}
