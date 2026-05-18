package org.example.stackqueue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class P46 implements Problem {
    public String solution(String ncs,String str) {
        String answer = "NO";
        Queue<Character>q=new LinkedList<>();
        char[]ncss=ncs.toCharArray();
        for(int i=0; i<ncs.length(); i++){
            q.offer(ncss[i]);
        }
        char strr[]=str.toCharArray();

        for(int i=0; i<str.length(); i++){
            if(!q.isEmpty()&&strr[i]==q.peek())q.poll();
        }

        if(q.isEmpty())answer="YES";

        return answer;
    }

    @Override
    public void run() {
        Scanner kb = new Scanner(System.in);
        String ncs=kb.next();
        String str = kb.next();
        System.out.println(solution(ncs,str));
    }

    public static void main(String[] args) {
        new P46().run();
    }

}
