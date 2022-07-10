package io.algoexpert.medium;

import io.algoexpert.Graphs;

import java.util.*;

public class BreadthFirstSearch {

    public List<Integer> BFS(Graphs graphs) {
        List<Integer> s = new ArrayList<>();
        BFSUtil(graphs.map, s);
        return s;
    }

    private void BFSUtil(LinkedHashMap<Integer, List<Integer>> map, List<Integer> s) {
        Queue<Integer> queue = new LinkedList<>();
        List<Integer> listKeys = new ArrayList<>(map.keySet());
        queue.add(listKeys.get(0));
        int current;
        while (!queue.isEmpty()) {
            current= queue.remove();
            s.add(current);

//            Iterator<Integer> iterator = map.get(current).iterator();
//            while (iterator.hasNext()) {
//                queue.add(iterator.next());
//            }
            map.get(current).forEach(st -> queue.add(st));
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
        BreadthFirstSearch bfs = new BreadthFirstSearch();
        List<Integer> s = new ArrayList<>();
        s = bfs.BFS(graphs);
        s.forEach((st) -> System.out.print(st + " -> "));
        System.out.println("NULL");
    }
}
