package org.example.sort;

import org.example.stackqueue.Problem;

import java.util.Scanner;


public class P50 implements Problem {
//삽입정렬
    public int[] solution(int n, int[]arr) {

        for(int i=1; i<n; i++){
            int tmp=arr[i],j; // 비교 기준값
            for(j=i-1; j>=0; j--){
                if(arr[j]>tmp)arr[j+1]=arr[j]; //뒤로
                else break;
            }
            arr[j+1]=tmp;
        }


        return arr;
    }

    @Override
    public void run() {
        Scanner kb = new Scanner(System.in);
        int n=kb.nextInt();
        int[]arr=new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = kb.nextInt();
        }
        for(int x:solution(n,arr)) System.out.println(x+" ");
    }

    public static void main(String[] args) {
        new P50().run();
    }

}
