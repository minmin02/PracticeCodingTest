package org.example.DFS_BFS;

import org.example.stackqueue.Problem;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//메모이제이
public class P85_BFS implements Problem {
    static int dRow[] = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int dCol[] = {0, 1, 1, 1, 0, -1, -1, -1};

    static int[][]board;
    static int answer=0;
    static int n,m;
    static Queue<Points> q=new LinkedList<>();

    public void BFS(){
        while(!q.isEmpty()){
            Points tmp=q.poll();
            board[tmp.row][tmp.col]=0;
            for(int i=0; i<8; i++){
                int nRow=tmp.row+dRow[i];
                int nCol=tmp.col+dCol[i];

                if(nRow>=0 && nRow<n && nCol>=0 && nCol<n && board[nRow][nCol]==1){
                    board[nRow][nCol]=0;
                    q.offer(new Points(nRow, nCol));
                }
            }
        }
    }



    @Override
    public void run() {
        Scanner kb = new Scanner(System.in);
        n=kb.nextInt();
        board = new int[n][n];
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                board[i][j]=kb.nextInt();
            }
        }

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(board[i][j]==1){
                    q.offer(new Points(i, j));
                    BFS();answer++;
                }
            }
        }
        System.out.println(answer);
    }

    public static void main(String[] args) {
        new P85_BFS().run();
    }

}
