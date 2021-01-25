package baekjoon.stage.math2;

import java.util.Scanner;

public class PrimeNumber {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int a = input.nextInt();
        int b = input.nextInt();

        int min = 0;
        int total = 0;
        for(int i = a; i <= b; i++) {
            if(isPrimeNumber(i)) {
                if(min == 0)
                    min = i;
                total += i;
            }
        }

        if(min != 0) {
            System.out.println(total);
            System.out.println(min);
        } else
            System.out.println(-1);
    }

    private static boolean isPrimeNumber(int n) {
        if(n == 1)
            return false;

        for(int i = 2; i * i <= n; i++) {
            if(n % i == 0)
                return false;
        }
        return true;
    }
}
