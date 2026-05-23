package org.example.DFS_BFS;

import org.example.stackqueue.Problem;

import java.util.Scanner;

//이분 검색
public class P59 implements Problem {

    public void DFS(int n) {
        if(n==0)return;
        else{

          DFS(n/2);
            System.out.println(n+" ");// 호출 시점 찍어보면서
        }

    }

    @Override
    public void run() {
        Scanner kb = new Scanner(System.in);
        int n=kb.nextInt();
        DFS(n);
    }

    public static void main(String[] args) {
        new P59().run();
    }

}
