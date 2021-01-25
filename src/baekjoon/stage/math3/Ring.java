package baekjoon.stage.math3;

import java.util.Scanner;

public class Ring {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int a = input.nextInt();
        for(int i = 0; i < n - 1; i++) {
            int b = input.nextInt();
            int gcd;
            if(a > b)
                gcd = gcd(a, b);
            else
                gcd = gcd(b, a);

            System.out.printf("%d/%d\n", a / gcd, b / gcd);
        }
    }

    private static int gcd(int a, int b) {
        if(a % b == 0)
            return b;
        else
            return gcd(b, a % b);
    }
}
