package org.example.dfsbfs;

import org.example.stackqueue.Problem;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class D007CalfBfs implements Problem {
    int[] dis = {1, -1, 5};
    int[] ch;

    public int bfs(int s, int e) {
        Queue<Integer> q = new LinkedList<>();
        ch = new int[10001];
        ch[s] = 1;
        q.offer(s);
        int l = 0;

        while (!q.isEmpty()) {
            int len = q.size();
            for (int i = 0; i < len; i++) {
                int x = q.poll();
                if (x == e) return l;
                for (int j = 0; j < 3; j++) {
                    int nx = x + dis[j];
                    if (nx >= 1 && nx <= 10000 && ch[nx] == 0) {
                        ch[nx] = 1;
                        q.offer(nx);
                    }
                }
            }
            l++;
        }
        return 0;
    }

    @Override
    public void run() {
        Scanner kb = new Scanner(System.in);
        int s = kb.nextInt();
        int e = kb.nextInt();
        System.out.println(bfs(s, e));
    }

    public static void main(String[] args) {
        new D007CalfBfs().run();
    }
}
