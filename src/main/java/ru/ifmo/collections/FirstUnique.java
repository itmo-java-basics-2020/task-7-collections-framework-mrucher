package ru.ifmo.collections;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Design a class which contains integers and returns first unique integer (in order of addition).
 * FirstUniqueTest can be used as an example.
 */
public class FirstUnique {
    private LinkedHashMap<Integer, Boolean> map = new LinkedHashMap<>();

    public FirstUnique(int[] numbers) {
        for (int i : numbers) {
            this.add(i);
        }
    }

    public int showFirstUnique() {
        for (Map.Entry<Integer, Boolean> entry : map.entrySet()) {
            if (entry.getValue()) {
                return entry.getKey();
            }
        }

        return -1;
    }

    public void add(int value) {
        map.put(value, map.get(value) == null);
    }
}
