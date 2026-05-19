package org.example.sort;

import org.example.stackqueue.Problem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

//중복 확인
public class P53 implements Problem {

    public  ArrayList<Integer>solution(int[]arr,int n) {

        ArrayList<Integer> answer=new ArrayList<>();

        int[]tmp=arr.clone(); //깊은 복사
        Arrays.sort(tmp); // 정렬 시켜서 다른 값 있는 인덱스 뽑기

        for(int i=0; i<n; i++){
            if(arr[i]!=tmp[i])answer.add(i+1);
        }
        return answer;
    }

    @Override
    public void run() {
        Scanner kb = new Scanner(System.in);
        int n=kb.nextInt();
        int[]arr=new int[n];
        for(int i=0; i<n; i++)arr[i]=kb.nextInt();
        for(int x: solution(arr,n)) System.out.println(x+" ");
    }

    public static void main(String[] args) {
        new P53().run();
    }

}
