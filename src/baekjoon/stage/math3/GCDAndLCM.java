package baekjoon.stage.math3;

import java.util.Scanner;

public class GCDAndLCM {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int a = input.nextInt();
        int b = input.nextInt();

        int gcd = make(a, b);
        int lcm = a * b / gcd;
        System.out.println(gcd);
        System.out.println(lcm);
    }

    public static int make(int a, int b) {
        if (a % b == 0)
            return b;
        else
            return make(b, a % b);
    }
}
