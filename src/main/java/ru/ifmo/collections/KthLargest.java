package ru.ifmo.collections;

import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;

/**
 * Design a class to find the kth largest element in a stream. k is from 1 to numbers.length.
 * Note that it is the kth largest element in the sorted order, not the kth distinct element.
 * <p>
 * Constructor accepts an integer k and an integer array numbers, which contains initial elements from the stream.
 * For each call to the method KthLargest.add(), return the element representing the kth largest element in the stream.
 */
public class KthLargest {
    private TreeMap<Integer, Integer> map = new TreeMap<>();
    private int k;

    public KthLargest(int k, int[] numbers) {
        this.k = k;
        for (int a : numbers) {
            map.put(a, 1);
        }
    }

    public int add(int val) {
        Integer prevCount = map.get(val);
        map.put(val, prevCount == null ? 1 : prevCount + 1);
        int result = val;

        NavigableMap<Integer, Integer> reverse = map.descendingMap();
        int elementRemaining = k;
        boolean isFinding = false;

        for (Map.Entry<Integer, Integer> entry : reverse.entrySet()) {
            for (int i = 0; i < entry.getValue() && !isFinding; ++i) {
                if (--elementRemaining == 0) {
                    result = entry.getKey();
                    isFinding = true;
                }
            }
        }
        return result;
    }
}