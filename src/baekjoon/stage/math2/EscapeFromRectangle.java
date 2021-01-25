package baekjoon.stage.math2;

import java.util.Scanner;

public class EscapeFromRectangle {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int x = input.nextInt();
        int y = input.nextInt();
        int w = input.nextInt();
        int h = input.nextInt();

        int min = Integer.MAX_VALUE;
        if(x < min)
            min = x;
        if(y < min)
            min = y;
        if(w - x < min)
            min = w - x;
        if(h - y < min)
            min = h - y;
        System.out.println(min);
    }
}
