package io.algoexpert.medium;

import java.util.ArrayList;
import java.util.List;

public class Permutations {
    private List<List<Integer>> permutation;

    public Permutations() {
        permutation = new ArrayList<>();
    }

    public List<List<Integer>> getPermutation(int[] array) {
        List<Integer> list = new ArrayList<>();
        for (int i : array) {
            list.add(i);
        }
        permutationHelper(list, new ArrayList<Integer>());
        return permutation;
    }

    public void permutationHelper(List<Integer> list, List<Integer> currentPermutation) {
        if (list.size() == 0 && !currentPermutation.isEmpty()) {
            permutation.add(currentPermutation);

        } else {
            for (int i : list) {
                List<Integer> newList = new ArrayList<>();
                int j = 0;
                while (j < list.size()) {
                    if (list.get(j) == i) {
                        j++;
                        continue;
                    }
                    newList.add(list.get(j));
                    j++;
                }
                List<Integer> newPermutation = new ArrayList<>();
                newPermutation = newList;
                newPermutation.add(i);
                permutationHelper(newList, newPermutation);
            }
        }


    }

    public static void main(String[] args) {
        Permutations pem = new Permutations();
        int[] array = new int[]{1, 2, 3};
        List<List<Integer>> list = new ArrayList<>();
        list = pem.getPermutation(array);
        System.out.println(list);

    }
}
