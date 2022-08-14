package io.algoexpert.medium;

import java.util.*;

public class TaskAssignment {

    public static List<int[]> taskAssignment(int[] tasks, int k) {
        List<int[]> pairedTasks = new ArrayList<>();
        Map<Integer, List<Integer>> taskDurationsToIndices = getTaskDurationsToIndices(tasks);

        Arrays.sort(tasks);
        int left = 0;
        int right = tasks.length - 1;
        while (left < right) {
            int[] workerTask = new int[2];
            workerTask[0] = taskDurationsToIndices.get(tasks[left]).remove(0);
            workerTask[1] = taskDurationsToIndices.get(tasks[right]).remove(0);
            pairedTasks.add(workerTask);
            left++;
            right--;
        }
        return pairedTasks;
    }

    private static Map<Integer, List<Integer>> getTaskDurationsToIndices(int[] tasks) {
        Map<Integer, List<Integer>> taskDurationsToIndices = new HashMap<>();
        for (int i = 0; i < tasks.length; i++) {
            if (taskDurationsToIndices.containsKey(tasks[i])) {
                taskDurationsToIndices.get(tasks[i]).add(i);
            } else {
                taskDurationsToIndices.put(tasks[i], new ArrayList<>(List.of(i)));
            }
        }
        return taskDurationsToIndices;
    }

    public static void main(String[] args) {
        int[] tasks = new int[]{1, 3, 5, 3, 1, 4};
        System.out.print("The Pair for Task Assignment is: " );
        taskAssignment(tasks, 3).forEach(value -> System.out.print(Arrays.toString(value) + " , "));
    }
}
