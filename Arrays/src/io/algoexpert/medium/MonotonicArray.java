package io.algoexpert.medium;

public class MonotonicArray {

    public static boolean isMonotonic(int[] array) {
        boolean increasing = true;
        boolean decreasing = true;
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] > array[i + 1]) {
                increasing = false;
            }
            if (array[i] < array[i + 1]) {
                decreasing = false;
            }
        }
        return increasing || decreasing;
    }

    public static boolean isMonotonic1(int[] array) {
        boolean increasing = true;
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] == array[i + 1]) {
                continue;
            }
            if (array[i] > array[i + 1]) {
                increasing = false;
            }
            if (!breakDirection(array[i],array[i+1], increasing)) {
                return false;
            }
        }
        return true;
    }

    private static boolean breakDirection(int current,int next,boolean increasing) {
        if (increasing) {
            return (next - current) > 0;
        }
        return (current - next) > 0;
    }

    public static void main(String[] args) {
        int[] array = new int[]{-1, -5, -10, -1100, -1100, -1101, -1102, -9001};
        if (isMonotonic(array)) {
            System.out.println("The array is monotonic (without using direction)");
        } else {
            System.out.println("The array is not Monotonic (without using direction)");
        }
        if (isMonotonic1(array)) {
            System.out.println("The array is monotonic (using direction)");
        } else {
            System.out.println("The array is not Monotonic (using direction)");
        }
    }

}
