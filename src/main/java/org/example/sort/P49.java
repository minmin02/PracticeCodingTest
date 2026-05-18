package org.example.sort;

import org.example.stackqueue.Problem;

import java.util.Scanner;


public class P49 implements Problem {
//버블정렬
    public int[] solution(int n, int[]arr) {

        for(int i=0; i<n; i++){
            if(arr[i]>arr[i+1]){
                int tmp=arr[i];
                arr[i]=arr[i+1];
                arr[i+1]=tmp;
            }
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
        new P49().run();
    }

}
