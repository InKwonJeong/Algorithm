package baekjoon.stage.minimumspanningtree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class MinimumSpanningTree {

    private static int[] parents;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        parents = new int[n + 1];
        for(int i = 1; i <= n; i++)
            parents[i] = i;

        List<Node> list = new ArrayList<>();
        while (m --> 0) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int distance = Integer.parseInt(st.nextToken());
            list.add(new Node(start, end, distance));
        }

        list.sort(Comparator.comparingInt(o -> o.distance));
        int answer = 0;
        for(Node node : list) {
            int node1 = node.start;
            int node2 = node.end;
            int distance = node.distance;

            int p1 = find(node1);
            int p2 = find(node2);

            if(p1 != p2) {
                union(p1, p2);
                answer += distance;
            }
        }

        System.out.println(answer);
    }

    private static int find(int node) {
        int parent = parents[node];
        if(parent == node)
            return node;

        parents[node] = find(parent);
        return parents[node];
    }

    private static void union(int node1, int node2) {
        int p1 = find(node1);
        int p2 = find(node2);

        if(p1 != p2)
            parents[p1] = p2;
    }

    static class Node {
        int start, end, distance;

        public Node(int start, int end, int distance) {
            this.start = start;
            this.end = end;
            this.distance = distance;
        }
    }
}
