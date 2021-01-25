package baekjoon.stage.whilestatement;

import java.util.Scanner;

public class AdditionCycle {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();

        int answer = 1;
        int b = (n / 10) + (n % 10);
        int a = (n % 10) * 10 + (b % 10);

        while (a != n) {
            b = (a / 10) + (a % 10);
            a = (a % 10) * 10 + (b % 10);
            answer++;
        }
        System.out.println(answer);
    }
}
