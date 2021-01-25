package baekjoon.dynamic;

import java.util.Scanner;

public class MergingFiles {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int t = input.nextInt();
        while (t > 0) {
            int n = input.nextInt();
            int[] a = new int[n + 1];
            int[] sum = new int[n + 1];
            int[][] d = new int[n + 1][n + 1];
            for (int i = 1; i <= n; i++) {
                a[i] = input.nextInt();
                sum[i] += sum[i - 1] + a[i];
            }

            for (int k = 1; k <= n - 1; k++) {
                for (int i = 1; i + k <= n; i++) {
                    for (int j = 0; j < k; j++) {
                        if (d[i][i + k] == 0) {
                            d[i][i + k] = d[i][i + j] + d[i + j + 1][i + k];
                        } else {
                            d[i][i + k] = min(d[i][i + k], d[i][i + j] + d[i + j + 1][i + k]);
                        }
                    }
                    d[i][i + k] += sum[i + k] - sum[i - 1];
                }
            }
            System.out.println(d[1][n]);

            t--;
        }
    }

    private static int min(int... value) {
        int min = value[0];
        for (int i = 1; i < value.length; i++) {
            if (min > value[i])
                min = value[i];
        }
        return min;
    }
}
