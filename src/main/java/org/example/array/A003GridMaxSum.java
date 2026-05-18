package org.example.array;

import org.example.stackqueue.Problem;

import java.util.Scanner;

public class A003GridMaxSum implements Problem {
    public int solution(int n, int[][] q) {
        int maxX = 0;
        int maxY = 0;

        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = 0; j < n; j++) {
                sum += q[i][j];
            }
            if (sum > maxX) {
                maxX = sum;
            }
        }

        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = 0; j < n; j++) {
                sum += q[j][i];
            }
            if (sum > maxY) {
                maxY = sum;
            }
        }

        int caseSide1 = 0;
        int caseSide2 = 0;
        for (int i = 0; i < n; i++) {
            caseSide1 += q[i][i];
            caseSide2 += q[i][n - 1 - i];
        }

        int max = Math.max(maxX, maxY);
        int max2 = Math.max(caseSide1, caseSide2);
        return Math.max(max, max2);
    }

    @Override
    public void run() {
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int[][] q = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                q[i][j] = kb.nextInt();
            }
        }

        System.out.println(solution(n, q));
    }

    public static void main(String[] args) {
        new A003GridMaxSum().run();
    }
}
