package baekjoon.dynamic;

import java.util.Scanner;

public class GenerationsOfTribbles {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int t = input.nextInt();
        long[] fibonacci = new long[68];

        fibonacci[0] = 1;
        fibonacci[1] = 1;
        fibonacci[2] = 2;
        fibonacci[3] = 4;

        for(int i = 0; i < t; i++) {
            int n = input.nextInt();
            for(int j = 4; j <= n; j++) {
                fibonacci[j] = fibonacci[j-1] + fibonacci[j-2] + fibonacci[j-3] + fibonacci[j-4];
            }
            System.out.println(fibonacci[n]);
        }
    }
}
