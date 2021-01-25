package baekjoon.stage.inputoutput;

import java.util.Scanner;

public class Multiplication {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int a = input.nextInt();
        int b = input.nextInt();
        int total = a * b;
        while (b > 0) {
            System.out.println(a * (b % 10));
            b /= 10;
        }
        System.out.println(total);
    }
}
