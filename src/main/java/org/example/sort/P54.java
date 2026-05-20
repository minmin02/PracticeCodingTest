package org.example.sort;
import org.example.stackqueue.Problem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class Point implements Comparable<Point> {
    public int x, y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int compareTo(Point o) {
        if (this.x == o.x) return this.y - o.y;
        else return this.x - o.x;
    }

}

//중복 확인
public class P54 implements Problem {

    public void solution(int[][]arr,int n) {

    }

    @Override
    public void run() {
        Scanner kb = new Scanner(System.in);
        int n=kb.nextInt();
        ArrayList<Point>arr=new ArrayList<>();

        for(int i=0; i<n; i++){
            int x=kb.nextInt();
            int y=kb.nextInt();
            arr.add(new Point(x,y));
        }

        Collections.sort(arr);//정렬 // sort 호출 시 Comparable구현체 확인 후
        // 정렬 우선순위 잡음
        for(Point o:arr) System.out.println(o.x+" "+o.y);
    }

    public static void main(String[] args) {
        new P54().run();
    }

}
