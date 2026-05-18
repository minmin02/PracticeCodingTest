package org.example.dfsbfs;

import org.example.stackqueue.Problem;

import java.util.Scanner;

public class D002BinaryPrintRecursive implements Problem {
    public void dfs(int n) {
        if (n == 0) {
            return;
        }
        dfs(n / 2);
        System.out.print(n % 2);
    }

    @Override
    public void run() {
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        if (n == 0) {
            System.out.println(0);
            return;
        }
        dfs(n);
    }

    public static void main(String[] args) {
        new D002BinaryPrintRecursive().run();
    }
}
