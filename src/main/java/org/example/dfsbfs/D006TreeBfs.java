package org.example.dfsbfs;

import org.example.stackqueue.Problem;

import java.util.LinkedList;
import java.util.Queue;

public class D006TreeBfs implements Problem {
    static class Node {
        int data;
        Node lt;
        Node rt;

        Node(int val) {
            data = val;
        }
    }

    Node root;

    public void bfs(Node root) {
        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        int l = 0;
        while (!q.isEmpty()) {
            int len = q.size();
            System.out.print(l + ": ");
            for (int i = 0; i < len; i++) {
                Node cur = q.poll();
                System.out.print(cur.data + " ");
                if (cur.lt != null) q.offer(cur.lt);
                if (cur.rt != null) q.offer(cur.rt);
            }
            l++;
            System.out.println();
        }
    }

    @Override
    public void run() {
        root = new Node(1);
        root.lt = new Node(2);
        root.rt = new Node(3);
        root.lt.lt = new Node(4);
        root.lt.rt = new Node(5);
        root.rt.lt = new Node(6);
        root.rt.rt = new Node(7);
        bfs(root);
    }

    public static void main(String[] args) {
        new D006TreeBfs().run();
    }
}
