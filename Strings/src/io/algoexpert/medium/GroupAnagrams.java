package io.algoexpert.medium;

import java.util.*;

public class GroupAnagrams {

    public static void getGroupAnagrams(String[] strings) {
        String sortedString;
        Map<String, List<String>> map = new HashMap<>();
        for (String string : strings) {
            char[] ch = string.toCharArray();
            Arrays.sort(ch);
            sortedString = new String(ch);
            if (map.containsKey(sortedString)) {
                map.get(sortedString).add(string);
            } else {
                map.put(sortedString, new ArrayList<>());
                map.get(sortedString).add(string);
            }
        }
        List<List<String>> anagrams = new ArrayList<>();
        map.forEach((key, value) -> anagrams.add(value));
        System.out.println("The resultent anagrams are :");
        System.out.println(anagrams);
    }

    public static void main(String[] args) {
        String[] strings = new String[]{"yo", "act", "flop", "tac", "act", "oy", "olfp"};
        getGroupAnagrams(strings);
    }
}
