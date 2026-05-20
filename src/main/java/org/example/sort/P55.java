package org.example.sort;

import org.example.stackqueue.Problem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

//이분 검색
public class P55 implements Problem {

    public int solution(int n,int m, int[]arr) {
        int answer=0;
        Arrays.sort(arr);
        int lt=0,rt=n-1;
        while(lt<=rt){
            int mid=(lt+rt)/2;
            if(arr[mid]==m){
                return mid+1;
            }
            if(arr[mid]>m){
                rt=mid-1;
            }else{
                lt=mid+1;
            }
        }
        return answer;
    }

    @Override
    public void run() {
        Scanner kb = new Scanner(System.in);
        int n=kb.nextInt();
        int m=kb.nextInt();
        int[]arr=new int[n];
        for(int i=0; i<n; i++)arr[i]=kb.nextInt();
        System.out.println(solution(n,m,arr));

    }

    public static void main(String[] args) {
        new P55().run();
    }

}
