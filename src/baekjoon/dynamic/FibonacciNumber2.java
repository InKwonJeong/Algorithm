package baekjoon.dynamic;

import java.util.Scanner;

public class FibonacciNumber2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        long[] d = new long[n + 1];
        d[0] = 0;
        d[1] = 1;
        for(int i = 2; i <= n; i++)
            d[i] = d[i - 2] + d[i - 1];

        System.out.println(d[n]);
    }
}
