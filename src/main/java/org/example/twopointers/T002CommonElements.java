package org.example.twopointers;

import org.example.stackqueue.Problem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class T002CommonElements implements Problem {
    public ArrayList<Integer> solution(int n, int m, int[] arrA, int[] arrB) {
        ArrayList<Integer> answer = new ArrayList<>();
        Arrays.sort(arrA);
        Arrays.sort(arrB);

        int p1 = 0;
        int p2 = 0;
        while (p1 < n && p2 < m) {
            if (arrA[p1] == arrB[p2]) {
                answer.add(arrA[p1]);
                p1++;
                p2++;
            } else if (arrA[p1] < arrB[p2]) {
                p1++;
            } else {
                p2++;
            }
        }
        return answer;
    }

    @Override
    public void run() {
        Scanner kb = new Scanner(System.in);

        int n = kb.nextInt();
        int[] arrA = new int[n];
        for (int i = 0; i < n; i++) arrA[i] = kb.nextInt();

        int m = kb.nextInt();
        int[] arrB = new int[m];
        for (int i = 0; i < m; i++) arrB[i] = kb.nextInt();

        for (int x : solution(n, m, arrA, arrB)) {
            System.out.print(x + " ");
        }
    }

    public static void main(String[] args) {
        new T002CommonElements().run();
    }
}
