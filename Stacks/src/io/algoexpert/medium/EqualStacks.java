package io.algoexpert.medium;

import java.util.Stack;

public class EqualStacks {

    public static int equalStacksHeight(int[] array1, int[] array2, int[] array3) {
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        Stack<Integer> stack3 = new Stack<>();
        int sum1 = 0, sum2 = 0, sum3 = 0;
        for (int i = array1.length - 1; i >= 0; i--) {
            sum1 += array1[i];
            stack1.push(array1[i]);
        }
        for (int i = array2.length - 1; i >= 0; i--) {
            sum2 += array2[i];
            stack2.push(array2[i]);
        }
        for (int i = array3.length - 1; i >= 0; i--) {
            sum3 += array3[i];
            stack3.push(array3[i]);
        }

        while (true) {
            if (stack1.empty() || stack2.empty() || stack3.empty()) {
                return 0;
            }
            if (sum1 == sum2 && sum1 == sum3) {
                return sum1;
            } else if (sum1 >= sum2 && sum1 >= sum3) {
                Integer remove = stack1.pop();
                sum1 -= remove;
            } else if (sum2 >= sum1 && sum2 >= sum3) {
                int remove = stack2.pop();
                sum2 -= remove;
            } else if (sum3 >= sum1 && sum3 >= sum2) {
                int remove = stack3.pop();
                sum3 -= remove;
            }
        }
    }

    public static void main(String[] args) {
        int[] array1 = new int[]{3, 2, 1, 1, 1};
        int[] array2 = new int[]{4, 3, 2};
        int[] array3 = new int[]{1, 1, 4, 1};
        int height = equalStacksHeight(array1, array2, array3);
        System.out.println("The Equal Height of these stacks is : " + height);
    }
}
