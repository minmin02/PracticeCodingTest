package org.example.dfsbfs;

import org.example.stackqueue.Problem;

import java.util.Scanner;

public class D012MaxScore implements Problem {
    static int answer;
    static int n;
    static int m;

    public void dfs(int l, int sum, int time, int[] ps, int[] pt) {
        if (time > m) return;
        if (l == n) {
            answer = Math.max(sum, answer);
        } else {
            dfs(l + 1, sum + ps[l], time + pt[l], ps, pt);
            dfs(l + 1, sum, time, ps, pt);
        }
    }

    @Override
    public void run() {
        Scanner kb = new Scanner(System.in);
        n = kb.nextInt();
        m = kb.nextInt();
        answer = Integer.MIN_VALUE;

        int[] a = new int[n];
        int[] b = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = kb.nextInt();
            b[i] = kb.nextInt();
        }

        dfs(0, 0, 0, a, b);
        System.out.println(answer);
    }

    public static void main(String[] args) {
        new D012MaxScore().run();
    }
}
