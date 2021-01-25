package programmers.kakao;

import java.util.HashSet;

public class GPS {
    public static void main(String[] args) {
        int[] n = {7, 7};
        int[] m = {10, 10};
        int[][][] edge_list = {
                {{1, 2}, {1, 3}, {2, 3}, {2, 4}, {3, 4}, {3, 5}, {4, 6}, {5, 6}, {5, 7}, {6, 7}},
                {{1, 2}, {1, 3}, {2, 3}, {2, 4}, {3, 4}, {3, 5}, {4, 6}, {5, 6}, {5, 7}, {6, 7}}
        };
        int[] k = {6, 6};
        int[][] gps_log = {
                {1, 2, 3, 3, 6, 7},
                {1, 2, 3, 5, 6, 7}
        };
        for (int i = 0; i < n.length; i++)
            System.out.println(new GPS().solution(n[i], m[i], edge_list[i], k[i], gps_log[i]));
    }

    public int solution(int n, int m, int[][] edge_list, int k, int[] gps_log) {
        int answer = Integer.MAX_VALUE / 2;
        int[][] d = new int[k][n + 1];
        for (int i = 0; i < k; i++) {
            for (int j = 1; j <= n; j++)
                d[i][j] = Integer.MAX_VALUE / 2;
        }

        HashSet<Integer>[] graph = new HashSet[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new HashSet<>();
            graph[i].add(i);
        }

        for (int i = 0; i < m; i++) {
            graph[edge_list[i][0]].add(edge_list[i][1]);
            graph[edge_list[i][1]].add(edge_list[i][0]);
        }

        d[0][gps_log[0]] = 0;
        for (int i = 1; i < k - 1; i++) {
            for (int j = 1; j <= n; j++) {
                int add = gps_log[i] == j ? 0 : 1; // i 시간에 거점과 도시 위치가 같은지
                for(int city : graph[j]) // j 도시와 연결된 도시
                    d[i][j] = min(d[i][j], d[i - 1][city] + add);
            }
        }

        for(int city : graph[gps_log[k - 1]]) {
            answer = min(answer, d[k - 2][city]);
        }

        if(answer == Integer.MAX_VALUE / 2)
            return -1;
        else
            return answer;
    }

    private int min(int... value) {
        int min = value[0];
        for (int i = 1; i < value.length; i++)
            if (min > value[i])
                min = value[i];
        return min;
    }
}
