package baekjoon.implementation;

import java.util.Arrays;
import java.util.Scanner;

public class Contest {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int[] w = new int[10];
        int[] k = new int[10];

        for(int i = 0; i < 10; i++) {
            w[i] = input.nextInt();
        }

        for(int i = 0; i < 10; i++) {
            k[i] = input.nextInt();
        }

        Arrays.sort(w);
        Arrays.sort(k);

        int w_total = w[9] + w[8] + w[7];
        int k_total = k[9] + k[8] + k[7];

        System.out.printf("%d %d", w_total, k_total);
    }
}
