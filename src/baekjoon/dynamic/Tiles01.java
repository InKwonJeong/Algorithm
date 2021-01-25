package baekjoon.dynamic;

import java.util.Scanner;

public class Tiles01 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int n = input.nextInt();
        int[] d = new int[n + 1];

        d[0] = 1;
        d[1] = 1;
        for(int i = 2; i <= n; i++) {
            d[i] = d[i - 1] + d[i - 2];
            d[i] %= 15746;
        }
        System.out.println(d[n]);
    }
}
