package programmers.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TheFarthestNode {
    public static void main(String[] args) {
        int n = 6;
        int[][] edge = {{3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}};
        System.out.println(new TheFarthestNode().solution(n, edge));
    }

    public int solution(int n, int[][] edge) {
        int answer = 0;
        int[] visit = new int[n + 1];
        List<Integer>[] graph = new List[n + 1];

        for(int i = 1; i <= n; i++)
            graph[i] = new ArrayList<>();

        for (int[] e : edge) {
            int x = e[0];
            int y = e[1];
            graph[x].add(y);
            graph[y].add(x);
        }

        int max = 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);
        visit[1] = 1;
        while (!queue.isEmpty()) {
            int node = queue.poll();
            for(int next : graph[node]) {
                if(visit[next] == 0) {
                    visit[next] = visit[node] + 1;
                    if(max < visit[next])
                        max = visit[next];
                    queue.offer(next);
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            if (max == visit[i] || visit[i] == 0)
                answer++;
        }

        return answer;
    }
}
