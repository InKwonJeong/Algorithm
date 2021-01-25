package baekjoon.stage.shortestpath;

import java.util.*;

public class Party {

    private static final int INF = 987654321;
    private static int n;
    private static List<Node>[] paths;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        n = input.nextInt();
        int m = input.nextInt();
        int x = input.nextInt();

        paths = new List[n + 1];
        for(int i = 1; i <= n; i++)
            paths[i] = new ArrayList<>();

        while (m --> 0) {
            int a = input.nextInt();
            int b = input.nextInt();
            int cost = input.nextInt();

            paths[a].add(new Node(b, cost));
        }

        int max = 0;
        for(int i = 1; i <= n; i++) {
            int distance = dijkstra(i, x) + dijkstra(x, i);
            if(max < distance)
                max = distance;
        }
        System.out.println(max);
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
            visit[node.index] = true;

            for(Node next : paths[node.index]) {
                if(distance[next.index] > distance[node.index] + next.cost) {
                    distance[next.index] = distance[node.index] + next.cost;
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
