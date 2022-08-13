package io.algoexpert.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MinimumCharacterForWords {

    public static List<Character> minimumCharacterForWords(String[] words) {
        Map<Character, Integer> maximumCharacterFrequencies = new HashMap<>();

        for (String word : words) {
            Map<Character, Integer> countCharacters = countCharacterFrequencies(word);
            updateMaximumFrequencies(countCharacters, maximumCharacterFrequencies);
        }

        return makeArrayFromCharacterFrequencies(maximumCharacterFrequencies);
    }

    private static Map<Character, Integer> countCharacterFrequencies(String string) {
        Map<Character, Integer> characterFrequencies = new HashMap<>();
        for (int i = 0; i < string.length(); i++) {
            char ch = string.charAt(i);
            if (characterFrequencies.containsKey(ch)) {
                characterFrequencies.replace(ch, characterFrequencies.get(ch) + 1);
            } else {
                characterFrequencies.put(ch, 1);
            }
        }
        return characterFrequencies;
    }

    private static void updateMaximumFrequencies(Map<Character, Integer> countCharacters, Map<Character, Integer> maximumCharacterFrequencies) {

        for (Map.Entry<Character, Integer> mapEntry : countCharacters.entrySet()) {
            Character key = mapEntry.getKey();
            Integer value = mapEntry.getValue();
            if (maximumCharacterFrequencies.containsKey(key)) {
                maximumCharacterFrequencies.replace(key, Math.max(value, maximumCharacterFrequencies.get(key)));
            } else {
                maximumCharacterFrequencies.put(key, value);
            }
        }
    }

    private static List<Character> makeArrayFromCharacterFrequencies(Map<Character, Integer> maximumCharacterFrequencies) {
        List<Character> list = new ArrayList<>();
        for (Map.Entry<Character, Integer> mapEntry : maximumCharacterFrequencies.entrySet()) {
            Character key = mapEntry.getKey();
            Integer value = mapEntry.getValue();
            for (int i = 0; i < value; i++) {
                list.add(key);
            }
        }
        return list;
    }

    public static void main(String[] args) {
        String[] words = new String[]{"this", "that", "did", "deed", "them!", "a"};
        List<Character> uniqueCharacters = minimumCharacterForWords(words);
        System.out.println("The unique Character for the list is: " + uniqueCharacters);
    }
}

