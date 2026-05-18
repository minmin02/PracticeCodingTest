package org.example.twopointers;

import org.example.stackqueue.Problem;

import java.util.Scanner;

public class T004CountSubsequenceSum implements Problem {
    public int solution(int n, int m, int[] arr) {
        int answer = 0;
        int sum = 0;
        int lt = 0;

        for (int rt = 0; rt < n; rt++) {
            sum += arr[rt];
            while (sum > m) {
                sum -= arr[lt++];
            }
            if (sum == m) {
                answer++;
            }
        }

        return answer;
    }

    @Override
    public void run() {
        Scanner kb = new Scanner(System.in);

        int n = kb.nextInt();
        int m = kb.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = kb.nextInt();

        System.out.println(solution(n, m, arr));
    }

    public static void main(String[] args) {
        new T004CountSubsequenceSum().run();
    }
}
