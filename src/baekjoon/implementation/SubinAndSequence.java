package baekjoon.implementation;

import java.util.Scanner;

public class SubinAndSequence {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int n = input.nextInt();
        int[] a = new int[n];
        for(int i = 0; i < n; i++) {
            int b = input.nextInt() * (i + 1);
            for(int j = 0; j < i; j++) {
                b -= a[j];
            }
            a[i] = b;
        }

        for(int num : a)
            System.out.printf("%d ", num);
    }
}
