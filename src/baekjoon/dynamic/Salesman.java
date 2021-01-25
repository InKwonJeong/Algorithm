package baekjoon.dynamic;

import java.util.Arrays;
import java.util.Scanner;

public class Salesman {

    private static final int INF = 987654321;
    private static int n;
    private static int[][] w, d;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        n = input.nextInt();
        w = new int[n][n];
        d = new int[n][1 << n];
        for(int i = 0; i < n; i++) {
            Arrays.fill(d[i], INF);
            for(int j = 0; j < n; j++) {
                w[i][j] = input.nextInt();
            }
        }

        System.out.println(dfs(0, 1));
    }

    private static int dfs(int node, int visit) {
        if(visit == (1 << n) - 1) {
            if(w[node][0] != 0) {
                return w[node][0];
            }
            return INF;
        }

        if(d[node][visit] != INF)
            return d[node][visit];

        for(int next = 0; next < n; next++) {
            if((visit & (1 << next)) == 0 && w[node][next] > 0) {
                d[node][visit] = Math.min(d[node][visit], dfs(next, visit | (1 << next)) + w[node][next]);
            }
        }

        return d[node][visit];
    }
}
