package org.example.dfsbfs;

import org.example.stackqueue.Problem;

import java.util.Scanner;

public class D004FibonacciMemo implements Problem {
    static int[] fibo;

    public int dfs(int n) {
        if (fibo[n] > 0) {
            return fibo[n];
        }
        if (n == 1 || n == 2) {
            return fibo[n] = 1;
        }
        return fibo[n] = dfs(n - 2) + dfs(n - 1);
    }

    @Override
    public void run() {
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        fibo = new int[n + 1];
        dfs(n);
        for (int i = 1; i <= n; i++) {
            System.out.print(fibo[i] + " ");
        }
    }

    public static void main(String[] args) {
        new D004FibonacciMemo().run();
    }
}
