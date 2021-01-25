package baekjoon.stage.minimumspanningtree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class NetworkConnection {

    private static int[] parents;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        parents = new int[n + 1];
        for(int i = 1; i <= n; i++)
            parents[i] = i;

        PriorityQueue<Path> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(o -> o.cost));
        while (m --> 0) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            priorityQueue.add(new Path(a, b, cost));
        }

        int cost = 0;
        while (!priorityQueue.isEmpty()) {
            Path path = priorityQueue.poll();
            int a = path.start;
            int b = path.end;
            int p1 = find(a);
            int p2 = find(b);

            if(p1 == p2) continue;
            union(p1, p2);
            cost += path.cost;
        }

        System.out.println(cost);
    }

    private static int find(int node) {
        int parent = parents[node];
        if(parent == node) return node;

        parents[node] = find(parent);
        return parents[node];
    }

    private static void union(int n1, int n2) {
        int p1 = find(n1);
        int p2 = find(n2);
        if(p1 != p2)
            parents[p1] = p2;
    }

    static class Path {
        int start, end, cost;

        public Path(int start, int end, int cost) {
            this.start = start;
            this.end = end;
            this.cost = cost;
        }
    }
}
