package org.example.DFS_BFS;

import org.example.stackqueue.Problem;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Points{
    public int x,y;
    Points(int x,int y){
        this.x=x;
        this.y=y;
    }
}

//메모이제이
public class P83 implements Problem {
    static int[] dx={-1,0,1,0};
    static int[]dy={0,1,0,-1};
    static int[][]board,dis;
    static int answer=0;

    public void BFS(int x,int y){
        Queue<Points> q=new LinkedList<>();
        q.offer(new Points(x,y));
        board[x][y]=1;
        while(!q.isEmpty()){
            Points tmp=q.poll();
            for(int i=0; i<4; i++){
                int nx=tmp.x+dx[i];// 현재 좌표에서 이동
                int ny=tmp.y+dy[i];
                if(nx>=1&&nx<=7&&ny>=1&&ny<=7&&board[nx][ny]==0){
                    board[nx][ny]=1;
                    q.offer(new Points(nx,ny));
                    dis[nx][ny]=dis[tmp.x][tmp.y]+1; // 최단거리 길이 구하기위함

                }
            }
        }


    }



    @Override
    public void run() {
        Scanner kb = new Scanner(System.in);
        board=new int[8][8];
        for(int i=1; i<=7; i++){
            for(int j=1; j<=7; j++){
                board[i][j]=kb.nextInt();
            }
        }
        BFS(1,1);
        if(dis[7][7]==0) System.out.println(-1);


        System.out.println(answer);
    }

    public static void main(String[] args) {
        new P83().run();
    }

}
