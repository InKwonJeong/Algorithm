package baekjoon.stage.math1;

import java.util.Scanner;

public class FindFraction {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int x = input.nextInt();
        int count = 1;
        while (x > count) {
            x -= count++;
        }

        if(count % 2 == 1) {
            System.out.printf("%d/%d\n", (count - x) + 1, x);
        } else {
            System.out.printf("%d/%d\n", x, (count - x) + 1);
        }
    }
}
