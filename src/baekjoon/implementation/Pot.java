package baekjoon.implementation;

import java.util.Scanner;

public class Pot {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        long answer = 0;
        int n = input.nextInt();
        while(n > 0) {
            long num = input.nextLong();
            long q = (num / 10);
            long r = (num % 10);
            answer += Math.pow(q, r);
            n--;
        }
        System.out.println(answer);
    }
}
