package org.example.greedy;

import org.example.stackqueue.Problem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;


class Lecture implements Comparable<Lecture>{
    public int pay;
    public int limit;

    Lecture(int pay, int limit){
        this.pay=pay;
        this.limit=limit;
    }

    @Override
    public int compareTo(Lecture o) {

        return o.limit-this.limit; // 내림차순
    }
}

// 끝시간을 가지고 정렬하면 최대 회의수가 될 수 밖에 없음 -> 그 뒤로 이어지는 시간대로 진행
public class P91 implements Problem {
    int max=Integer.MIN_VALUE;
    int n;

    public int solution(ArrayList<Lecture>arr){
        int answer=0;
        // 기본형은 작은형을 우선순위로 뽑아옴 , reverseOrder()는 큰 값을 우선순위로 뽑아옴
        PriorityQueue<Integer>pQ=new PriorityQueue<>(Collections.reverseOrder());
        Collections.sort(arr); // 내림차순
        int j=0;
        // 3일째부터 카운트
        for(int i=max; i>=1; i--){
            for(; j<n; j++){
                if(arr.get(j).limit<i)break; // 기간내 못 뽑아옴
                pQ.offer(arr.get(j).pay);
            }
            if(!pQ.isEmpty())answer+=pQ.poll();// 우선순위 큐에서 reverseOrder()를 했기 때문에 큐에 있는것중 제일 큰 페이를 더함
        }


        return answer;
    }

    @Override
    public void run() {
        Scanner kb = new Scanner(System.in);
        n = kb.nextInt();

        ArrayList<Lecture> arr = new ArrayList<Lecture>(); // Body를 Time으로 수정

        for(int i=0; i<n; i++){
            int pay = kb.nextInt();
            int limit = kb.nextInt();
            arr.add(new Lecture(pay, limit));
            if(limit>max)max=limit; //기간중에 최대 구하기
        }

        System.out.println(solution(arr));
    }

    public static void main(String[] args) {
        new P91().run();
    }
}