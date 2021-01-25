package programmers.summerwintercoding2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Delivery {
    public static void main(String[] args) {
        int[] N = {5, 6};
        int[][][] road = {
                {{1, 2, 1}, {2, 3, 3}, {5, 2, 2}, {1, 4, 2}, {5, 3, 1}, {5, 4, 2}},
                {{1, 2, 1}, {1, 3, 2}, {2, 3, 2}, {3, 4, 3}, {3, 5, 2}, {3, 5, 3}, {5, 6, 1}}
        };
        int[] K = {3, 4};
        for(int i = 0; i < N.length; i++)
            System.out.println(new Delivery().solution(N[i], road[i], K[i]));
    }

    private int K;
    private List<Edge>[] edges;
    private int[] cost;

    public int solution(int N, int[][] road, int K) {
        int answer = 0;
        cost = new int[N + 1];
        edges = new List[N + 1];
        for(int i = 1; i <= N; i++) {
            edges[i] = new ArrayList<>();
            cost[i] = Integer.MAX_VALUE;
        }

        for(int[] r : road) {
            edges[r[0]].add(new Edge(r[1], r[2]));
            edges[r[1]].add(new Edge(r[0], r[2]));
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);
        cost[1] = 0;
        while (!queue.isEmpty()) {
            int node = queue.poll();

            for(Edge edge : edges[node]) {
                if(cost[node] + edge.cost <= K && cost[node] + edge.cost < cost[edge.num]) {
                    cost[edge.num] = cost[node] + edge.cost;
                    queue.offer(edge.num);
                }
            }
        }

        for(int i = 1; i <= N; i++) {
            if(cost[i] <= K)
                answer++;
        }

        return answer;
    }

    static class Edge {
        int num, cost;

        public Edge(int num, int cost) {
            this.num = num;
            this.cost = cost;
        }
    }
}
