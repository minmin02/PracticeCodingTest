package org.example.dfsbfs;

import org.example.stackqueue.Problem;

import java.util.Scanner;

public class D005SubsetDfs implements Problem {
    static int n;
    static int[] ch;

    public void dfs(int l) {
        if (l == n + 1) {
            StringBuilder tmp = new StringBuilder();
            for (int i = 1; i <= n; i++) {
                if (ch[i] == 1) {
                    tmp.append(i).append(' ');
                }
            }
            if (!tmp.isEmpty()) {
                System.out.println(tmp);
            }
        } else {
            ch[l] = 1;
            dfs(l + 1);
            ch[l] = 0;
            dfs(l + 1);
        }
    }

    @Override
    public void run() {
        Scanner kb = new Scanner(System.in);
        n = kb.nextInt();
        ch = new int[n + 1];
        dfs(1);
    }

    public static void main(String[] args) {
        new D005SubsetDfs().run();
    }
}
