package baekjoon.stage.divideconquer;

import java.util.Scanner;

public class Multiplication {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int a = input.nextInt();
        int b = input.nextInt();
        int c = input.nextInt();

        System.out.println(divide(a, b, c));
    }

    private static long divide(int a, int b, int c) {
        if (b == 0) {
            return 1;
        }

        long n = divide(a, b / 2, c);
        long temp = n * n % c;

        if (b % 2 == 0) {
            return temp;
        } else {
            return a * temp % c;
        }
    }
}
