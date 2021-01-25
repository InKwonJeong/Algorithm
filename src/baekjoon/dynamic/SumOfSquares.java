package baekjoon.dynamic;

import java.util.Scanner;

public class SumOfSquares {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int n = input.nextInt();
        int[] d = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            int value = Integer.MAX_VALUE;
            for (int j = 1; j * j <= i; j++) {
                if(value > d[i - j * j])
                    value = d[i - j * j];
            }
            d[i] = 1 + value;
        }

        System.out.println(d[n]);
    }
}
