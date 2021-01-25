package baekjoon.stage.math3;

import java.util.Scanner;

public class MultiplesAndFactors {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        while (true) {
            int a = input.nextInt();
            int b = input.nextInt();
            if(a == 0 && b == 0)
                break;

            if(a % b == 0) {
                System.out.println("multiple");
            } else if(b % a == 0) {
                System.out.println("factor");
            } else {
                System.out.println("neither");
            }
        }

    }
}
