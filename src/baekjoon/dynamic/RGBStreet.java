package baekjoon.dynamic;

import java.util.Scanner;

public class RGBStreet {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int n = input.nextInt();
        int[][] d = new int[n][3];
        int[] r = new int[n];
        int[] g = new int[n];
        int[] b = new int[n];

        for (int i = 0; i < n; i++) {
            r[i] = input.nextInt();
            g[i] = input.nextInt();
            b[i] = input.nextInt();
        }

        d[0][0] = r[0];
        d[0][1] = g[0];
        d[0][2] = b[0];

        for (int i = 1; i < n; i++) {
            d[i][0] = r[i] + Math.min(d[i - 1][1], d[i - 1][2]);
            d[i][1] = g[i] + Math.min(d[i - 1][0], d[i - 1][2]);
            d[i][2] = b[i] + Math.min(d[i - 1][0], d[i - 1][1]);
        }

        int answer = d[n - 1][0];
        if (answer > d[n - 1][1])
            answer = d[n - 1][1];
        if (answer > d[n - 1][2])
            answer = d[n - 1][2];

        System.out.println(answer);
    }
}
