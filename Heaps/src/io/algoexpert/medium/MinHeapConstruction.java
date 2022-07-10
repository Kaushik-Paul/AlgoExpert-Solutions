package io.algoexpert.medium;

import java.util.ArrayList;
import java.util.List;

public class MinHeapConstruction {
    private List<Integer> heap;

    public MinHeapConstruction() {
        heap = new ArrayList<>();
    }

        /* If parentNode is i
            Then childOne = 2 * i + 1;
            and childTwo = 2 * i + 2;

        * If childNode is i
            Then parentNode = (i - 1)/2;
        */

    private void swap(int firstIdx, int secondIdx) {
        int firstValue = heap.get(firstIdx);
        int secondValue = heap.get(secondIdx);
        heap.set(firstIdx, secondValue);
        heap.set(secondIdx, firstValue);
    }

    private void shiftUp(int currentIdx) {
        int parentIdx = (currentIdx - 1) / 2;
        while (currentIdx > 0 && heap.get(currentIdx) < heap.get(parentIdx)) {
            swap(parentIdx, currentIdx);
            currentIdx = parentIdx;
            parentIdx = (currentIdx - 1) / 2;
        }
    }

    private void shiftDown(int currentIdx, int endIdx) {
        int childOne = (currentIdx * 2) + 1;
        int valueToSwap;
        int childTwo;
        while (childOne <= endIdx) {
            childTwo = (currentIdx * 2) + 2;
            if (childTwo <= endIdx && heap.get(childTwo) < heap.get(childOne)) {
                valueToSwap = childTwo;
            } else  {
                valueToSwap = childOne;
            }
            if (heap.get(currentIdx) > heap.get(valueToSwap)) {
                swap(currentIdx, valueToSwap);
                currentIdx = valueToSwap;
                childOne = (currentIdx * 2) + 1;
            } else {
                break;
            }
        }
    }

    public void insertion(int value) {
        heap.add(value);
        shiftUp(heap.size() - 1);
    }

    public int delete() {
        swap(0, heap.size() - 1);
        int valueToRemove = heap.remove(heap.size() - 1);
        shiftDown(0, heap.size() - 1);
        return valueToRemove;
    }

    public int peek() {
        return heap.get(0);
    }

    public void builtHeap(int[] array) {
        for (int i : array) {
            heap.add(i);
        }
        int firstParentIndex = (heap.size() - 2) / 2;
        for (int currentIdx = firstParentIndex; currentIdx >= 0; currentIdx--) {
            shiftDown(currentIdx, heap.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] array = new int[]{30, 102, 23, 17, 18, 9, 44, 12, 31};
        MinHeapConstruction minHeapConstruction = new MinHeapConstruction();
        minHeapConstruction.builtHeap(array);
        System.out.println(minHeapConstruction.heap);
        minHeapConstruction.insertion(8);
        minHeapConstruction.insertion(2);
        System.out.println(minHeapConstruction.heap);
        System.out.println(minHeapConstruction.delete());
        System.out.println(minHeapConstruction.delete());
        System.out.println(minHeapConstruction.heap);
    }
}
