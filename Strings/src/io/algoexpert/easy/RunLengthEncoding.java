package io.algoexpert.easy;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

public class RunLengthEncoding {

    public static String runLengthEncoding(String string) {
        List<Object> characterCount = new ArrayList<>();

        int length = 1;
        for (int i = 1; i < string.length(); i++) {
            if (string.charAt(i) == string.charAt(i - 1)) {
                length++;
                // Add to list once it exceeds 9
                if (length >= 9) {
                    characterCount.add(length);
                    characterCount.add(string.charAt(i++ - 1));
                    length = 1;
                }
            } else {
                characterCount.add(length);
                characterCount.add(string.charAt(i - 1));
                length = 1;
            }
        }
        // Add the last character
        characterCount.add(length);
        characterCount.add(string.charAt(string.length() - 1));
        return convertListToString(characterCount);
    }

    private static String convertListToString(List<Object> characterCount) {
        StringBuilder stringBuilder = new StringBuilder();
        for (Object ch : characterCount) {
            stringBuilder.append(ch);
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        String string = "AAAAAAAAAAAAABBCCCCDD";
        System.out.println("The Run Line Encoding for the string is: " + runLengthEncoding(string));
    }
}
