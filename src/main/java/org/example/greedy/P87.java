package org.example.greedy;

import org.example.stackqueue.Problem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class Body implements Comparable<Body>{
    public int h,w;
    Body(int h,int w){
        this.h=h;
        this.w=w;
    }

    @Override
    public int compareTo(Body o)  {
        return o.h-this.h; // sort 할 때 h가 큰 순서대로
    }
}

public class P87 implements Problem {

    public int solution(ArrayList<Body> arr,int n) {
        int cnt=0;
        Collections.sort(arr);
        int max=Integer.MIN_VALUE;
        for(Body ob: arr){
            if(ob.w>max){
                max=ob.w;
                cnt++;
            }
        }

        return cnt;
    }

    @Override
    public void run() {
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        ArrayList<Body> arr=new ArrayList<Body>();
        for(int i=0; i<n; i++){
            int h=kb.nextInt();
            int w=kb.nextInt();
            arr.add(new Body(h,w));
        }
        System.out.println(solution(arr,n));
    }

    public static void main(String[] args) {
        new P87().run();
    }

}
