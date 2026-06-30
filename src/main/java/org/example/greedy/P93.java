package org.example.greedy;

import org.example.stackqueue.Problem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;


public class P93 implements Problem {
    static int[]unf; // 인덱스==사람 번호 값==집합번호

    public static int Find(int v){
        if(v==unf[v])return v;
        else return unf[v]=Find(unf[v]); // unf[v]에 저장하면서 (최신화) 압축 시킬 수 있음
        // [f(2)][f(3)][f(4)][4] ->[4][4][4][4]
    }

    public static void Union(int a,int b){
        int fa=Find(a);
        int fb=Find(b);
        if(fa!=fb) unf[fa]=fb; // 친구인걸 나타내는 집합
    }


    @Override
    public void run() {
        Scanner kb = new Scanner(System.in);
        int n=kb.nextInt();
        int m=kb.nextInt();
        unf=new int[n+1];
        for(int i=1; i<=n; i++) unf[i]=i;
        for(int i=1; i<=m; i++){
            int a=kb.nextInt();
            int b=kb.nextInt();
            Union(a, b);
        }
        int a=kb.nextInt();
        int b=kb.nextInt();
        int fa=Find(a);
        int fb=Find(b);
        if(fa==fb) System.out.println("YES");
        else System.out.println("NO");
    }

    public static void main(String[] args) {
        new P93().run();
    }
}