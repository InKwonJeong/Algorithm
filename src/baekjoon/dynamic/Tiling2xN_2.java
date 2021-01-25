package baekjoon.dynamic;

import java.util.Scanner;

public class Tiling2xN_2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int[] d = new int[1001];
        d[1] = 1;
        d[2] = 3;

        int n = input.nextInt();
        for(int i = 3; i <= n; i++) {
            d[i] = (d[i - 1] + 2 * d[i - 2]) % 10007;
        }
        System.out.println(d[n]);
    }
}
