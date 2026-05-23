package org.example.DFS_BFS;

import org.example.stackqueue.Problem;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class P66 implements Problem {
    Node root;
    public int BFS(Node root) {
        Queue<Node>Q=new LinkedList<>();
        Q.offer(root);
        int L=0; // 레벨
        while(!Q.isEmpty()){
            int len=Q.size();
            for(int i=0; i<len; i++){
                Node cur=Q.poll();
                if(cur.lt==null && cur.rt==null)return L;

                if(cur.lt!=null)Q.offer(cur.lt);
                if(cur.rt!=null)Q.offer(cur.rt);
            }
            L++;
        }
        return 0;
    }




    @Override
    public void run() {
        Scanner kb = new Scanner(System.in);
        root=new Node(1);
        root.lt=new Node(2);
        root.rt=new Node(3);
        root.lt.lt=new Node(4);
        root.lt.rt=new Node(5);
        System.out.println(BFS(root));
    }

    public static void main(String[] args) {
        new P66().run();
    }

}
