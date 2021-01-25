package baekjoon.implementation;

import java.util.Scanner;

public class SugarDelivery {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int n = input.nextInt();
        int[] d = new int[n + 1];

        for(int i = 1; i <= n; i++) {
            int value = Integer.MAX_VALUE;
            if(i >= 3 && value > d[i - 3] && d[i - 3] > -1)
                value = d[i - 3];
            if(i >= 5 && value > d[i - 5] && d[i - 5] > -1)
                value = d[i - 5];

            if(value == Integer.MAX_VALUE)
                d[i] = -1;
            else
                d[i] = value + 1;
        }
        System.out.println(d[n]);
    }
}
