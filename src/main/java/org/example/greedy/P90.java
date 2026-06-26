package org.example.greedy;

import org.example.stackqueue.Problem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class Merry implements Comparable<Merry>{
    int time;
    char state;
    Merry(int time, char state) {
        this.time = time;
        this.state = state;
    }

    @Override
    public int compareTo(Merry o){
        if (this.time != o.time) {
            return this.time - o.time; // 오름차순
        }

        return this.state-o.state; // 시간이 같은면 종료가 시작보다 먼저 오도록 정렬
    }

}

public class P90 implements Problem {


    public int solution(ArrayList<Merry>arr,int n){

        int cnt=0;
        int answer=0;
        Collections.sort(arr);


        for(Merry m : arr){
            if(m.state=='S'){
                cnt++;
            }else{
                cnt--;
            }
            answer=Math.max(answer,cnt);
        }
        return answer;
    }

    @Override
    public void run() {
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        ArrayList<Merry> arr = new ArrayList<Merry>(); // Body를 Time으로 수정

        for(int i=0; i<n; i++){
            int start=kb.nextInt();
            int end=kb.nextInt();
            arr.add(new Merry(start,'S'));
            arr.add(new Merry(end,'E'));
        }

        System.out.println(solution(arr,n));
    }


    public static void main(String[] args) {
        new P90().run();
    }
}