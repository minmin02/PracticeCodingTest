package org.example.DFS_BFS;

import org.example.stackqueue.Problem;

import java.util.Scanner;

//부분집합의 합
public class P76 implements Problem {
    static int[]pm;
    static int n,m;
    public void DFS(int L){
        if(L==m){
            for(int x:pm) System.out.println(x + " ");
            System.out.println();
        }else{
            for(int i=1; i<=n; i++){
                pm[L]=i;
                DFS(L+1);
            }
        }
    }


    @Override
    public void run() {
        Scanner kb = new Scanner(System.in);
        n=kb.nextInt();
        m=kb.nextInt();
        pm=new int[m];
        DFS(0);

    }

    public static void main(String[] args) {
        new P76().run();
    }

}
