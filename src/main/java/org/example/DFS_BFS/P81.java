package org.example.DFS_BFS;

import org.example.stackqueue.Problem;

import java.util.Scanner;

//메모이제이션
public class P81 implements Problem {

    static int[]combi;//m 만큼 조합 담는 배열
    static int n,m; // 1~n 까지의 수의 m개 조합

    public void DFS(int L,int s){
        if(L==m){
            for(int x : combi) System.out.println(x+" ");
            System.out.println();
        }else{
            for(int i=s; i<=n; i++){
                combi[L]=i; //i 번째 가닥 뽑음
                DFS(L+1,i+1);
            }
        }
    }



    @Override
    public void run() {
        Scanner kb = new Scanner(System.in);
        n=kb.nextInt();
        m=kb.nextInt();
        combi=new int[m];
        DFS(0,1);

    }

    public static void main(String[] args) {
        new P81().run();
    }

}
