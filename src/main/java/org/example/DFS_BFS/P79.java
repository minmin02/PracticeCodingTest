package org.example.DFS_BFS;

import org.example.stackqueue.Problem;

import java.util.Scanner;

//메모이제이션
public class P79 implements Problem {

    int[][]dy=new int[35][35];
    public int DFS(int n,int r){
        if(dy[n][r]>0)return dy[n][r]; // 굳이 뻣지 않게끔 이미 적재되어있는지 확인
        if(n==r || r==0)return 1;
        else return dy[n][r]=DFS(n-1,r-1)+DFS(n-1,r-2);
    }

    @Override
    public void run() {
        Scanner kb = new Scanner(System.in);
        int n=kb.nextInt();
        int r=kb.nextInt();
        System.out.println(DFS(n,r));

    }

    public static void main(String[] args) {
        new P79().run();
    }

}
