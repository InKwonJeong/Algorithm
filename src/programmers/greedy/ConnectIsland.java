package programmers.greedy;

import java.util.ArrayList;
import java.util.List;

public class ConnectIsland {
    public static void main(String[] args) {
        int n = 4;
        int[][] costs = {{0, 1, 1}, {0, 2, 2}, {1, 2, 5}, {1, 3, 1}, {2, 3, 8}};
        System.out.println(new ConnectIsland().solution(n, costs));
    }

    public int solution(int n, int[][] costs) {
        int answer = 0;
        boolean[] visit = new boolean[n];
        int[][] graph = new int[n][n];
        for(int[] cost : costs) {
            graph[cost[0]][cost[1]] = cost[2];
            graph[cost[1]][cost[0]] = cost[2];
        }

        List<Integer> list = new ArrayList<>();
        list.add(0);
        visit[0] = true;
        while (list.size() < n) {
            int min = Integer.MAX_VALUE;
            int index = -1;
            for (int i : list) {
                for (int j = 0; j < n; j++) {
                    if (!visit[j] && graph[i][j] > 0 && graph[i][j] < min) {
                        min = graph[i][j];
                        index = j;
                    }
                }
            }
            answer += min;
            list.add(index);
            visit[index] = true;
        }

        return answer;
    }
}
