package baekjoon.stage.math2;

import java.util.Scanner;

public class SearchPrimeNumber {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int m = input.nextInt();
        int n = input.nextInt();
        for (int a = m; a <= n; a++) {
            boolean prime = true;
            if (a == 1)
                prime = false;
            for (int i = 2; i * i <= a; i++) {
                if (a % i == 0)
                    prime = false;
            }
            if (prime)
                System.out.println(a);
        }
    }
}
