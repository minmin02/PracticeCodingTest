package org.example.greedy;

import org.example.stackqueue.Problem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

// 끝시간을 가지고 정렬하면 최대 회의수가 될 수 밖에 없음 -> 그 뒤로 이어지는 시간대로 진행
public class P89 implements Problem {

    public int solution(ArrayList<Time> arr, int n) {
        int cnt = 0;
        Collections.sort(arr);
        int et = 0; // 끝나는 시간을 저장할 변수

        for(Time ob : arr){
            if(ob.start >= et){
                cnt++;
                et = ob.end;
            }
        }

        return cnt;
    }

    @Override
    public void run() {
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        ArrayList<Time> arr = new ArrayList<Time>(); // Body를 Time으로 수정

        for(int i=0; i<n; i++){
            int start = kb.nextInt();
            int end = kb.nextInt();
            arr.add(new Time(start, end));
        }
        System.out.println(solution(arr, n));
    }

    public static void main(String[] args) {
        new P89().run();
    }
}