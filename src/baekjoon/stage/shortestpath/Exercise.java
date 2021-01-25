package baekjoon.stage.shortestpath;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Exercise {

    private static final int INF = 987654321;
    private static int v;
    private static List<Node>[] paths;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());

        paths = new List[v + 1];
        for(int i = 1; i <= v; i++)
            paths[i] = new ArrayList<>();

        while (e --> 0) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            paths[a].add(new Node(b, c));
        }

        int answer = INF;
        for(int i = 1; i <= v; i++) {
            int distance = dijkstra(i);
            if(answer > distance)
                answer = distance;
        }

        if(answer == INF)
            System.out.println(-1);
        else
            System.out.println(answer);
    }

    private static int dijkstra(int start) {
        boolean[] visit = new boolean[v + 1];
        int[] distance = new int[v + 1];
        Arrays.fill(distance, INF);

        int sum = INF;

        PriorityQueue<Node> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(o -> o.distance));
        priorityQueue.add(new Node(start, 0));
        distance[start] = 0;
        while (!priorityQueue.isEmpty()) {
            Node node = priorityQueue.poll();

            if(visit[node.index]) continue;
            visit[node.index] = true;

            for(Node path : paths[node.index]) {
                if(path.index == start)
                    sum = Math.min(sum, distance[node.index] + path.distance);

                if(distance[path.index] > distance[node.index] + path.distance) {
                    distance[path.index] = distance[node.index] + path.distance;
                    priorityQueue.add(new Node(path.index, distance[path.index]));
                }
            }
        }

        return sum;
    }

    static class Node {
        int index, distance;

        public Node(int index, int distance) {
            this.index = index;
            this.distance = distance;
        }
    }
}
