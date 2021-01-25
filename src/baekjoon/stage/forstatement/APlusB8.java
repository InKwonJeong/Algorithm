package baekjoon.stage.forstatement;

import java.util.Scanner;

public class APlusB8 {
    public static void main(String[] args) {
        int T,a,b;
        Scanner input = new Scanner(System.in);

        T = input.nextInt();

        for(int i = 1; i <= T; i++) {
            a = input.nextInt();
            b = input.nextInt();
            System.out.printf("Case #%d: %d + %d = %d\n", i, a, b, a+b);
        }
    }
}
