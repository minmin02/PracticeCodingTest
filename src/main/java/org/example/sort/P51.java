package org.example.sort;

import org.example.stackqueue.Problem;

import java.util.Arrays;
import java.util.Scanner;

//LRU 카카오 변형문제 : 오답
public class P51 implements Problem {

    public int[] solution(int size,int n,int[]arr) {
        int []cache=new int[size];
        for(int x:arr){
            int pos=-1;
            for(int i=0; i<size; i++){
                if(x==cache[i]) pos=i; //히트된 인덱스 저장
            }
            if(pos==-1){ // 미스된 시점
                for(int i=size-1; i>=1; i--){
                    cache[i]=cache[i-1];
                }
            }else{ // 히트된 인덱스 저장한 pos 이용
                for(int i=pos; i>=1; i--){
                    cache[i]=cache[i-1];
                }
            }
            cache[0]=x;
        }
        return cache;
    }

    @Override
    public void run() {
        Scanner kb = new Scanner(System.in);
        int s=kb.nextInt();
        int n=kb.nextInt();
        int[]arr=new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = kb.nextInt();
        }
        for(int x:solution(s,n,arr)) System.out.println(x+" ");
    }

    public static void main(String[] args) {
        new P51().run();
    }

}
