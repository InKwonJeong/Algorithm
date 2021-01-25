package baekjoon.stage.shortestpath;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class SpecificShortestPath {

    private static final int INF = 1000000;
    private static int n;
    private static List<Node>[] paths;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());

        paths = new List[n + 1];
        for(int i = 1; i <= n; i++)
            paths[i] = new ArrayList<>();

        for(int i = 1; i <= e; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            paths[a].add(new Node(b, c));
            paths[b].add(new Node(a, c));
        }

        st = new StringTokenizer(br.readLine());
        int v1 = Integer.parseInt(st.nextToken());
        int v2 = Integer.parseInt(st.nextToken());

        int d1 = dijkstra(1, v1) + dijkstra(v1, v2) + dijkstra(v2, n);
        int d2 = dijkstra(1, v2) + dijkstra(v2, v1) + dijkstra(v1, n);
        if(d1 >= INF && d2 >= INF)
            System.out.println(-1);
        else
            System.out.println(Math.min(d1, d2));
    }

    private static int dijkstra(int start, int end) {
        int[] distance = new int[n + 1];
        boolean[] visit = new boolean[n + 1];

        Arrays.fill(distance, INF);

        PriorityQueue<Node> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(o -> o.distance));
        priorityQueue.add(new Node(start, 0));
        distance[start] = 0;

        while (!priorityQueue.isEmpty()) {
            Node node = priorityQueue.poll();

            if(visit[node.index]) continue;
            visit[node.index] = true;

            for(Node path : paths[node.index]) {
                if(distance[path.index] > distance[node.index] + path.distance) {
                    distance[path.index] = distance[node.index] + path.distance;
                    priorityQueue.add(new Node(path.index, distance[path.index]));
                }
            }
        }
        return distance[end];
    }

    static class Node {
        int index, distance;

        public Node(int index, int distance) {
            this.index = index;
            this.distance = distance;
        }
    }
}
