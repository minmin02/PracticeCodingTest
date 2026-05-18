package org.example.hash;

import org.example.stackqueue.Problem;

import java.util.HashMap;
import java.util.Scanner;

public class H001ClassPresident implements Problem {
    public char solution(int n, String s) {
        char answer = ' ';
        HashMap<Character, Integer> map = new HashMap<>();

        for (char x : s.toCharArray()) {
            map.put(x, map.getOrDefault(x, 0) + 1);
        }

        int max = Integer.MIN_VALUE;
        for (char key : map.keySet()) {
            if (map.get(key) > max) {
                max = map.get(key);
                answer = key;
            }
        }

        return answer;
    }

    @Override
    public void run() {
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        String str = kb.next();
        System.out.println(solution(n, str));
    }

    public static void main(String[] args) {
        new H001ClassPresident().run();
    }
}
