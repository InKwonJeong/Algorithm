package baekjoon.stage.math1;

import java.util.Scanner;

public class ACMHotel {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int t = input.nextInt();
        while (t > 0) {
            int h = input.nextInt();
            int w = input.nextInt();
            int n = input.nextInt();

            int x = (n - 1) / h + 1;
            int y = (n - 1) % h + 1;
            System.out.printf("%d%02d\n", y, x);
            t--;
        }
    }
}
