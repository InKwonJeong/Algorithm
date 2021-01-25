package baekjoon.dynamic;

import java.util.Scanner;

public class Coin1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int n = input.nextInt();
        int k = input.nextInt();
        int[] a = new int[n + 1];
        int[] d = new int[k + 1];

        for (int i = 1; i <= n; i++)
            a[i] = input.nextInt();

        d[0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = a[i]; j <= k; j++) {
                d[j] += d[j - a[i]];
            }
        }
        System.out.println(d[k]);

    }
}
