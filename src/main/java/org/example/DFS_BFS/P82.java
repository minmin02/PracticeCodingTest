package org.example.DFS_BFS;

import org.example.stackqueue.Problem;

import java.util.Scanner;

//메모이제이션
public class P82 implements Problem {
    static int[] dx={-1,0,1,0};
    static int[]dy={0,1,0,-1};
    static int[][]board;
    static int answer=0;

    public void DFS(int x, int y){
        if(x==7 && y==7)answer++;
        else{
            for(int i=0; i<4; i++){
                int nx=x+dx[i];
                int ny=y+dy[i];
                if(nx>=1 && nx<=7 && ny>=1 && ny<=7 && board[nx][ny]==0){
                    board[nx][ny]=1;
                    DFS(nx,ny);
                    board[nx][ny]=0; // 백트래킹 시점
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
        board[1][1]=1;
        DFS(1,1);
        System.out.println(answer);
    }

    public static void main(String[] args) {
        new P82().run();
    }

}
