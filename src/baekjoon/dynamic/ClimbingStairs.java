package baekjoon.dynamic;

import java.util.Scanner;

public class ClimbingStairs {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int n = input.nextInt();
        int[] a = new int[n + 1];
        int[][] d = new int[n + 1][2];

        for(int i = 1; i <= n; i++) {
            a[i] = input.nextInt();
        }

        d[1][0] = a[1];
        for(int i = 2; i <= n; i++) {
            d[i][0] = Math.max(d[i - 2][0], d[i - 2][1]) + a[i];
            d[i][1] = d[i - 1][0] + a[i];
        }

        System.out.println(Math.max(d[n][0], d[n][1]));
    }
}
