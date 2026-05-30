package org.example.DFS_BFS;

import org.example.stackqueue.Problem;

import java.util.Scanner;

//메모이제이션
public class P80 implements Problem {

    static int[]b,p,ch;
    static int n,f;
    boolean flag=false;
    int[][]dy=new int[35][35];

    public int combi(int n,int r){
        if(dy[n][r]>0)return dy[n][r];

        if(n==r||r==0)return 1;

        else return dy[n][r]=combi(n-1,r-1)+combi(n-1,r);
    }

    public void DFS(int L,int sum){
        if(L==n){
            if(sum==f){
                for(int x : p) System.out.println(x+" ");
                flag=true;
            }
        }else{
            for(int i=1; i<=n; i++){
                if(ch[i]==0){ // 안들어간 수를 넣어봄
                    ch[i]=1;
                    p[L]=i;
                    DFS(L+1,sum+(p[L]*b[L]));
                    ch[i]=0;
                }
            }
        }
    }

    @Override
    public void run() {
        Scanner kb = new Scanner(System.in);
        n=kb.nextInt(); // 4
        f=kb.nextInt(); //16
        b=new int[n];
        p=new int[n];
        ch=new int[n];
        ch=new int[n+1]; // 1 2 3 4 실제값이 돌아야함
        for(int i=0; i<n; i++){
            b[i]=combi(n-1,i); // C 넣기
        }
        DFS(0,0);

    }

    public static void main(String[] args) {
        new P80().run();
    }

}
