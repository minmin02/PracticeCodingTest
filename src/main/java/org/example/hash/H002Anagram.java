package org.example.hash;

import org.example.stackqueue.Problem;

import java.util.HashMap;
import java.util.Scanner;

public class H002Anagram implements Problem {
    public String solution(String a, String b) {
        HashMap<Character, Integer> mapA = new HashMap<>();
        HashMap<Character, Integer> mapB = new HashMap<>();

        for (char x : a.toCharArray()) {
            mapA.put(x, mapA.getOrDefault(x, 0) + 1);
        }

        for (char x : b.toCharArray()) {
            mapB.put(x, mapB.getOrDefault(x, 0) + 1);
        }

        return mapA.equals(mapB) ? "YES" : "NO";
    }

    @Override
    public void run() {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        String b = sc.next();
        System.out.println(solution(a, b));
    }

    public static void main(String[] args) {
        new H002Anagram().run();
    }
}
