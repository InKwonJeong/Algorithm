package programmers.graph;

import java.util.ArrayList;
import java.util.List;

public class CycleRemoval {
    public static void main(String[] args) {
        int n = 8;
        int[][] edges = {{1, 2}, {2, 3}, {3, 4}, {4, 5}, {5, 6}, {6, 7}, {7, 8}, {8, 1}, {2, 7}, {3, 6}};
        System.out.println(new CycleRemoval().solution(n, edges));
    }

    public int solution(int n, int[][] edges) {
        int answer = 0;
        List<Integer>[] graph = new List[n + 1];
        for(int i = 1; i <= n; i++)
            graph[i] = new ArrayList<>();

        for(int[] edge : edges) {
            int x = edge[0];
            int y = edge[1];
            graph[x].add(y);
            graph[y].add(x);
        }

        for(int i = 1; i <= n; i++) {

        }
        return answer;
    }
}
