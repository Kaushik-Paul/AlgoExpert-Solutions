package io.algoexpert.hard;

import java.util.HashMap;

public class LongestSubstringWithoutDuplication {
    public static void substring(String string) {
        int[] longest = new int[]{0, 0};
        int startIdx = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < string.length(); i++) {
            char ch = string.charAt(i);
            if (map.containsKey(ch)) {
                startIdx = Math.max(startIdx, map.get(ch) + 1);
            }
            if (longest[1] - longest[0] < i - startIdx) {
                longest[0] = startIdx;
                longest[1] = i;
            }
            map.put(ch, i);
        }
        System.out.println("Longest Substring Without Duplication is : " + string.substring(longest[0], longest[1] + 1));
    }

    public static void main(String[] args) {
        String str = "clementisacap";
        substring(str);
    }
}
