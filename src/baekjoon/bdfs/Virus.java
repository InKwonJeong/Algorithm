package baekjoon.bdfs;

import java.util.*;

public class Virus {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int m = input.nextInt();
        boolean[] visit = new boolean[n + 1];

        List<Integer>[] paths = new List[n + 1];
        for(int i = 1; i <= n; i++)
            paths[i] = new ArrayList<>();

        for(int i = 0; i < m; i++) {
            int a = input.nextInt();
            int b = input.nextInt();

            paths[a].add(b);
            paths[b].add(a);
        }

        int answer = 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        visit[1] = true;
        while (!queue.isEmpty()) {
            int computer = queue.poll();
            for(int path : paths[computer]) {
                if(!visit[path]) {
                    answer++;
                    visit[path] = true;
                    queue.offer(path);
                }
            }
        }

        System.out.println(answer);
    }
}
