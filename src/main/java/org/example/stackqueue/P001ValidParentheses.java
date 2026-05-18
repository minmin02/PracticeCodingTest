package org.example.stackqueue;

import java.util.Scanner;
import java.util.Stack;

public class P001ValidParentheses implements Problem {
    public String solution(String str) {
        Stack<Character> stack = new Stack<>();

        for (char x : str.toCharArray()) {
            if (x == '(') {
                stack.push(x);
            } else {
                if (stack.isEmpty()) {
                    return "NO";
                }
                stack.pop();
            }
        }

        return stack.isEmpty() ? "YES" : "NO";
    }

    @Override
    public void run() {
        Scanner kb = new Scanner(System.in);
        String str = kb.next();
        System.out.println(solution(str));
    }

    public static void main(String[] args) {
        new P001ValidParentheses().run();
    }
}
