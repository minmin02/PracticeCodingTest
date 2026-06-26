package org.example.stackqueue;

import java.util.Scanner;
import java.util.Stack;

public class PCrainA implements Problem {

    static int board[][];
    static int move[];


    public int solution(int n,int m){
        Stack<Integer>s=new Stack<>();
        int answer=0;

        for(int pos:move){
            for(int i=0; i<board.length; i++){
                if(board[i][pos-1]!=0){
                    int tmp=board[i][pos-1];
                    board[i][pos-1]=0;
                    if(!s.isEmpty()&&tmp==s.peek()){
                        answer+=2;
                        s.pop();
                    }else{
                        s.push(tmp);
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
        new PCrainA().run();
    }

}
