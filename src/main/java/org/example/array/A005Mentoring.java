package org.example.array;

import org.example.stackqueue.Problem;

import java.util.Scanner;

public class A005Mentoring implements Problem {
    public int solution(int n, int m, int[][] arr) {
        int answer = 0;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                int cnt = 0;
                for (int k = 0; k < m; k++) {
                    int pi = 0;
                    int pj = 0;
                    for (int s = 0; s < n; s++) {
                        if (arr[k][s] == i) {
                            pi = s;
                        }
                        if (arr[k][s] == j) {
                            pj = s;
                        }
                    }
                    if (pi < pj) {
                        cnt++;
                    }
                }
                if (cnt == m) {
                    answer++;
                }
            }
        }

        return answer;
    }

    @Override
    public void run() {
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int m = kb.nextInt();
        int[][] arr = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = kb.nextInt();
            }
        }

        System.out.println(solution(n, m, arr));
    }

    public static void main(String[] args) {
        new A005Mentoring().run();
    }
}
