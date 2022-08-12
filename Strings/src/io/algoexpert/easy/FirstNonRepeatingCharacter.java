package io.algoexpert.easy;

import java.util.HashMap;
import java.util.Map;

public class FirstNonRepeatingCharacter {

    public static char getFirstNonRepeatingCharacter(String string) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < string.length(); i++) {
            char ch = string.charAt(i);
            if (map.containsKey(ch)) {
                map.replace(ch, map.get(ch) + 1);
            } else {
                map.put(ch, 0);
            }
        }
        for (int i = 0; i < string.length(); i++) {
            char ch = string.charAt(i);
            if (map.get(ch) == 0) {
                return ch;
            }
        }
        return string.charAt(string.length() - 1);
    }

    public static void main(String[] args) {
        String string = "abcdcaf";
        System.out.println("The First Non Repeating Character is: " + getFirstNonRepeatingCharacter(string));
    }
}
