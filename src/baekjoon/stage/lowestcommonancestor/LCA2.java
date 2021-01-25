package baekjoon.stage.lowestcommonancestor;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LCA2 {

    private static final int MAX = 100000 + 1;
    private static final int D = (int) (baseLog(MAX, 2) + 1);
    private static int[][] d;
    private static int[] heights;
    private static List<Integer>[] graph;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        d = new int[n + 1][D];
        heights = new int[n + 1];
        graph = new List[n + 1];
        for(int i = 1; i <= n; i++)
            graph[i] = new ArrayList<>();

        for(int i = 1; i < n; i++) {
            int a = input.nextInt();
            int b = input.nextInt();
            graph[a].add(b);
            graph[b].add(a);
        }

        dfs(1, 0, 0);
        for(int j = 1; j < D; j++) {
            for(int i = 1; i <= n; i++) {
                d[i][j] = d[d[i][j - 1]][j - 1];
            }
        }

        int m = input.nextInt();
        while (m --> 0) {
            int node1 = input.nextInt();
            int node2 = input.nextInt();
            System.out.println(lca(node1, node2));
        }
    }

    private static int lca(int a, int b) {
        if(heights[a] != heights[b]) {
            if(heights[a] > heights[b]) {
                int temp = a;
                a = b;
                b = temp;
            }

            for(int i = D - 1; i >= 0; i--) {
                if(heights[b] - heights[a] >= (1 << i))
                    b = d[b][i];
            }
        }

        if(a == b)
            return a;
        else {
            for(int i = D - 1; i >= 0; i--) {
                if(d[a][i] != d[b][i]) {
                    a = d[a][i];
                    b = d[b][i];
                }
            }
            return d[a][0];
        }
    }

    private static void dfs(int node, int parent, int height) {
        heights[node] = height;
        d[node][0] = parent;

        for(int child : graph[node]) {
            if(child == parent) continue;
            dfs(child, node, height + 1);
        }
    }

    private static double baseLog(double x, double base) {
        return Math.log(x) / Math.log(base);
    }
}
