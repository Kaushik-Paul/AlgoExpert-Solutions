package io.algoexpert.easy;

import io.algoexpert.Graphs;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.ListIterator;

public class DepthFirstSearch {

    public List<Integer> DFS(Graphs graphs) {
        List<Integer> s = new ArrayList<>();
        List<Integer> listKeys = new ArrayList<>(graphs.map.keySet());
        DFSUtil(s,listKeys.get(0),graphs.map);
        return s;
    }

    private void DFSUtil(List<Integer> s, int num, LinkedHashMap<Integer, List<Integer>> map) {
        s.add(num);
        if (!map.get(num).isEmpty()) {
            ListIterator<Integer> iterator = map.get(num).listIterator();
            while (iterator.hasNext()) {
                DFSUtil(s, iterator.next(), map);
            }
        }
    }


    public static void main(String[] args) {
        Graphs graphs = new Graphs();
        graphs.addEdge(1,2);
        graphs.addEdge(1,3);
        graphs.addEdge(1, 4);
        graphs.addEdge(2,5);
        graphs.addEdge(2, 6);
        graphs.addEdge(4,7);
        graphs.addEdge(4,8);
        graphs.addEdge(6,9);
        graphs.addEdge(6,10);
        graphs.addEdge(7,11);
        DepthFirstSearch dfs = new DepthFirstSearch();

        List<Integer> s = dfs.DFS(graphs);
        s.forEach((st) -> System.out.print(st + " , "));
    }
}
