package org.example.dfsbfs;

import org.example.stackqueue.Problem;

import java.util.Scanner;

public class D011EqualSubsetSum implements Problem {
    static String answer = "NO";
    static int n;
    static int total;
    boolean flag;

    public void dfs(int l, int sum, int[] arr) {
        if (flag) return;
        if (sum > total / 2) return;

        if (l == n) {
            if (total - sum == sum) {
                answer = "YES";
                flag = true;
            }
        } else {
            dfs(l + 1, sum + arr[l], arr);
            dfs(l + 1, sum, arr);
        }
    }

    @Override
    public void run() {
        Scanner kb = new Scanner(System.in);
        n = kb.nextInt();
        int[] arr = new int[n];
        total = 0;
        answer = "NO";
        flag = false;

        for (int i = 0; i < n; i++) {
            arr[i] = kb.nextInt();
            total += arr[i];
        }
        dfs(0, 0, arr);
        System.out.println(answer);
    }

    public static void main(String[] args) {
        new D011EqualSubsetSum().run();
    }
}
