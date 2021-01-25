package baekjoon.stage.math3;

import java.util.Scanner;

public class NumberOfCombinations0 {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        long n = input.nextInt();
        long m = input.nextInt();
        long[] count = new long[2];

        for (long i = 2; i <= n; i *= 2) {
            count[0] += n / i;
            count[0] -= m / i;
            count[0] -= (n - m) / i;
        }
        for (long i = 5; i <= n; i *= 5) {
            count[1] += n / i;
            count[1] -= m / i;
            count[1] -= (n - m) / i;
        }

        if (count[0] < count[1])
            System.out.println(count[0]);
        else
            System.out.println(count[1]);
    }
}
