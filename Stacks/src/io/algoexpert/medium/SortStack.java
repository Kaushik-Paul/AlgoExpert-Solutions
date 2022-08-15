package io.algoexpert.medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class SortStack {

    public void sortStack(Stack<Integer> stack) {
        if (stack.isEmpty()) {
            return;
        }
        int top = stack.pop();
        sortStack(stack);
        insertInSortedOrder(stack, top);
    }

    private void insertInSortedOrder(Stack<Integer> stack, int value) {
        if (stack.isEmpty() || stack.peek() <= value) {
            stack.push(value);
            return;
        }

        int top = stack.pop();
        insertInSortedOrder(stack, value);
        stack.push(top);
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>() {{
            push(-5);
            push(2);
            push(-2);
            push(4);
            push(3);
            push(1);
        }};
        SortStack sortStack = new SortStack();
        sortStack.sortStack(stack);
        List<Integer> stackArray = new ArrayList<>(stack);
        System.out.println(stackArray);
    }

}
