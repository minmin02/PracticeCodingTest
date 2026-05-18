package org.example.stackqueue;

import java.util.Scanner;
import java.util.Stack;

public class P003PostfixEvaluation implements Problem {
    public int solution(String str) {
        Stack<Integer> stack = new Stack<>();

        for (char x : str.toCharArray()) {
            if (Character.isDigit(x)) {
                stack.push(x - '0');
            } else {
                int rt = stack.pop();
                int lt = stack.pop();

                if (x == '+') {
                    stack.push(lt + rt);
                } else if (x == '-') {
                    stack.push(lt - rt);
                } else if (x == '*') {
                    stack.push(lt * rt);
                } else if (x == '/') {
                    stack.push(lt / rt);
                }
            }
        }

        return stack.peek();
    }

    @Override
    public void run() {
        Scanner kb = new Scanner(System.in);
        String str = kb.next();
        System.out.println(solution(str));
    }

    public static void main(String[] args) {
        new P003PostfixEvaluation().run();
    }
}
