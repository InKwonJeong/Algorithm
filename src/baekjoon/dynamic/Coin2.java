package baekjoon.dynamic;

import java.util.Scanner;

public class Coin2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int n = input.nextInt();
        int k = input.nextInt();
        int[] a = new int[n];
        int[] d = new int[k + 1];

        for(int i = 0; i < n; i++) {
            a[i] = input.nextInt();
        }

        for(int i = 1; i <= k; i++) {
             boolean enable = false;
             int value = Integer.MAX_VALUE;
             for(int j = 0; j < n; j++) {
                 int coin = a[j];
                 if(i >= coin && value > d[i - coin] && d[i - coin] != -1) {
                     value = d[i - coin];
                     enable = true;
                 }
             }
             if(enable)
                 d[i] = value + 1;
             else
                 d[i] = -1;
        }

        System.out.println(d[k]);
    }
}
