package org.example.twopointers;

import org.example.stackqueue.Problem;

import java.util.Scanner;

public class T003MaxWindowSum implements Problem {
    public int solution(int n, int k, int[] arr) {
        int sum = 0;
        for (int i = 0; i < k; i++) sum += arr[i];

        int answer = sum;
        for (int i = k; i < n; i++) {
            sum += arr[i] - arr[i - k];
            answer = Math.max(answer, sum);
        }
        return answer;
    }

    @Override
    public void run() {
        Scanner kb = new Scanner(System.in);

        int n = kb.nextInt();
        int k = kb.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = kb.nextInt();

        System.out.println(solution(n, k, arr));
    }

    public static void main(String[] args) {
        new T003MaxWindowSum().run();
    }
}
