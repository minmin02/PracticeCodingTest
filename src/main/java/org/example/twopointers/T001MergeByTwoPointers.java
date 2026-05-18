package org.example.twopointers;

import org.example.stackqueue.Problem;

import java.util.ArrayList;
import java.util.Scanner;

public class T001MergeByTwoPointers implements Problem {
    public ArrayList<Integer> solution(int n, int m, int[] a, int[] b) {
        ArrayList<Integer> answer = new ArrayList<>();
        int p1 = 0;
        int p2 = 0;

        while (p1 < n && p2 < m) {
            if (a[p1] > b[p2]) {
                answer.add(a[p1++]);
            } else {
                answer.add(b[p2++]);
            }
        }

        while (p1 < n) answer.add(a[p1++]);
        while (p2 < m) answer.add(b[p2++]);
        return answer;
    }

    @Override
    public void run() {
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = kb.nextInt();

        int m = kb.nextInt();
        int[] b = new int[m];
        for (int i = 0; i < m; i++) b[i] = kb.nextInt();

        for (int x : solution(n, m, a, b)) {
            System.out.print(x + " ");
        }
    }

    public static void main(String[] args) {
        new T001MergeByTwoPointers().run();
    }
}
