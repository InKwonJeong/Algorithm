package baekjoon.stage.divideconquer;

import java.util.Scanner;

public class MatrixMultiplication {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int m = input.nextInt();
        int[][] a = new int[n][m];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                a[i][j] = input.nextInt();
            }
        }

        m = input.nextInt();
        int k = input.nextInt();
        int[][] b = new int[m][k];
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < k; j++) {
                b[i][j] = input.nextInt();
            }
        }

        int[][] answer = new int[n][k];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < k; j++) {
                int value = 0;
                for(int v = 0; v < m; v++) {
                    value += a[i][v] * b[v][j];
                }
                answer[i][j] = value;
            }
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < k; j++) {
                System.out.print(answer[i][j] + " ");
            }
            System.out.println();
        }
    }
}

