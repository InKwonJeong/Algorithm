package baekjoon.implementation;

import java.util.Scanner;

public class Receipt {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int answer = input.nextInt();
        for(int i = 0; i < 9; i++) {
            answer -= input.nextInt();
        }

        System.out.println(answer);
    }
}
