package baekjoon.stage.backtracking;

import java.util.Scanner;

public class StartAndLink {

    private static int n, min;
    private static int[][] graph;
    private static boolean[] visit;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        n = input.nextInt();
        min = Integer.MAX_VALUE;
        visit = new boolean[n];
        graph = new int[n][n];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                graph[i][j] = input.nextInt();
            }
        }

        combination(0, 0);
        System.out.println(min);
    }

    private static void combination(int start, int depth) {
        if(depth == n / 2) {
            int point = point();
            if(point < min)
                min = point;
            return;
        }

        for(int i = start; i < n; i++) {
            if(!visit[i]) {
                visit[i] = true;
                combination(i + 1, depth + 1);
                visit[i] = false;
            }
        }
    }

    private static int point() {
        int point1 = 0;
        int point2 = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(i == j)
                    continue;
                if(visit[i] && visit[j])
                    point1 += graph[i][j];
                else if(!visit[i] && !visit[j])
                    point2 += graph[i][j];
            }
        }
        return Math.abs(point1 - point2);
    }
}
