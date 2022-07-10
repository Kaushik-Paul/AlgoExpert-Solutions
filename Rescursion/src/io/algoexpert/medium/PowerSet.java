package io.algoexpert.medium;

import java.util.HashSet;
import java.util.Set;

public class PowerSet {

    public static void printPowerSet(int[] array) {
        Set<Integer> set = new HashSet<>();
        for (int arr : array) {
            set.add(arr);
        }

        Set<Set<Integer>> powerSet = new HashSet<>();
        powerSet.add(new HashSet<>());
//        powerSet.add(set);
        for (int arr : set) {
            for (Set<Integer> arrPow : powerSet) {
                arrPow.add(arr);
                powerSet.add(arrPow);
            }
        }

        System.out.println(powerSet);
    }

    public static void main(String[] args) {
        int[] array = new int[]{1, 2, 3};
        printPowerSet(array);
    }
}
