package baekjoon.bdfs;

import java.util.*;

public class BipartiteGraph {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int t = input.nextInt();
        while (t > 0) {
            int k = input.nextInt();
            int v = input.nextInt();
            List<Integer>[] graph = new ArrayList[k + 1];
            boolean[] visit = new boolean[k + 1];
            boolean[] check = new boolean[k + 1];
            boolean answer = true;

            for(int i = 1; i <= k; i++) {
                graph[i] = new ArrayList<>();
            }

            for (int i = 0; i < v; i++) {
                int a = input.nextInt();
                int b = input.nextInt();
                graph[a].add(b);
                graph[b].add(a);
            }

            Queue<Integer> queue = new LinkedList<>();
            for (int n = 1; n <= k; n++) {
                if(!answer)
                    break;

                if (!visit[n]) {
                    visit[n] = true;
                    queue.offer(n);
                    while (!queue.isEmpty()) {
                        int p = queue.poll();
                        for (int i : graph[p]) {
                            if (!visit[i]) {
                                check[i] = !check[p];
                                visit[i] = true;
                                queue.offer(i);
                            } else {
                                if (check[p] == check[i]) {
                                    answer = false;
                                    break;
                                }
                            }
                        }
                    }
                }
            }

            if(answer)
                System.out.println("YES");
            else
                System.out.println("NO");

            t--;
        }
    }
}
