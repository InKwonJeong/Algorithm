package baekjoon.stage.divideconquer;

import java.util.Scanner;

public class MatrixSquared {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[][] a = new int[n][n];

        long k = input.nextLong();
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                a[i][j] = input.nextInt() % 1000;
            }
        }

        int[][] answer = square(a, k);
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                System.out.print(answer[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static int[][] square(int[][] a, long k) {
        if(k == 1)
            return a;

        int[][] matrix = square(a, k / 2);
        if(k % 2 == 0) {
            return square(matrix, matrix);
        } else {
            return square(square(matrix, matrix), a);
        }
    }

    private static int[][] square(int[][] a, int[][] b) {
        int n = a.length;
        int[][] result = new int[n][n];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                int value = 0;
                for(int k = 0; k < n; k++) {
                    value += a[i][k] * b[k][j];
                }
                result[i][j] = value % 1000;
            }
        }
        return result;
    }
}
