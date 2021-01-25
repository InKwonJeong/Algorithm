package programmers.graph;

import java.util.LinkedList;
import java.util.Queue;

public class Ranking {
    public static void main(String[] args) {
        int n = 5;
        int[][] results = {{4, 3}, {4, 2}, {3, 2}, {1, 2}, {2, 5}};
        System.out.println(new Ranking().solution(n, results));
    }

    public int solution(int n, int[][] results) {
        int answer = 0;
        int[][] graph = new int[n + 1][n + 1];
        for(int[] result : results) {
            int winner = result[0];
            int loser = result[1];
            graph[winner][loser] = 1;
            graph[loser][winner] = -1;
        }

        Queue<Integer> wins = new LinkedList<>();
        Queue<Integer> loses = new LinkedList<>();

        for(int i = 1; i <= n; i++) {
            boolean finish = true;
            boolean[] visit = new boolean[n + 1];
            wins.offer(i);
            loses.offer(i);
            visit[i] = true;
            while (!wins.isEmpty()) {
                int player = wins.poll();
                for(int j = 1; j <= n; j++) {
                    if(!visit[j] && graph[player][j] == 1) {
                        visit[j] = true;
                        wins.offer(j);
                    }
                }
            }

            while (!loses.isEmpty()) {
                int player = loses.poll();
                for(int j = 1; j <= n; j++) {
                    if(!visit[j] && graph[player][j] == -1) {
                        visit[j] = true;
                        loses.offer(j);
                    }
                }
            }

            for (int k = 1; k <= n; k++) {
                if (!visit[k]) {
                    finish = false;
                    break;
                }
            }

            if(finish)
                answer++;

        }
        return answer;
    }
}
