package baekjoon.bdfs;

import java.util.Scanner;

public class KevinBaconSixStepRule {

    private static int n, m;
    private static int[][] graph, d;
    private static boolean[] check;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        n = input.nextInt();
        m = input.nextInt();
        graph = new int[n + 1][n + 1];
        d = new int[n + 1][n + 1];
        check = new boolean[n + 1];

        for (int i = 0; i < m; i++) {
            int a = input.nextInt();
            int b = input.nextInt();
            graph[a][b] = 1;
            graph[b][a] = 1;
            d[a][b] = 1;
            d[b][a] = 1;
        }

        int answer = 0;
        int index = 0;
        for(int i = 1; i <= n; i++) {
            check[i] = true;
            int count = 0;
            for(int j = 1; j <= n; j++)
                count += dfs(i, j);

            if(answer == 0 || answer > count) {
                answer = count;
                index = i;
            }
            check[i] = false;
        }
        System.out.println(index);
    }

    private static int dfs(int a, int b) {
        if(a == b)
            return 0;

        if(d[a][b] == 0) {
            int min = Integer.MAX_VALUE;
            for(int i = 1; i <= n; i++) {
                if(graph[a][i] == 1 && !check[i]) {
                    check[i] = true;
                    int count = dfs(i, b);
                    if(count != 0 && min > count)
                        min = count;
                    check[i] = false;
                }
            }
            if(min != Integer.MAX_VALUE)
                d[a][b] = min + 1;
            else
                d[a][b] = 0;
        }
        return d[a][b];
    }
}
