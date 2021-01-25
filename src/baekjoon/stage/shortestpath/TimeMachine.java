package baekjoon.stage.shortestpath;

import java.io.*;
import java.util.*;

public class TimeMachine {

    static int INF = 987654321;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Edge[] e = new Edge[M];

        long[] dist = new long[N + 1];
        for (int i = 1; i <= N; i++)
            dist[i] = INF;


        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int val = Integer.parseInt(st.nextToken());
            e[i] = new Edge(u, v, val);
        }

        dist[1] = 0;
        // 벨만포드 알고리즘은 다이나믹 프로그래밍 기반. 각 반복에 대하여 해당 정점과 연결되어 있는 모든 간선을 보아야한다. 따라서 시간복잡도는 O(|V||E|)
        // 경로의 길이는 N-1 이므로, 그 이상이 된다면 싸이클이 발생한다.
        for (int i = 0; i < N - 1; i++) {
            for (int j = 0; j < M; j++) {
                if (dist[e[j].u] == INF)
                    continue;
                // v로 가는 최단거리보다 dist[edge.u] + u에서 v로 가는 거리 가 더 짧을 때 갱신해준
                if (dist[e[j].v] > (dist[e[j].u] + e[j].w)) {
                    dist[e[j].v] = dist[e[j].u] + e[j].w;
                }
            }
        }

        // 음의 사이클 체크
        boolean check = false;
        for (int i = 0; i < M; i++) {
            if (dist[e[i].u] != INF && dist[e[i].v] > dist[e[i].u] + e[i].w) {
                check = true;
                break;
            }
        }

        if (check)
            System.out.println(-1);
        else {
            for (int i = 2; i <= N; i++) {
                if (dist[i] == INF)
                    System.out.println("-1");
                else
                    System.out.println(dist[i]);
            }
        }

    }

    public static class Edge {
        int u;
        int v;
        int w;

        public Edge(int u, int v, int w) {
            this.u = u;
            this.v = v;
            this.w = w;
        }
    }
}
