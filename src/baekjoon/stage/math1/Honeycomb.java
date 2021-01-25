package baekjoon.stage.math1;

import java.util.Scanner;

public class Honeycomb {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        long a = input.nextLong();

        if(a == 1)
            System.out.println(1);
        else {
            a--;
            long n = 6;
            int count = 2;
            while (a > n) {
                a -= n;
                n += 6;
                count++;
            }
            System.out.println(count);
        }
    }
}
