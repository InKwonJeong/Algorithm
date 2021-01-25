package baekjoon.stage.shortestpath;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class FindMinimumCost {

    private static final int INF = 987654321;
    private static int n;
    private static List<Node>[] paths;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        paths = new List[n + 1];
        for(int i = 1; i <= n; i++) {
            paths[i] = new ArrayList<>();
        }

        for(int i = 1; i <= m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            paths[a].add(new Node(b, cost));
        }

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());
        System.out.println(dijkstra(start, end));
    }

    private static int dijkstra(int start, int end) {
        int[] distance = new int[n + 1];
        Arrays.fill(distance, INF);
        boolean[] visit = new boolean[n + 1];

        PriorityQueue<Node> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(o -> o.cost));

        distance[start] = 0;
        priorityQueue.add(new Node(start, 0));

        while (!priorityQueue.isEmpty()) {
            Node node = priorityQueue.poll();

            if(visit[node.index]) continue;
            visit[node.index] = false;

            for(Node next : paths[node.index]) {
                if(distance[next.index] > next.cost + node.cost) {
                    distance[next.index] = next.cost + node.cost;
                    priorityQueue.add(new Node(next.index, distance[next.index]));
                }
            }
        }

        return distance[end];
    }

    static class Node {
        int index, cost;

        public Node(int index, int cost) {
            this.index = index;
            this.cost = cost;
        }
    }
}
