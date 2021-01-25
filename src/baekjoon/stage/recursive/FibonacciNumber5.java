package baekjoon.stage.recursive;

import java.util.Scanner;

public class FibonacciNumber5 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        if(n == 0) {
            System.out.println(0);
            return;
        }
        int[] d = new int[n + 1];
        d[0] = 0;
        d[1] = 1;
        for(int i = 2; i <= n; i++)
            d[i] = d[i - 2] + d[i - 1];

        System.out.println(d[n]);
    }
}
