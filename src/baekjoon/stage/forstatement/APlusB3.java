package baekjoon.stage.forstatement;

import java.util.Scanner;

public class APlusB3 {
    public static void main(String[] args) {
        int T, a, b;
        Scanner input = new Scanner(System.in);

        T = input.nextInt();

        for (int i = 0; i < T; i++) {
            a = input.nextInt();
            b = input.nextInt();
            System.out.println(a + b);
        }
    }
}

