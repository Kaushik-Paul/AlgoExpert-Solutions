package io.algoexpert.hard;

import java.util.*;

public class NumbersInPi {

    public void numbersInPi(String pi, String[] numbers) {
        Hashtable<Integer, Integer> cache = new Hashtable<>();
        Set<String> numbersTable = new HashSet<>();
        for (String str : numbers) {
            numbersTable.add(str);
        }

        int minSpaces = getMinSpaces(pi, numbersTable, cache, 0);
        if (minSpaces == Integer.MAX_VALUE) {
            System.out.println("No Spaces available");
        } else {
            System.out.println("The Minimum number of spaces is : " + minSpaces);
        }
    }

    private int getMinSpaces(String pi, Set<String> numbersTable, Hashtable<Integer, Integer> cache, int idx) {
        if (idx == pi.length()) {
            return -1;
        }
        if (cache.contains(idx)) {
            return cache.get(idx);
        }
        int minSpaces = Integer.MAX_VALUE;
        for (int i = idx; i < pi.length(); i++) {
            String prefix = pi.substring(idx, i + 1);
            if (numbersTable.contains(prefix)) {
                int minSpacesInSuffix = getMinSpaces(pi, numbersTable, cache, i + 1);
                minSpaces = Math.min(minSpacesInSuffix + 1, minSpaces);
            }

        }
        cache.put(idx, minSpaces);
        return minSpaces;
    }

    public static void main(String[] args) {
        String pi = "3141592";
        String[] numbers = new String[]{
                "3141", "5", "31", "2", "4159", "9", "42"
        };
        NumbersInPi pi1 = new NumbersInPi();
        pi1.numbersInPi(pi, numbers);
    }
}
