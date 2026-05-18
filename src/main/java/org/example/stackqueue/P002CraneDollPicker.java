package org.example.stackqueue;

import java.util.Scanner;
import java.util.Stack;

public class P002CraneDollPicker implements Problem {
    public int solution(int n, int moveN, int[][] board, int[] moves) {
        Stack<Integer> stack = new Stack<>();
        int[] currentY = new int[n];
        int answer = 0;

        for (int i = 0; i < moveN; i++) {
            int col = moves[i] - 1;
            int compareDoll = stack.isEmpty() ? -1 : stack.peek();
            boolean pushed = false;

            if (currentY[col] < n && board[currentY[col]][col] != 0) {
                stack.push(board[currentY[col]][col]);
                currentY[col]++;
                pushed = true;
            } else {
                while (currentY[col] < n && board[currentY[col]][col] == 0) {
                    currentY[col]++;
                }
                if (currentY[col] < n) {
                    stack.push(board[currentY[col]][col]);
                    currentY[col]++;
                    pushed = true;
                }
            }

            if (pushed && stack.size() >= 2 && stack.peek() == compareDoll) {
                stack.pop();
                stack.pop();
                answer += 2;
            }
        }

        return answer;
    }

    @Override
    public void run() {
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int[][] board = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = kb.nextInt();
            }
        }

        int moveN = kb.nextInt();
        int[] moves = new int[moveN];
        for (int i = 0; i < moveN; i++) {
            moves[i] = kb.nextInt();
        }

        System.out.println(solution(n, moveN, board, moves));
    }

    public static void main(String[] args) {
        new P002CraneDollPicker().run();
    }
}
