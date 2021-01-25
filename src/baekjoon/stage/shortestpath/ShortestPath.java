package baekjoon.stage.shortestpath;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class ShortestPath {
    static final int INF = 987654321;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder builder = new StringBuilder();

        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int k = Integer.parseInt(st.nextToken());

        List<Path>[] paths = new List[v + 1];
        for (int i = 1; i <= v; i++)
            paths[i] = new ArrayList<>();

        for (int i = 1; i <= e; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            paths[u].add(new Path(d, w));
        }

        int[] dist = new int[v + 1];
        for(int i = 1; i <= v; i++)
            dist[i] = INF;

        boolean[] visit = new boolean[v + 1];
        PriorityQueue<Node> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o.weight));
        queue.add(new Node(k, 0));
        dist[k] = 0;

        while (!queue.isEmpty()) {
            Node node = queue.poll();

            if(visit[node.n]) continue;
            visit[node.n] = true;

            for (Path path : paths[node.n]) {
                if(dist[path.dest] > dist[node.n] + path.weight) {
                    dist[path.dest] = dist[node.n] + path.weight;
                    queue.offer(new Node(path.dest, dist[path.dest]));
                }
            }
        }

        for (int i = 1; i <= v; i++) {
            if (dist[i] == INF)
                builder.append("INF").append("\n");
            else
                builder.append(dist[i]).append("\n");
        }

        System.out.println(builder);
    }

    static class Node {
        int n, weight;

        public Node(int node, int weight) {
            this.n = node;
            this.weight = weight;
        }
    }

    static class Path {
        int dest, weight;

        public Path(int dest, int weight) {
            this.dest = dest;
            this.weight = weight;
        }
    }
}
