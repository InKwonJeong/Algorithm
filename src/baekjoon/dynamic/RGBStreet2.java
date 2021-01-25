package baekjoon.dynamic;

import java.util.Scanner;

public class RGBStreet2 {

    private static final int INF = 987654321;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int n = input.nextInt();
        int[][] a = new int[n][3];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 3; j++) {
                a[i][j] = input.nextInt();
            }
        }

        int[][] d1 = new int[n][3];
        d1[0][0] = a[0][0];
        d1[0][1] = INF;
        d1[0][2] = INF;

        int[][] d2 = new int[n][3];
        d2[0][0] = INF;
        d2[0][1] = a[0][1];
        d2[0][2] = INF;

        int[][] d3 = new int[n][3];
        d3[0][0] = INF;
        d3[0][1] = INF;
        d3[0][2] = a[0][2];

        for (int i = 1; i < n; i++) {
            d1[i][0] = min(d1[i - 1][1], d1[i - 1][2]) + a[i][0];
            d1[i][1] = min(d1[i - 1][0], d1[i - 1][2]) + a[i][1];
            d1[i][2] = min(d1[i - 1][0], d1[i - 1][1]) + a[i][2];
            d2[i][0] = min(d2[i - 1][1], d2[i - 1][2]) + a[i][0];
            d2[i][1] = min(d2[i - 1][0], d2[i - 1][2]) + a[i][1];
            d2[i][2] = min(d2[i - 1][0], d2[i - 1][1]) + a[i][2];
            d3[i][0] = min(d3[i - 1][1], d3[i - 1][2]) + a[i][0];
            d3[i][1] = min(d3[i - 1][0], d3[i - 1][2]) + a[i][1];
            d3[i][2] = min(d3[i - 1][0], d3[i - 1][1]) + a[i][2];
        }

        int a1 = min(d1[n - 1][1], d1[n - 1][2]);
        int a2 = min(d2[n - 1][0], d2[n - 1][2]);
        int a3 = min(d3[n - 1][0], d3[n - 1][1]);
        System.out.println(min(a1, a2, a3));
    }

    private static int min(int... values) {
        int min = values[0];
        for (int i = 1; i < values.length; i++) {
            if (min > values[i])
                min = values[i];
        }
        return min;
    }
}
