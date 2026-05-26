package org.example.DFS_BFS;

import org.example.stackqueue.Problem;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class P73 implements Problem {
    static String answer="NO";
    boolean flag=false;
    static int n,total=0;

    public void DFS(int L,int sum,int[]arr){
        if(flag)return; // 플레그가 true일 때 stop

        if(L==n){
            if((total-sum)==sum){
                answer="YES";
                flag=true;
            }
        }else{
            DFS(L+1,sum+arr[L],arr); //L을 인덱스로 두고 sum 누적
            DFS(L+1,sum,arr);
        }

    }



    @Override
    public void run() {
        Scanner kb = new Scanner(System.in);
        int n=kb.nextInt();
        int[]arr=new int[n];
        for(int i=0; i<n; i++){
            arr[i]=kb.nextInt();
            total+=arr[i];
        }
        DFS(0,0,arr);
        System.out.println(answer);
    }

    public static void main(String[] args) {
        new P73().run();
    }

}
