package org.example.DFS_BFS;

import org.example.stackqueue.Problem;

import java.util.Scanner;
//부분집합의 합
public class P74 implements Problem {
    static int answer=Integer.MIN_VALUE,c,n;

    public void DFS(int L,int[]arr,int sum){
        if(sum>c)return;
        if(L==n){
            answer=Math.max(answer,sum);
        }else{
            DFS(L+1,arr,sum+arr[L]); // 재귀 다 돌고 다음 D(15)
            DFS(L+1,arr,sum); // 재귀 다 돌고
        }
    }


    @Override
    public void run() {
        Scanner kb = new Scanner(System.in);
        c=kb.nextInt();
        n=kb.nextInt();


        int[]arr=new int[n];
        for(int i=0; i<n; i++){
            arr[i]=kb.nextInt();
        }
        DFS(0,arr,0);

        System.out.println(answer);
    }

    public static void main(String[] args) {
        new P74().run();
    }

}
