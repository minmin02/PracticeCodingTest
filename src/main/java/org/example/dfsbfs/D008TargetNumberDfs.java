package org.example.dfsbfs;

import org.example.stackqueue.Problem;

import java.util.Scanner;

public class D008TargetNumberDfs implements Problem {
    static int answer;

    public void dfs(int[] numbers, int target, int currentIndex, int currentSum) {
        if (currentIndex == numbers.length) {
            if (currentSum == target) {
                answer++;
            }
            return;
        }
        dfs(numbers, target, currentIndex + 1, currentSum + numbers[currentIndex]);
        dfs(numbers, target, currentIndex + 1, currentSum - numbers[currentIndex]);
    }

    public int solution(int[] numbers, int target) {
        answer = 0;
        dfs(numbers, target, 0, 0);
        return answer;
    }

    @Override
    public void run() {
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int[] numbers = new int[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = kb.nextInt();
        }
        int target = kb.nextInt();
        System.out.println(solution(numbers, target));
    }

    public static void main(String[] args) {
        new D008TargetNumberDfs().run();
    }
}
