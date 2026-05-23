package org.example.DFS_BFS;

import org.example.stackqueue.Problem;

import java.util.Scanner;

//이분 검색
public class P58 implements Problem {

    public void DFS(int n) {
        if(n==0)return;
        else{
            DFS(n-1);
            System.out.println(n+" ");
        }

    }

    @Override
    public void run() {
        Scanner kb = new Scanner(System.in);
        int n=kb.nextInt();
        DFS(n);
    }

    public static void main(String[] args) {
        new P58().run();
    }

}
