package baekjoon.stage.minimumspanningtree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class CitySegmentationPlan {

    private static int[] parents;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
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
        int max = 0;
        while (!priorityQueue.isEmpty()) {
            Path path = priorityQueue.poll();
            int p1 = find(path.a);
            int p2 = find(path.b);

            if(p1 == p2) continue;
            union(p1, p2);
            cost += path.cost;
            if(max < path.cost)
                max = path.cost;
        }

        System.out.println(cost - max);
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
        int a, b, cost;

        public Path(int a, int b, int cost) {
            this.a = a;
            this.b = b;
            this.cost = cost;
        }
    }
}
