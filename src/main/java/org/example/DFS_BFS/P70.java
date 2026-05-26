package org.example.DFS_BFS;

import org.example.stackqueue.Problem;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class P70 implements Problem {
    static int n,m;
    static ArrayList<ArrayList<Integer>>graph;
    static int[]ch,dis;
    public void BFS(int v){
        Queue<Integer> queue=new LinkedList<>();
        ch[v]=1;// 체크 배열
        dis[v]=0; // 시작점
        queue.offer(v);

        while(!queue.isEmpty()){
            int cv=queue.poll();
            for(int nv:graph.get(cv)){ //nv는 cv로 갈 수 있는 정점 graph(cv,[nv...])
                if(ch[nv]==0){
                    ch[nv]=1; // nv 방문한 노드
                    queue.offer(nv);
                    dis[nv]=dis[cv]+1; //nv는 cv를 타고 들어감
                }
            }
        }


    }



    @Override
    public void run() {
        Scanner kb = new Scanner(System.in);
        n=kb.nextInt();
        m=kb.nextInt();
        graph=new ArrayList<ArrayList<Integer>>();
        for(int i=0; i<=n; i++){
            graph.add(new ArrayList<>());
        }

        ch=new int[n+1];
        dis=new int[n+1];
        for(int i=0; i<m; i++) {
           int a=kb.nextInt();
           int b=kb.nextInt();
           graph.get(a).add(b);
        }
        BFS(1);
        for(int i=2; i<=n; i++){
            System.out.println(i+" "+dis[i]); //1번부터 i번 노드까지 최단거리
        }




    }

    public static void main(String[] args) {
        new P70().run();
    }

}
