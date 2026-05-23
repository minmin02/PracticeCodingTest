package org.example.DFS_BFS;

import org.example.stackqueue.Problem;

import java.util.LinkedList;
import java.util.Queue;


public class P64 implements Problem {



    Node root;
    public void BFS(Node root){
        Queue<Node>Q=new LinkedList<>();
        Q.offer(root);
        int L=0; //레벨
        while(!Q.isEmpty()){
            int len=Q.size();
            System.out.println(L+" : ");
            // 해당 레벨에서 원소 출력
            for(int i=0; i<len; i++){
                Node cur=Q.poll();
                System.out.println(cur.data);
                if(cur.lt!=null)Q.offer(cur.lt);// 연결된 자식이 있으면
                if(cur.rt!=null)Q.offer(cur.rt);
            }
            L++;
            System.out.println();
        }
    }

    @Override
    public void run() {
        root=new Node(1);
        root.lt=new Node(2);
        root.rt=new Node(3);
        root.lt.lt=new Node(4);
        root.lt.rt=new Node(5);
        root.rt.lt=new Node(6);
        root.rt.rt=new Node(7);

    }

    public static void main(String[] args) {
        new P62().run();
    }

}
