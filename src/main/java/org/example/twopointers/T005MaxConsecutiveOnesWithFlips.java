package org.example.twopointers;

import org.example.stackqueue.Problem;

import java.util.Scanner;

public class T005MaxConsecutiveOnesWithFlips implements Problem {
    public int solution(int n, int k, int[] arr) {
        int answer = 0;
        int cnt = 0;
        int lt = 0;

        for (int rt = 0; rt < n; rt++) {
            if (arr[rt] == 0) cnt++;
            while (cnt > k) {
                if (arr[lt] == 0) cnt--;
                lt++;
            }
            answer = Math.max(answer, rt - lt + 1);
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
        new T005MaxConsecutiveOnesWithFlips().run();
    }
}
