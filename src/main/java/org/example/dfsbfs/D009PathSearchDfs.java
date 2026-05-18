package org.example.dfsbfs;

import org.example.stackqueue.Problem;

import java.util.Scanner;

public class D009PathSearchDfs implements Problem {
    static int n;
    static int m;
    static int answer;
    static int[][] graph;
    static int[] ch;

    public void dfs(int v) {
        if (v == n) {
            answer++;
        } else {
            for (int i = 1; i <= n; i++) {
                if (graph[v][i] == 1 && ch[i] == 0) {
                    ch[i] = 1;
                    dfs(i);
                    ch[i] = 0;
                }
            }
        }
    }

    @Override
    public void run() {
        Scanner kb = new Scanner(System.in);
        n = kb.nextInt();
        m = kb.nextInt();
        answer = 0;
        graph = new int[n + 1][n + 1];
        ch = new int[n + 1];

        for (int i = 0; i < m; i++) {
            int a = kb.nextInt();
            int b = kb.nextInt();
            graph[a][b] = 1;
        }
        ch[1] = 1;
        dfs(1);
        System.out.println(answer);
    }

    public static void main(String[] args) {
        new D009PathSearchDfs().run();
    }
}
