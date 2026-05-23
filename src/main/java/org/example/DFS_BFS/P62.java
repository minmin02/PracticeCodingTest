package org.example.DFS_BFS;

import org.example.stackqueue.Problem;

//이진트리순회
class Node{
    int data;
    Node lt,rt;
    public Node(int val){
        data=val;
        lt=rt=null;
    }
}

public class P62 implements Problem {

    Node root;
    public void DFS(Node root){
        if(root==null)return;
        else{
            // 전위 순회
            System.out.println(root.data+" ");
            DFS(root.lt);
            DFS(root.rt);
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
