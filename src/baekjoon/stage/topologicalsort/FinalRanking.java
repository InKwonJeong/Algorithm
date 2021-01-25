package baekjoon.stage.topologicalsort;

import java.util.*;

public class FinalRanking {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int t = input.nextInt();
        while (t --> 0) {
            List<Integer> order = new ArrayList<>();
            int n = input.nextInt();
            int[] rank = new int[n + 1];
            int[] count = new int[n + 1];
            HashSet<Integer>[] graph = new HashSet[n + 1];

            for(int i = 1; i <= n; i++) {
                rank[i] = input.nextInt();
                graph[i] = new HashSet<>();
            }

            for(int i = 1; i < n; i++) {
                for(int j = i + 1; j <= n; j++) {
                    graph[rank[i]].add(rank[j]);
                    count[rank[j]]++;
                }
            }

            int m = input.nextInt();
            while (m --> 0) {
                int a = input.nextInt();
                int b = input.nextInt();

                if(graph[a].contains(b)) {
                    graph[b].add(a);
                    count[a]++;
                    graph[a].remove(b);
                    count[b]--;
                } else {
                    graph[a].add(b);
                    count[b]++;
                    graph[b].remove(a);
                    count[a]--;
                }
            }

            Queue<Integer> queue = new LinkedList<>();
            for(int i = 1; i <= n; i++) {
                if(count[i] == 0)
                    queue.offer(i);
            }

            while (!queue.isEmpty()) {
                if(queue.size() > 1)
                    break;

                int node = queue.poll();
                order.add(node);

                for(int other : graph[node]) {
                    count[other]--;

                    if(count[other] == 0)
                        queue.offer(other);
                }
            }

            if(order.size() == n) {
                for(int node : order)
                    System.out.print(node + " ");
                System.out.println();
            } else {
                System.out.println("IMPOSSIBLE");
            }
        }
    }
}
