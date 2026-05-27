package org.example.DFS_BFS;

import org.example.stackqueue.Problem;

import java.util.Scanner;

//순열
public class P78 implements Problem {

    static int[]pm;
    static int[]ch;
    static int[]arr;
    static int n,m;

    public void DFS(int L){
        if(L==m){
            for(int x:pm) System.out.println(x+" ");
            System.out.println();
        }else{
            for(int i=0; i<n; i++){// n개 정수만큼 뻗어나감
                if(ch[i]==0){ // 해당 단어가 쓰이지 않았을 때
                    pm[L]=arr[i];
                    ch[i]=1; // 쓰였다는 체크
                    DFS(L+1); // 다음 인덱스로 넘어감 , 백트래킹 하는 지점
                    ch[i]=0;
                }
            }
        }
    }

    @Override
    public void run() {
        Scanner kb = new Scanner(System.in);
        n=kb.nextInt();
        m=kb.nextInt();
        arr=new int[n];

        for(int i=0; i<n; i++){
            arr[i]=kb.nextInt();
        }
        ch=new int[n];
        pm=new int[m];
        DFS(0);
    }

    public static void main(String[] args) {
        new P78().run();
    }

}
