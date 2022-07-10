package io.algoexpert.hard;

import java.util.ArrayList;
import java.util.List;

public class SameBSTs {

    public boolean sameBST(int[] array1, int[] array2) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        for (int i : array1) {
            list1.add(i);
        }
        for (int i : array2) {
            list2.add(i);
        }
        return sameBSTHelper(list1, list2);
    }

    private boolean sameBSTHelper(List<Integer> listOne, List<Integer> listTwo) {
        if (listOne.size() != listTwo.size()) {
            return false;
        }
        if (listOne.isEmpty() && listTwo.isEmpty()) {
            return true;
        }
        if (listOne.get(0) != listOne.get(0)) {
            return false;
        }

        List<Integer> leftListOne = getSmaller(listOne);
        List<Integer> leftListTwo = getSmaller(listTwo);
        List<Integer> rightListOne = getBigger(listOne);
        List<Integer> rightListTwo = getBigger(listTwo);

        return sameBSTHelper(leftListOne, leftListTwo) && sameBSTHelper(rightListOne, rightListTwo);
    }

    private List<Integer> getSmaller(List<Integer> list) {
        List<Integer> leftList = new ArrayList<>();
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i) < list.get(0)) {
                leftList.add(list.get(i));
            }
        }
        return leftList;
    }

    private List<Integer> getBigger(List<Integer> list) {
        List<Integer> rightList = new ArrayList<>();
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i) >= list.get(0)) {
                rightList.add(list.get(i));
            }
        }
        return rightList;
    }

    public static void main(String[] args) {
        int[] array1 = new int[]{10, 15, 8, 12, 94, 81, 5, 2, 11};
        int[] array2 = new int[]{10, 8, 5, 15, 2, 12, 11, 94, 81};
        SameBSTs bst = new SameBSTs();
        if (bst.sameBST(array1, array2)) {
            System.out.println("Both the BSTs are the same!!!!");
        } else {
            System.out.println("Both the BSTs are not the same!!!!!");
        }
    }

}
