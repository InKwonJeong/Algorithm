package baekjoon.stage.math3;

import java.util.Scanner;

public class FactorialNumberOf0 {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        int a = input.nextInt();
        int count = 0;

        for (int i = 5; i <= a; i += 5) {
            count++;
            if (i % 25 == 0)
                count++;
            if (i % 125 == 0)
                count++;
        }
        System.out.println(count);
    }
}
