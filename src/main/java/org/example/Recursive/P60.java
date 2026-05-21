package org.example.Recursive;

import org.example.stackqueue.Problem;

import java.util.Scanner;

//팩토리얼
public class P60 implements Problem {

    public int  DFS(int n) {
        if(n==0)return 1;
        else return n*DFS(n-1);
    }

    @Override
    public void run() {
        Scanner kb = new Scanner(System.in);
        int n=kb.nextInt();
        System.out.println(DFS(n));
    }

    public static void main(String[] args) {
        new P60().run();
    }

}
