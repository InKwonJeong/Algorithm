package baekjoon.stage.tree;

import java.util.*;

public class FindParentOfTree {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        List<Integer>[] paths = new List[n + 1];
        for(int i = 1; i <= n; i++)
            paths[i] = new ArrayList<>();

        for(int i = 1; i < n; i++) {
            int n1 = input.nextInt();
            int n2 = input.nextInt();
            paths[n1].add(n2);
            paths[n2].add(n1);
        }

        int[] parents = new int[n + 1];
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visit = new boolean[n + 1];
        visit[1] = true;
        queue.offer(1);
        while (!queue.isEmpty()) {
            int node = queue.poll();
            for(int path : paths[node]) {
                if(!visit[path]) {
                    visit[path] = true;
                    parents[path] = node;
                    queue.offer(path);
                }
            }
        }

        for(int i = 2; i <= n; i++)
            System.out.println(parents[i]);
    }
}
