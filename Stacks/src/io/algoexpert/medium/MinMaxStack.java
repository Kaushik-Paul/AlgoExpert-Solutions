package io.algoexpert.medium;

import java.util.Stack;

public class MinMaxStack {

    private Stack<Integer> minStack;
    private Stack<Integer> maxStack;
    private Stack<Integer> stack;

    public MinMaxStack() {
        minStack = new Stack<>();
        maxStack = new Stack<>();
        stack = new Stack<>();
    }

    public void peek() {
        System.out.println("Top of the Stack is : " + stack.peek());
    }

    public void pop() {
        if (stack.isEmpty()) {
            System.out.println("The Stack is Empty \n Cannot pop value");
            return;
        }
        Integer valuePopped = stack.pop();
        System.out.println("The Value Popped is : " + valuePopped);
        minStack.pop();
        maxStack.pop();
    }

    public void push(int value) {
        stack.push(value);
        if (minStack.isEmpty()) {
            minStack.push(value);
            maxStack.push(value);
            return;
        }
        if (minStack.peek() >= value) {
            minStack.push(value);
            maxStack.push(maxStack.peek());
        } else if (maxStack.peek() <= value) {
            maxStack.push(value);
            minStack.push(minStack.peek());
        }
    }

    public void getMin() {
        System.out.println("The minimum value is : " + minStack.peek());
    }

    public void getMax() {
        System.out.println("The maximum value is : " + maxStack.peek());
    }

    public static void main(String[] args) {
        MinMaxStack st = new MinMaxStack();
        st.push(5);
        st.push(7);
        st.push(2);
        st.getMin();
        st.getMax();
        st.pop();
        st.getMin();
        st.getMax();
        st.push(6);
        st.getMin();
        st.getMax();


    }
}
