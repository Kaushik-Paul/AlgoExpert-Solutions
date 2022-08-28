package io.algoexpert.easy;

import java.util.HashMap;
import java.util.Map;

public class NthFibonacci {
    private Map<Integer, Integer> memory = new HashMap<>();

    public NthFibonacci() {
        memory.put(1, 0);
        memory.put(2, 1);
    }

    public int fibonacciOld(int num) {
        if (num == 1) {
            return 0;
        }
        if (num == 2) {
            return 1;
        }
        return fibonacciOld(num- 1) + fibonacciOld(num - 2);
    }

    // O(n) time and O(n) space
    public int fibonacci(int num) {
        if (num <= 2) {
            return memory.get(num);
        }
        if (memory.containsKey(num)) {
            return memory.get(num);
        } else {
            int v = fibonacci(num - 1) + fibonacci(num - 2);
            memory.put(num, v);
            return v;   //same as return memory.get(num)
        }
    }

    public int fibonacciIteration(int num) {
        int[] array = new int[]{0, 1};
        int counter = 3;
        int nextFib = 0;
        while (counter <= num) {
            nextFib = array[0] + array[1];
            array[0] = array[1];
            array[1] = nextFib;
            counter++;
        }
        if (num <= 1) {
            return array[0];
        }
        return array[1];
    }

    public static void main(String[] args) {
        NthFibonacci fibo = new NthFibonacci();
        System.out.println(fibo.fibonacci(7));
    }

}
