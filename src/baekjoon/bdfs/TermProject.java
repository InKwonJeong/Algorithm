package baekjoon.bdfs;

import java.util.*;

public class TermProject {

    static int n;
    static int[] graph;
    static int count = 0;
    static boolean[] visited;
    static boolean[] finished;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int t = input.nextInt();
        while (t > 0) {
            n = input.nextInt();
            graph = new int[n + 1];
            visited = new boolean[n + 1];
            finished = new boolean[n + 1];
            count = 0;

            for (int i = 1; i <= n; i++)
                graph[i] = input.nextInt();

            for (int i = 1; i <= n; i++)
                dfs(i);

            System.out.println(n - count);
            t--;
        }
    }

    private static void dfs(int now) {
        if (visited[now])
            return;

        visited[now] = true;
        int next = graph[now];

        if (!visited[next])
            dfs(next);
        else {
            if (!finished[next]) {
                // 노드가 끝나려면 싸이클을 무조건 거쳐야한다.
                // 따라서 현재 노드가 아닌 다음 노드 기준으로 하면 싸이클이 무조건 존재
                count++;
                for (int i = next; i != now; i = graph[i])
                    count++;
            }
        }

        // 모든 작업이 끝나서 더이상 사용하지 않음
        finished[now] = true;
    }
}
