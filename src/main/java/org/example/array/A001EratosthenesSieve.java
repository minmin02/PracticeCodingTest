package org.example.array;

import org.example.stackqueue.Problem;

import java.util.Scanner;

public class A001EratosthenesSieve implements Problem {
    public int solution(int n) {
        int answer = 0;
        int[] check = new int[n + 1];

        for (int i = 2; i <= n; i++) {
            if (check[i] == 0) {
                answer++;
                for (int j = i; j <= n; j += i) {
                    check[j] = 1;
                }
            }
        }

        return answer;
    }

    @Override
    public void run() {
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        System.out.println(solution(n));
    }

    public static void main(String[] args) {
        new A001EratosthenesSieve().run();
    }
}
