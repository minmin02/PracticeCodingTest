package org.example.DFS_BFS;

import org.example.stackqueue.Problem;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//메모이제이
public class P84_A implements Problem {
    static int[] dRow={-1,0,1,0}; // 좌표가 아니라 행번호로 접근
    static int[]dCol={0,1,0,-1}; // 열번호로 접근
    static int[][]board,dis;

    static int n,m;
    static Queue<Points> q=new LinkedList<>();
    public void BFS(){

        while(!q.isEmpty()){
            Points tmp=q.poll(); // 처음 레벨 0에서 익은 토마토 뽑아옴
            for(int i=0; i<4; i++){
                int nRow=tmp.row+dRow[i];
                int nCol=tmp.col+dCol[i];
                if(nRow>=0&&nRow<n&&nCol>=0&&nCol<m&&board[nRow][nCol]==0){
                    board[nRow][nCol]=1; // 보드 안에서
                    q.offer(new Points(nRow,nCol));
                    dis[nRow][nCol]=dis[tmp.row][tmp.col]+1; // 레벨(며칠 지났는지)
                }
            }
        }
    }



    @Override
    public void run() {
        Scanner kb = new Scanner(System.in);
        m=kb.nextInt();
        n=kb.nextInt();
        board=new int[n][m];
        dis=new int[n][m];

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                board[i][j]=kb.nextInt();
                if(board[i][j]==1){
                    q.offer(new Points(i,j));
                }
            }
        }

        BFS();

        boolean flag=true;
        int answer=Integer.MIN_VALUE;
        for(int i=0; i<n; i++){ // 안익은 토마토가 있음예외처리
            for(int j=0; j<m; j++){
                if(board[i][j]==0)flag=false;
            }
        }

        if(flag){
            for(int i=0; i<n; i++){
                for(int j=0; j<m; j++){
                    answer=Math.max(answer,dis[i][j]);
                }
            }
            System.out.println(answer);
        }else{
            System.out.println(-1);
        }

    }

    public static void main(String[] args) {
        new P84_A().run();
    }

}
