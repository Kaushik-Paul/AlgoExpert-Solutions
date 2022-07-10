package io.algoexpert.easy;

public class ThreeLargestNumber {
    public int[] findThreeLargestNumber(int[] arr) {
        int[] largest = new int[]{Integer.MIN_VALUE,Integer.MIN_VALUE,Integer.MIN_VALUE};
        for (int num : arr) {
            updateLargest(largest, num);
        }
        return largest;
    }

    private void updateLargest(int[] largest, int num) {
        if (largest[2] == Integer.MIN_VALUE || largest[2] < num) {
            shiftAndUpdate(largest, num, 2);
        } else if (largest[1] == Integer.MIN_VALUE || largest[1] < num) {
            shiftAndUpdate(largest, num, 1);
        } else if (largest[0] == Integer.MIN_VALUE || largest[0] < num) {
            shiftAndUpdate(largest, num, 0);
        }
    }

    private void shiftAndUpdate(int[] largest, int num, int index) {
        for (int i = 0; i < index; i++) {
            largest[i] = largest[i + 1];
        }
        largest[index] = num;
    }

    // Prescribed by algoexpert
//    private void shiftAndUpdate(int[] largest, int num, int index) {
//        for (int i = 0; i <= index; i++) {
//            if (i == index) {
//                largest[i] = num;
//            } else {
//                largest[i] = largest[i + 1];
//            }
//        }
//    }



    public static void main(String[] args) {
        ThreeLargestNumber threeLargestNumber = new ThreeLargestNumber();
        int[] array = new int[]{141, 1, 17, -7, -17, -27, 18, 541, 8, 7, 7};
        int [] largest= threeLargestNumber.findThreeLargestNumber(array);
        System.out.format("The Three largest numbers are : %d , %d , %d ",largest[0],largest[1],largest[2]);
    }

}
