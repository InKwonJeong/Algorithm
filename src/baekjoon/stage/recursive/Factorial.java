package baekjoon.stage.recursive;

import java.util.Scanner;

public class Factorial {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        int a = input.nextInt();
        int answer = 1;

        for(int i=1; i<=a; i++) {
            answer *= i;
        }
        System.out.println(answer);
    }
}
