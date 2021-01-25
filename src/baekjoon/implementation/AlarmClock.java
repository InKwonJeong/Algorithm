package baekjoon.implementation;

import java.util.Scanner;

public class AlarmClock {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int h = input.nextInt();
        int m = input.nextInt();

        if(m >= 45)
            m -= 45;
        else {
            if(h == 0)
                h = 23;
            else
                h -= 1;
            m += 15;
        }
        System.out.printf("%d %d", h, m);
    }
}
