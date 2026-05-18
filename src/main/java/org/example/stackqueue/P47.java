package org.example.stackqueue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Person{
    int id;
    int priority;
    public Person(int id,int priority){
        this.id=id;
        this.priority=priority;
    }

}

public class P47 implements Problem {

    public int solution(int n,int m,int[]arr) {
        int answer=0;
        Queue<Person>Q=new LinkedList<>();
        for(int i=0; i<n; i++){
            Q.add(new Person(i,arr[i]));
        }

        while(!Q.isEmpty()){
            Person tmp=Q.poll();
            for(Person x:Q){
                if(x.priority>tmp.priority){
                    Q.add(tmp);
                    tmp=null;
                    break;
                }
            }
            if(tmp!=null){
                answer++;
                if(tmp.id==m)return answer;
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
        for(int i=0; i<n; i++){
            arr[i]=kb.nextInt();
        }
        System.out.println(solution(n,m,arr));

    }

    public static void main(String[] args) {
        new P47().run();
    }

}
