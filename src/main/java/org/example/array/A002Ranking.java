package org.example.array;

import org.example.stackqueue.Problem;

import java.util.Scanner;

public class A002Ranking implements Problem {
    public int[] solution(int n, int[] q) {
        int[] answer = new int[n];
        for (int i = 0; i < n; i++) {
            int cnt = 1;
            for (int j = 0; j < n; j++) {
                if (q[j] > q[i]) {
                    cnt++;
                }
            }
            answer[i] = cnt;
        }
        return answer;
    }

    @Override
    public void run() {
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int[] q = new int[n];

        for (int i = 0; i < n; i++) {
            q[i] = kb.nextInt();
        }

        int[] answer = solution(n, q);
        for (int i = 0; i < n; i++) {
            System.out.print(answer[i] + " ");
        }
    }

    public static void main(String[] args) {
        new A002Ranking().run();
    }
}
