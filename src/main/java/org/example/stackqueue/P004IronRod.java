package org.example.stackqueue;

import java.util.Scanner;
import java.util.Stack;

public class P004IronRod implements Problem {
    public int solution(String str) {
        int answer = 0;
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(') {
                stack.push('(');
            } else {
                stack.pop();
                if (str.charAt(i - 1) == '(') {
                    answer += stack.size();
                } else {
                    answer++;
                }
            }
        }

        return answer;
    }

    @Override
    public void run() {
        Scanner kb = new Scanner(System.in);
        String str = kb.next();
        System.out.println(solution(str));
    }

    public static void main(String[] args) {
        new P004IronRod().run();
    }
}
