package org.example.DFS_BFS;

import org.example.stackqueue.Problem;

import java.util.Scanner;

//부분집합의 합
class Point{
    int point;
    int min;
    public Point(int point, int min){
        this.point=point;
        this.min=min;
    }
    public int getPoint(){
        return point;
    }
    public int getMin(){
        return min;
    }
}

public class P75 implements Problem {
    static int answer=Integer.MIN_VALUE,total,n;

    public void DFS(int L,int sumPoint,int sumMin,Point[]arr){
        if(sumMin>total)return;
        if(L==n)answer=Math.max(answer,sumPoint);
        else{
            DFS(L+1,sumPoint+arr[L].getPoint(),sumMin+arr[L].getMin(),arr);
            DFS(L+1,sumPoint,sumMin,arr);
        }
    }


    @Override
    public void run() {
        Scanner kb = new Scanner(System.in);
        n=kb.nextInt();
        total=kb.nextInt();
        Point[] arr=new Point[n];
        for(int i=0; i<n; i++){
            int point= kb.nextInt();
            int min= kb.nextInt();
            arr[i]=new Point(point,min);
        }
        DFS(0,0,0,arr);
        System.out.println(answer);
    }

    public static void main(String[] args) {
        new P75().run();
    }

}
