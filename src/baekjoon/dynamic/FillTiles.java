package baekjoon.dynamic;

import java.util.Scanner;

public class FillTiles {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int n = input.nextInt();
        if(n % 2 == 0) {
            int m = n / 2;
            int[] d = new int[m + 1];

            d[0] = 1;
            for(int i = 1; i <= m; i++) {
                d[i] = 3 * d[i - 1];
                for(int j = i - 2; j >= 0; j--)
                    d[i] += 2 * d[j];
            }
            System.out.println(d[m]);
        } else {
            System.out.println(0);
        }
    }
}
