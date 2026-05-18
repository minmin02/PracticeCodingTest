package org.example.dfsbfs;

import org.example.stackqueue.Problem;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class D010GraphShortestBfs implements Problem {
    static int n = 6;
    static int[][] edges = {{1, 2}, {1, 3}, {2, 4}, {3, 4}, {4, 5}, {5, 6}};
    static List<List<Integer>> graph = new ArrayList<>();
    static int[] dist;

    static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        dist[start] = 0;
        queue.offer(start);

        while (!queue.isEmpty()) {
            int current = queue.poll();
            for (int next : graph.get(current)) {
                if (dist[next] == -1) {
                    dist[next] = dist[current] + 1;
                    queue.offer(next);
                }
            }
        }
    }

    @Override
    public void run() {
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
        }

        dist = new int[n + 1];
        for (int i = 0; i <= n; i++) dist[i] = -1;
        bfs(1);

        for (int i = 2; i <= n; i++) {
            System.out.println(i + " : " + dist[i]);
        }
    }

    public static void main(String[] args) {
        new D010GraphShortestBfs().run();
    }
}
