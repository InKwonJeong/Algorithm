package baekjoon.bdfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class FindPath {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int n = input.nextInt();
        int[][] graph = new int[n][n];
        int[][] answer = new int[n][n];

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                graph[i][j] = input.nextInt();
            }
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(graph[i][j] == 1) {
                    answer[i][j] = 1;
                    continue;
                }
                Queue<Integer> queue = new LinkedList<>();
                boolean isFound = false;
                boolean[] check = new boolean[n];

                queue.offer(i);
                while(!queue.isEmpty()) {
                    int point = queue.poll();
                    for (int k = 0; k < n; k++) {
                        if (graph[point][k] == 1 && !check[k]) {
                            if (k == j) {
                                isFound = true;
                                break;
                            }
                            queue.offer(k);
                            check[k] = true;
                        }
                    }
                    if (isFound) {
                        answer[i][j] = 1;
                        break;
                    }
                }
            }
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                System.out.printf("%d ", answer[i][j]);
            }
            System.out.println();
        }
    }
}
