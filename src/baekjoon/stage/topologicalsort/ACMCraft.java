package baekjoon.stage.topologicalsort;

import java.util.*;

public class ACMCraft {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int t = input.nextInt();
        while (t --> 0) {
            int n = input.nextInt();
            int m = input.nextInt();
            int[] time = new int[n + 1];
            int[] count = new int[n + 1];
            int[] d = new int[n + 1];
            List<Integer>[] graph = new List[n + 1];
            for(int i = 1; i <= n; i++) {
                time[i] = input.nextInt();
                graph[i] = new ArrayList<>();
            }

            while (m --> 0) {
                int a = input.nextInt();
                int b = input.nextInt();

                graph[a].add(b);
                count[b]++;
            }

            int w = input.nextInt();

            Queue<Integer> queue = new LinkedList<>();
            for(int i = 1; i <= n; i++) {
                if(count[i] == 0) {
                    queue.offer(i);
                    d[i] = time[i];
                }
            }

            while (!queue.isEmpty()) {
                int node = queue.poll();

                for(int other : graph[node]) {
                    count[other]--;
                    d[other] = Math.max(d[other], d[node] + time[other]);

                    if(count[other] == 0) {
                        queue.offer(other);
                    }
                }
            }

            System.out.println(d[w]);
        }
    }
}
