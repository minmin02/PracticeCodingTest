package org.example.stackqueue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class P005RescuePrincess implements Problem {
    public int solution(int n, int k) {
        Queue<Integer> q = new LinkedList<>();

        for (int i = 1; i <= n; i++) {
            q.offer(i);
        }

        while (q.size() != 1) {
            for (int i = 1; i < k; i++) {
                q.offer(q.poll());
            }
            q.poll();
        }

        return q.poll();
    }

    @Override
    public void run() {
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int k = kb.nextInt();
        System.out.println(solution(n, k));
    }

    public static void main(String[] args) {
        new P005RescuePrincess().run();
    }
}
