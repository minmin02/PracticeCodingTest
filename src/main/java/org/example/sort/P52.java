package org.example.sort;

import org.example.stackqueue.Problem;

import java.util.Scanner;

//중복 확인
public class P52 implements Problem {

    public char solution(int[]arr,int n) {
        char answer='U';
        int index=1;
        while(index<n){
            for(int i=0; i<index; i++) {
                if(arr[index]==arr[i])return 'D';
            }
            index++;
        }


        return answer;
    }

    @Override
    public void run() {
        Scanner kb = new Scanner(System.in);
        int n=kb.nextInt();
        int[]arr=new int[n];

        for(int i=0; i<n; i++){
            arr[i]=kb.nextInt();
        }
        System.out.println(solution(arr,n));


    }

    public static void main(String[] args) {
        new P52().run();
    }

}
