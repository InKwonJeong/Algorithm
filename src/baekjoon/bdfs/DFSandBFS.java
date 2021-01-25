package baekjoon.bdfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class DFSandBFS {
    private static int n;
    private static int m;
    private static int v;
    private static int[][] graph;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        n = input.nextInt();
        m = input.nextInt();
        v = input.nextInt();

        graph = new int[n + 1][n + 1];

        for (int i = 0; i < m; i++) {
            int x = input.nextInt();
            int y = input.nextInt();
            graph[x][y] = 1;
            graph[y][x] = 1;
        }

        dfs();
        System.out.println();
        bfs();
    }

    private static void dfs() {
        Stack<Integer> stack = new Stack<>();
        boolean[] check = new boolean[n + 1];

        stack.push(v);
        while (!stack.isEmpty()) {
            int point = stack.pop();
            if (!check[point])
                System.out.printf("%d ", point);

            check[point] = true;
            for (int i = n; i >= 1; i--) {
                if (graph[point][i] == 1 && !check[i]) {
                    stack.push(i);
                }
            }
        }
    }

    private static void bfs() {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] check = new boolean[n + 1];

        queue.offer(v);
        check[v] = true;
        while (!queue.isEmpty()) {
            int point = queue.poll();
            System.out.printf("%d ", point);

            for (int i = 1; i <= n; i++) {
                if (graph[point][i] == 1 && !check[i]) {
                    queue.offer(i);
                    check[i] = true;
                }
            }
        }
    }

}
