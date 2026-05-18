package org.example.dfsbfs;

import org.example.stackqueue.Problem;

import java.util.Scanner;

public class D001RecursiveCallStack implements Problem {
    public void dfs(int n) {
        if (n == 0) {
            return;
        }
        dfs(n - 1);
        System.out.print(n + " ");
    }

    @Override
    public void run() {
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        dfs(n);
    }

    public static void main(String[] args) {
        new D001RecursiveCallStack().run();
    }
}
