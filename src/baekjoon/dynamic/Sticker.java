package baekjoon.dynamic;

import java.util.Scanner;

public class Sticker {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int t = input.nextInt();
        while (t > 0) {
            int n = input.nextInt();
            int[][] a = new int[n + 1][3];
            int[][] d = new int[n + 1][3];

            for (int i = 1; i <= 2; i++) {
                for (int j = 1; j <= n; j++) {
                    a[j][i] = input.nextInt();
                }
            }

            d[1][0] = 0;
            d[1][1] = a[1][1];
            d[1][2] = a[1][2];

            for (int i = 2; i <= n; i++) {
                d[i][0] = max(d[i - 1][0], d[i - 1][1], d[i - 1][2]);
                d[i][1] = a[i][1] + max(d[i - 1][0], d[i - 1][2]);
                d[i][2] = a[i][2] + max(d[i - 1][0], d[i - 1][1]);
            }

            System.out.println(max(d[n][0], d[n][1], d[n][2]));

            t--;
        }
    }

    private static int max(int... values) {
        int max = 0;
        for (int value : values) {
            if (max < value)
                max = value;
        }
        return max;
    }
}
