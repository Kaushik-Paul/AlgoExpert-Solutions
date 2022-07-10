package io.algoexpert;

import java.util.*;

public class Graphs {
    public LinkedHashMap<Integer, List<Integer>> map = new LinkedHashMap<>();

    public void addVertex(int vertex) {
        map.put(vertex, new ArrayList<Integer>());
    }

    public void addEdge(int source, int destination) {
        if (!map.containsKey(source)) {
            addVertex(source);
        }
        if (!map.containsKey(destination)) {
            addVertex(destination);
        }
        if (!map.get(source).contains(destination)) {
            map.get(source).add(destination);
        }
    }
}
