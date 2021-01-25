package baekjoon.stage.math2;

import java.util.Scanner;

public class GoldbachGuess {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int t = input.nextInt();
        while (t > 0) {
            int n = input.nextInt();
            int a = 0;
            for(int i = 2; i <= n / 2; i++) {
                if(isPrimeNumber(i) && isPrimeNumber(n - i))
                    a = i;
            }
            System.out.println(a + " " + (n - a));
            t--;
        }
    }

    private static boolean isPrimeNumber(int n) {
        for(int i = 2; i * i <= n; i++) {
            if(n % i == 0)
                return false;
        }
        return true;
    }
}
