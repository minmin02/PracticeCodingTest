package org.example.stackqueue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class PCrain implements Problem {

    static int board[][];
    static int move[];


    public int solution(int n,int m){
        Stack<Integer>s=new Stack<>();
        int answer=0;
        int startCol=move[0]-1;
        for(int i=0; i<n; i++){
            if(board[i][startCol]!=0){
                s.push(board[i][startCol]);
                board[i][startCol] = 0;
                break;
            }
        }

        for(int i=1; i<m; i++){
            int col=move[i]-1;//col 인덱스

                for(int j=0; j<n; j++){

                    if(board[j][col]!=0){
                        int target=board[j][col];
                        board[j][col] = 0;


                        while(true){

                            if(s.isEmpty()){
                                s.push(target);
                                break;
                            }

                            if(target!=s.peek()){
                                s.push(target);
                                break;
                            }else{ // 겹치는게 있을 때
                                s.pop();
                                answer+=2;
                                break;
                            }
                        }

                       break;
                    }
                }
        }

        return answer;
    }

    @Override
    public void run() {
        Scanner kb = new Scanner(System.in);
        int n=kb.nextInt();
        board=new int[n][n];
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                board[i][j]=kb.nextInt();
            }
        }
        int m=kb.nextInt();
        move=new int[m];
        for(int i=0; i<m; i++){
            move[i]=kb.nextInt();
        }

        System.out.println(solution(n,m));

    }

    public static void main(String[] args) {
        new PCrain().run();
    }

}
