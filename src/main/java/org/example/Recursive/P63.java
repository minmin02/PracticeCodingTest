package org.example.Recursive;

import org.example.stackqueue.Problem;

import java.util.Scanner;

//팩토리얼
public class P63 implements Problem {
    static int n;
    static int[]ch;
    public void DFS(int L){
        if(L==n+1){
            String tmp="";
            for(int i=1; i<=n; i++){
                if(ch[i]==1)tmp+=(i+" ");
                if(tmp.length()>0) System.out.println(tmp);
            }
        }else{
            ch[L]=1;
            DFS(L+1);
            ch[L]=0;
            DFS(L+1);

        }
    }


    @Override
    public void run() {
        Scanner kb = new Scanner(System.in);
        n=3;
        ch=new int[n+1];
        DFS(1);
    }

    public static void main(String[] args) {
        new P63().run();
    }

}
