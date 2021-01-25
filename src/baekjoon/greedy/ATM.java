package baekjoon.greedy;

import java.util.Arrays;
import java.util.Scanner;

public class ATM {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int n = input.nextInt();
        int[] p = new int[n];
        for(int i = 0; i < n; i++) {
            p[i] = input.nextInt();
        }

        Arrays.sort(p);

        int total = 0;
        for(int i = 0; i < n; i++) {
            if(i != 0)
                p[i] += p [i - 1];
            total += p[i];
        }
        System.out.println(total);
    }
}
