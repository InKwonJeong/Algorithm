package baekjoon.stage.divideconquer;

import java.util.Scanner;

public class Z {

    private static int r, c, answer;
    private static boolean finish;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        r = input.nextInt();
        c = input.nextInt();

        divide(n, 0, 0, 0);
        System.out.println(answer);
    }

    private static void divide(int n, int x, int y, int o) {
        if(finish)
            return;

        if(n == 1) {
            if(x == r && y == c) {
                answer = o;
                finish = true;
            } else if(x == r && y + 1 == c) {
                answer = o + 1;
                finish = true;
            } else if(x + 1 == r && y == c) {
                answer = o + 2;
                finish = true;
            } else if(x + 1 == r && y + 1 == c) {
                answer = o + 3;
                finish = true;
            }
        } else {
            int d = (int) Math.pow(2, n - 1);
            if(x + d <= r && y + d <= c) {
                divide(n - 1, x + d, y + d, o + 3 * d * d);
            } else if(x + d <= r && y <= c) {
                divide(n - 1, x + d, y, o + 2 * d * d);
            } else if(x <= r && y + d <= c) {
                divide(n - 1, x, y + d, o + d * d);
            } else {
                divide(n - 1, x, y, o);
            }
        }
    }
}
