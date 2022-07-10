package io.algoexpert.medium;

import java.util.ArrayList;
import java.util.List;

public class Checking {
    private static void swap(int firstIdx, int secondIdx, List<Integer> heap) {
        int firstValue = heap.get(firstIdx);
        int secondValue = heap.get(secondIdx);
        heap.set(firstIdx, secondValue);
        heap.set(secondIdx, firstValue);
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        System.out.println(list);
        swap(0, 1, list);
        System.out.println(list);

    }
}
