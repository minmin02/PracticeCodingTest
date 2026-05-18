package org.example.dfsbfs;

import org.example.stackqueue.Problem;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class D013CoinChangeDfs implements Problem {
    static int n;
    static int m;
    static int answer;

    public void dfs(int l, int sum, Integer[] arr) {
        if (sum > m) return;
        if (l >= answer) return;
        if (sum == m) {
            answer = Math.min(l, answer);
        } else {
            for (int i = 0; i < n; i++) {
                dfs(l + 1, sum + arr[i], arr);
            }
        }
    }

    @Override
    public void run() {
        Scanner kb = new Scanner(System.in);
        n = kb.nextInt();
        Integer[] arr = new Integer[n];
        for (int i = 0; i < n; i++) {
            arr[i] = kb.nextInt();
        }
        Arrays.sort(arr, Collections.reverseOrder());
        m = kb.nextInt();
        answer = Integer.MAX_VALUE;
        dfs(0, 0, arr);
        System.out.println(answer);
    }

    public static void main(String[] args) {
        new D013CoinChangeDfs().run();
    }
}
