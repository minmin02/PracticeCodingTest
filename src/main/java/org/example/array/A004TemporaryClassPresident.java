package org.example.array;

import org.example.stackqueue.Problem;

import java.util.Scanner;

public class A004TemporaryClassPresident implements Problem {
    public int solution(int n, int[][] q) {
        int answer = 0;
        int max = Integer.MIN_VALUE;

        for (int i = 1; i <= n; i++) {
            int cnt = 0;
            for (int j = 1; j <= n; j++) {
                for (int k = 1; k <= 5; k++) {
                    if (q[i][k] == q[j][k]) {
                        cnt++;
                        break;
                    }
                }
            }
            if (cnt > max) {
                max = cnt;
                answer = i;
            }
        }

        return answer;
    }

    @Override
    public void run() {
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int[][] q = new int[n + 1][6];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= 5; j++) {
                q[i][j] = kb.nextInt();
            }
        }

        System.out.println(solution(n, q));
    }

    public static void main(String[] args) {
        new A004TemporaryClassPresident().run();
    }
}
