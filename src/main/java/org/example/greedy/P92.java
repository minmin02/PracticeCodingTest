package org.example.greedy;

import org.example.stackqueue.Problem;

import java.util.*;


class Edge implements Comparable<Edge>{
    public int vex; // 노드번호
    public int cost; // 노드까지의 비용

    Edge(int vex,int cost){
        this.vex=vex;
        this.cost=cost;
    }
    @Override
    public int compareTo(Edge ob){
        return this.cost-ob.cost; // 오름차순
    }
}


public class P92 implements Problem {

    static int n,m;
    static ArrayList<ArrayList<Edge>>graph; // 1-> 2 일 때 -> 2 이 부분을 담은 graph
    // graph에 담을 때 해당 노드와 연결되어 있는 노드들을 담은 ArrayList를 담음
    static int[]dis; // 노드까지 가는 지점의 비용
    public void solution(int v){
        PriorityQueue<Edge>pQ=new PriorityQueue<>(); // sort기준 은 compareTo로 잡음
        pQ.offer(new Edge(v,0)); // 초반
        dis[v]=0;
        while(!pQ.isEmpty()){
            Edge tmp=pQ.poll(); // 처음 1,0이 poll 되어서 나옴
            int now=tmp.vex;
            int nowCost=tmp.cost;

            if(nowCost>dis[now])continue; //

            for(Edge ob:graph.get(now)){ // now 노드와 연결되어 있는 노드들을 꺼내옴
                if(dis[ob.vex]>nowCost+ob.cost){// 지금까지 간 거리비용인 nowCost와 꺼내온 ob.vex까지 간 거리 ob.cost를 더함
                    dis[ob.vex]=nowCost+ob.cost; // 작을경우 비용 최신화
                    pQ.offer(new Edge(ob.vex,nowCost+ob.cost)); // 큐에 넣어서 다시
                }
            }

        }

    }

    @Override
    public void run() {
        Scanner kb=new Scanner(System.in);
        n=kb.nextInt();
        m=kb.nextInt();
        graph=new ArrayList<ArrayList<Edge>>();
        for(int i=0; i<=n; i++){
            graph.add(new ArrayList<Edge>());
        }
        dis=new int[n+1];
        Arrays.fill(dis,Integer.MAX_VALUE);

        for(int i=0; i<m; i++){ // a에서 vex로 가는데 cost다
            int a=kb.nextInt(); // gradh 노드
            int vex=kb.nextInt(); //연결된 노드와 해당 그래프
            int cost=kb.nextInt(); // 연결된 비용
            graph.get(a).add(new Edge(vex,cost));
        }

        solution(1);

        for(int i=2; i<=n; i++){
            if(dis[i]!=Integer.MAX_VALUE) System.out.println(i+":"+dis[i]);
            else System.out.println(i+":impossible");
        }

    }

    public static void main(String[] args) {
        new P92().run();
    }
}