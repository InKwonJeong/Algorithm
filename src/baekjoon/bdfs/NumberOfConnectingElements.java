package baekjoon.bdfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class NumberOfConnectingElements {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int n = input.nextInt();
        int m = input.nextInt();
        boolean[][] graph = new boolean[n + 1][n + 1];
        boolean[] check = new boolean[n + 1];

        for(int i = 1; i <= m; i++) {
            int x = input.nextInt();
            int y = input.nextInt();
            graph[x][y] = true;
            graph[y][x] = true;
        }

        int answer = 0;
        for(int i = 1; i <= n; i++) {
            if(!check[i]) {
                answer++;
                Queue<Integer> queue = new LinkedList<>();
                queue.offer(i);
                check[i] = true;
                while(!queue.isEmpty()) {
                    int point = queue.poll();
                    for(int target = 1; target <= n; target++) {
                        if(!check[target] && graph[point][target]) {
                            queue.offer(target);
                            check[target] = true;
                        }
                    }
                }
            }
        }

        System.out.println(answer);
    }
}
