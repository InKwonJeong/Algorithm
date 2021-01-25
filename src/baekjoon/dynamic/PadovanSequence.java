package baekjoon.dynamic;

import java.util.Scanner;

public class PadovanSequence {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int t = input.nextInt();
        long[] d = new long[101];
        d[1] = 1;
        d[2] = 1;
        d[3] = 1;
        d[4] = 2;
        d[5] = 2;

        while (t > 0) {
            int n = input.nextInt();
            for(int i = 6; i <= n; i++) {
                if(d[i] != 0)
                    continue;
                d[i] = d[i - 1] + d[i - 5];
            }
            System.out.println(d[n]);
            t--;
        }
    }
}
