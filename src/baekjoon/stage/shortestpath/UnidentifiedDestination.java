package baekjoon.stage.shortestpath;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class UnidentifiedDestination {

    private static final int INF = 10000000;
    private static int n;
    private static List<Node>[] paths;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(st.nextToken());
        while (T > 0) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int g = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());

            paths = new List[n + 1];
            for(int i = 1; i <= n; i++)
                paths[i] = new ArrayList<>();

            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int d = Integer.parseInt(st.nextToken());

                paths[a].add(new Node(b, d));
                paths[b].add(new Node(a, d));
            }

            List<Integer> answer = new ArrayList<>();
            for(int i = 0; i < t; i++) {
                st = new StringTokenizer(br.readLine());
                int destination = Integer.parseInt(st.nextToken());
                int d1 = dijkstra(s, g) + dijkstra(g, h) + dijkstra(h, destination);
                int d2 = dijkstra(s, h) + dijkstra(h, g) + dijkstra(g, destination);
                int sd1 = Math.min(d1, d2);
                int sd2 = dijkstra(s, destination);

                if(sd1 == sd2 && sd1 < INF)
                    answer.add(destination);
            }

            Collections.sort(answer);
            for(int a : answer)
                System.out.print(a + " ");
            System.out.println();

            T--;
        }
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

            if (visit[node.index]) continue;
            visit[node.index] = true;

            for (Node path : paths[node.index]) {
                if (distance[path.index] > distance[node.index] + path.distance) {
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
