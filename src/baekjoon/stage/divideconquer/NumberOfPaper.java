package baekjoon.stage.divideconquer;

import java.util.Scanner;

public class NumberOfPaper {

    private static int[] answer;
    private static int[][] graph;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        answer = new int[3];
        int n = input.nextInt();
        graph = new int[n][n];

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                graph[i][j] = input.nextInt();
            }
        }

        divide(0, 0, n);

        System.out.println(answer[0]);
        System.out.println(answer[1]);
        System.out.println(answer[2]);
    }

    private static void divide(int r, int c, int n) {
        if(n == 1) {
            answer[graph[r][c] + 1]++;
            return;
        }

        int color = graph[r][c];
        boolean finish = true;
        for(int i = r; i < r + n; i++) {
            for(int j = c; j < c + n; j++) {
                if(color != graph[i][j]) {
                    finish = false;
                    break;
                }
            }
            if(!finish)
                break;
        }

        if(finish)
            answer[color + 1]++;
        else {
            divide(r, c, n / 3);
            divide(r, c + n / 3, n / 3);
            divide(r, c + 2 * n / 3, n / 3);
            divide(r + n / 3, c, n / 3);
            divide(r + n / 3, c + n / 3, n / 3);
            divide(r + n / 3, c + 2 * n / 3, n / 3);
            divide(r + 2 * n / 3, c, n / 3);
            divide(r + 2 * n / 3, c + n / 3, n / 3);
            divide(r + 2 * n / 3, c + 2 * n / 3, n / 3);
        }
    }
}
