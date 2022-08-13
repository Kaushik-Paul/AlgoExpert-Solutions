package io.algoexpert.medium;

import java.util.ArrayList;
import java.util.List;

public class ReverseWordsInString {

    public static String  reverseWordsInString(String string) {
        List<String> words = new ArrayList<>();

        int startOfWord = 0;
        for (int idx = 0; idx < string.length(); idx++) {
            char ch = string.charAt(idx);

            // Add the word and each separate entry for space
            if (ch == ' ') {
                words.add(string.substring(startOfWord, idx));
                startOfWord = idx;
            } else if (string.charAt(startOfWord) == ' ') {
                // Add the space before start of a word
                words.add(" ");
                startOfWord = idx;
            }
        }
        // Add the last word
        words.add(string.substring(startOfWord));
        // Reverse the list
        reverseList(words);

        return String.join("", words);
    }

    private static void reverseList(List<String> words) {
        int left = 0;
        int right = words.size() - 1;
        while (left <= right) {
            String tempString = words.get(left);
            words.set(left, words.get(right));
            words.set(right, tempString);
            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        String string = "Algoexpert is the best!";
        System.out.println("The reverse of the string is: " + reverseWordsInString(string));
    }
}
