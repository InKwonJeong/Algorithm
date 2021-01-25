package baekjoon.dynamic;

import java.util.Scanner;

public class PlusOneTwoThree {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int[] d = new int[11];
        d[1] = 1;
        d[2] = 2;
        d[3] = 4;

        int t = input.nextInt();
        while(t > 0) {
            int n = input.nextInt();
            for(int i = 4; i <= n; i++) {
                d[i] = d[i - 1] + d[i - 2] + d[i - 3];
            }

            System.out.println(d[n]);
            t--;
        }
    }
}
