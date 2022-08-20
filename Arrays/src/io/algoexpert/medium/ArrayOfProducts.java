package io.algoexpert.medium;

import java.util.Arrays;

public class ArrayOfProducts {

    public static int[] arrayOfProducts(int[] array) {
        int totalProduct = 1;
        int[] arrayOfProduct = new int[array.length];
        for (int num : array) {
            totalProduct *= num;
        }
        for (int i = 0; i < array.length; i++) {
            arrayOfProduct[i] = totalProduct / array[i];
        }
        return arrayOfProduct;
    }

    public static void main(String[] args) {
        int[] array = new int[]{5, -1, 4, 2};
        System.out.println("The Product Of Arrays is: " + (Arrays.toString(arrayOfProducts(array))));
    }
}
