package io.algoexpert.easy;

import java.util.HashMap;
import java.util.Map;

public class GenerateDocument {

    public static boolean isGeneratingDocumentPossible(String characters, String document) {
        Map<Character, Integer> countCharacters = new HashMap<>();

        // Populate the countCharacter
        for (int i = 0; i < characters.length(); i++) {
            char ch = characters.charAt(i);
            if (countCharacters.containsKey(ch)) {
                countCharacters.replace(ch, countCharacters.get(ch) + 1);
            } else {
                countCharacters.put(ch, 1);
            }
        }

        for (int i = 0; i < document.length(); i++) {
            char ch = document.charAt(i);
            if (countCharacters.containsKey(ch) && countCharacters.get(ch) > 0) {
                countCharacters.replace(ch, countCharacters.get(ch) - 1);
            } else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String characters = "BSte!hetsi ogEAxpelrt x ";
        String document = "AlgoExpert is the BeSt!";
        System.out.println("Is it possible to generate document: " + isGeneratingDocumentPossible(characters, document));
    }
}
