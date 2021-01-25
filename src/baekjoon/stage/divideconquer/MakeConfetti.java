package baekjoon.stage.divideconquer;

import java.util.Scanner;

public class MakeConfetti {

    private static int[] answer;
    private static int[][] graph;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        answer = new int[2];
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
    }

    private static void divide(int r, int c, int n) {
        if(n == 1) {
            answer[graph[r][c]]++;
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
            answer[color]++;
        else {
            divide(r, c, n / 2);
            divide(r + n / 2, c, n / 2);
            divide(r, c + n / 2, n / 2);
            divide(r + n / 2, c + n / 2, n / 2);
        }
    }
}
