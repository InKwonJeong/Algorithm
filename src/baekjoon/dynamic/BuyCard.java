package baekjoon.dynamic;

import java.util.Scanner;

public class BuyCard {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int n = input.nextInt();
        int[] d = new int[n + 1];
        int[] a = new int[n + 1];
        for(int i = 1; i <= n; i++)
            a[i] = input.nextInt();

        d[1] = a[1];
        for(int i = 2; i <= n; i++) {
            for(int j = 1; j <= i; j++) {
                if(d[i] < a[j] + d[i - j])
                    d[i] = a[j] + d[i - j];
            }
        }
        System.out.println(d[n]);
    }
}
