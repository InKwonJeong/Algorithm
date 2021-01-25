package baekjoon.dynamic;

import java.util.Scanner;

public class FibonacciFunction {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        Fibonacci[] fibonacci = new Fibonacci[41];

        int t = input.nextInt();
        while(t > 0) {
            int n = input.nextInt();

            fibonacci[0] = new Fibonacci(1, 0);
            fibonacci[1] = new Fibonacci(0, 1);

            for(int i = 2; i <= n; i++) {
                fibonacci[i] = fibonacci[i - 2].plus(fibonacci[i - 1]);
            }

            System.out.printf("%d %d\n", fibonacci[n].zero, fibonacci[n].one);
            t--;
        }
    }

    static class Fibonacci {
        int zero;
        int one;

        Fibonacci(int zero, int one) {
            this.zero = zero;
            this.one = one;
        }

        Fibonacci plus(Fibonacci f) {
            return new Fibonacci(zero + f.zero, one + f.one);
        }
    }
}
