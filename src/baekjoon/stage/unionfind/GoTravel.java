package baekjoon.stage.unionfind;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class GoTravel {

    private static int[] parents;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());

        parents = new int[n + 1];
        int[][] graph = new int[n + 1][n + 1];
        for(int i = 1; i <= n; i++) {
            parents[i] = i;
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= n; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[] travel_path = new int[m];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < m; i++) {
            travel_path[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= n; j++) {
                if(graph[i][j] == 1) {
                    int parent1 = find(i);
                    int parent2 = find(j);
                    if(parent1 != parent2)
                        union(i, j);
                }
            }
        }

        boolean finish = true;
        int parent = find(travel_path[0]);
        for(int i = 1; i < m; i++) {
            if(parent != find(travel_path[i])) {
                finish = false;
                break;
            }
        }

        if(finish)
            System.out.println("YES");
        else
            System.out.println("NO");
    }

    private static int find(int node) {
        int parent = parents[node];
        if(node == parent)
            return node;

        parents[node] = find(parent);
        return parents[node];
    }

    private static void union(int node1, int node2) {
        int parent1 = find(node1);
        int parent2 = find(node2);

        if(parent1 != parent2)
            parents[parent1] = parent2;
    }
}
