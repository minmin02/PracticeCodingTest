package org.example.dfsbfs;

import org.example.stackqueue.Problem;

import java.util.Scanner;

public class D003Factorial implements Problem {
    public int dfs(int n) {
        if (n == 1) {
            return 1;
        }
        return n * dfs(n - 1);
    }

    @Override
    public void run() {
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        System.out.println(dfs(n));
    }

    public static void main(String[] args) {
        new D003Factorial().run();
    }
}
