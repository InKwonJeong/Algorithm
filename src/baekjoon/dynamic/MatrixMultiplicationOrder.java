package baekjoon.dynamic;

import java.util.Scanner;

public class MatrixMultiplicationOrder {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        Matrix[] matrices = new Matrix[n];
        int[][] d = new int[n][n];

        for(int i = 0; i < n; i++)
            matrices[i] = new Matrix(input.nextInt(), input.nextInt());

        for(int k = 1; k < n; k++) {
            for(int i = 0; i < n - k; i++) {
                d[i][i + k] = Integer.MAX_VALUE;
                for(int j = i; j < i + k; j++) {
                    int value = matrices[i].row * matrices[j].column * matrices[i + k].column;
                    d[i][i + k] = Math.min(d[i][i + k], d[i][j] + d[j + 1][i + k] + value);
                }
            }
        }
        System.out.println(d[0][n - 1]);
    }

    static class Matrix {
        int row, column;

        public Matrix(int row, int column) {
            this.row = row;
            this.column = column;
        }
    }
}
