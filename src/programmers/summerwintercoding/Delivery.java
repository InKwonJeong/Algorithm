package programmers.summerwintercoding;

import java.util.ArrayList;
import java.util.List;

public class Delivery {
    public static void main(String[] args) {
        int[] N = {5, 6};
        int[][][] road = {
                {{1, 2, 1}, {2, 3, 3}, {5, 2, 2}, {1, 4, 2}, {5, 3, 1}, {5, 4, 2}},
                {{1, 2, 1}, {1, 3, 2}, {2, 3, 2}, {3, 4, 3}, {3, 5, 2}, {3, 5, 3}, {5, 6, 1}}
        };
        int[] K = {3, 4};
        for(int i = 0; i < N.length; i++)
            System.out.println(new Delivery().solution(N[i], road[i], K[i]));
    }

    private List<Pair>[] graph;
    private int N, K, answer, destination;
    private boolean[] village, visit;

    public int solution(int N, int[][] road, int K) {
        this.N = N;
        this.K = K;
        answer = 0;
        village = new boolean[N + 1];
        visit = new boolean[N + 1];

        graph = new List[N + 1];
        for(int i = 1; i <= N; i++)
            graph[i] = new ArrayList<>();

        for(int[] r : road) {
            int x = r[0];
            int y = r[1];
            int time = r[2];
            graph[x].add(new Pair(y, time));
            graph[y].add(new Pair(x, time));
        }

        visit[1] = true;
        village[1] = true;
        dfs(1, 0);
        for(boolean v : village)
            if(v)
                answer++;

        return answer;
    }

    private void dfs(int x, int time) {
        for(Pair p : graph[x]) {
            if(!visit[p.d] && time + p.t <= K) {
                village[p.d] = true;
                visit[p.d] = true;
                dfs(p.d, time + p.t);
                visit[p.d] = false;
            }
        }
    }

    static class Pair {
        int d, t;
        Pair(int d, int t) {
            this.d = d;
            this.t = t;
        }
    }
}
