package org.example.DFS_BFS;

import org.example.stackqueue.Problem;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//메모이제이
public class P84 implements Problem {
    static int[] dRow={-1,0,1,0}; // 좌표가 아니라 행번호로 접근
    static int[]dCol={0,1,0,-1}; // 열번호로 접근
    static int[][]board,dis;

    static int n,m;
    static Queue<Points> q=new LinkedList<>();

    public void BFS(){


        while(!q.isEmpty()){
            Points tmp=q.poll();

            for(int i=0; i<4; i++){
                int nRow=tmp.row+dRow[i];
                int nCol=tmp.col+dCol[i];

                if(nRow>=1&&nRow<=n&&nCol>=1&nCol<=m&&board[nRow][nCol]==0){
                    board[nRow][nCol]=1;
                    q.offer(new Points(nRow,nCol));
                    dis[nRow][nCol]=dis[tmp.row][tmp.col]+1;
                }
            }
        }

    }



    @Override
    public void run() {
        Scanner kb = new Scanner(System.in);
        m=kb.nextInt();
        n=kb.nextInt();
        board=new int[n+1][m+1];

        dis=new int[n+1][m+1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                board[i][j] = kb.nextInt();
                //입력받을 때 익은 토마토를 발견하면 전부 큐에 먼저 집어넣는다
                if (board[i][j] == 1) {
                    q.offer(new Points(i, j));
                }
            }
        }

        BFS();

        int answer=0;
        boolean flag=true;

        for(int i=1; i<=n; i++){
            for(int j=1; j<=m; j++){
                if(board[i][j]==0){
                    flag=false;
                }
                answer=Math.max(answer,dis[i][j]);
            }
        }

        System.out.println(answer);
    }

    public static void main(String[] args) {
        new P84().run();
    }

}
