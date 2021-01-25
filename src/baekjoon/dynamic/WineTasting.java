package baekjoon.dynamic;

import java.util.Scanner;

public class WineTasting {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int n = input.nextInt();
        int[][] d = new int[n + 1][3];
        int[] a = new int[n + 1];

        for(int i = 1; i <= n; i++) {
            a[i] = input.nextInt();
        }

        d[1][1] = a[1];
        for(int i = 2; i <= n; i++) {
            d[i][0] = max(d[i - 1][0], d[i - 1][1], d[i - 1][2]);
            d[i][1] = a[i] + d[i - 1][0];
            d[i][2] = a[i] + d[i - 1][1];
        }

        System.out.println(max(d[n][0], d[n][1], d[n][2]));
    }

    private static int max(int... a) {
        int max = a[0];
        for (int value : a) {
            if (max < value)
                max = value;
        }
        return max;
    }
}
