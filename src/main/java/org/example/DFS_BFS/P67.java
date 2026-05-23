package org.example.DFS_BFS;

import org.example.stackqueue.Problem;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class P67 implements Problem {
    static int n,m,answer=0;
    static int[][]graph;
    static int[]ch;
    public void DFS(int v){
        if(v==n)answer++;
        else{
            for(int i=1; i<=n; i++){
                if(graph[v][i]==1 && ch[i]==0){//v정점에서 i 정점까지 이동 갈 수 있다면 1
                    ch[i]=1;
                    DFS(i);
                    ch[i]=0; // 재귀 될 때 백트래킹
                }
            }
        }
    }


    @Override
    public void run() {
        Scanner kb = new Scanner(System.in);
        n=kb.nextInt(); // 노드 개수
        m=kb.nextInt();// 간석 개수
        graph=new int[n+1][n+1]; // 인접 행렬 1->2 정점번호를 나타냄
        ch=new int[n+1];
        for(int i=0; i<m; i++){
            int a=kb.nextInt();
            int b=kb.nextInt();
            graph[a][b]=1;
        }
        ch[1]=1; //1번 노드 체크
        DFS(1);
        System.out.println(answer);
    }

    public static void main(String[] args) {
        new P67().run();
    }

}
