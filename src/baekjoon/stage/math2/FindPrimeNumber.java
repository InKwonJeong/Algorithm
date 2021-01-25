package baekjoon.stage.math2;

import java.util.Scanner;

public class FindPrimeNumber {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int count = 0;
        int T = input.nextInt();
        for (int t = 0; t < T; t++) {
            int a = input.nextInt();
            boolean prime = true;
            if (a == 1)
                prime = false;
            for (int i = 2; i * i <= a; i++) {
                if (a % i == 0)
                    prime = false;
            }
            if (prime)
                count++;
        }
        System.out.println(count);
    }
}
