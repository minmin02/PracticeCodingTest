package org.example.DFS_BFS;

import org.example.stackqueue.Problem;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//메모이제이
public class P85 implements Problem {

    // 대각선은 8방향으로
    static int dRow[] = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int dCol[] = {0, 1, 1, 1, 0, -1, -1, -1};

    static int answer=0;
    static int n;

    public void DFS(int [][]board, int row,int col){

        // 예외처리
        if (row < 0 || row >= n || col < 0 || col >= n) {
            return;
        }
        if (board[row][col] == 0) {
            return;
        }

        board[row][col] = 0;

            for(int i=0; i<8; i++){
                DFS(board,row+dRow[i],col+dCol[i]);
            }

    }



    @Override
    public void run() {
        Scanner kb = new Scanner(System.in);
        n=kb.nextInt();

        int[][]boards=new int[n][n];

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                boards[i][j]=kb.nextInt();
            }
        }

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(boards[i][j]==1){
                    DFS(boards,i,j);
                    answer++;
                }
            }

        }

        System.out.println(answer);
    }

    public static void main(String[] args) {
        new P85().run();
    }

}
