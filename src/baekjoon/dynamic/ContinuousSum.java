package baekjoon.dynamic;

import java.util.Scanner;

public class ContinuousSum {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int n = input.nextInt();
        int[] a = new int[n + 1];
        int[] d = new int[n + 1];

        for(int i = 1; i <= n; i++)
            a[i] = input.nextInt();

        d[1] = a[1];
        for(int i = 2; i <= n; i++) {
            if(a[i] + d[i - 1] < a[i])
                d[i] = a[i];
            else
                d[i] = a[i] + d[i - 1];
        }

        int answer = d[1];
        for(int i = 2; i <= n; i++) {
            if(answer < d[i])
                answer = d[i];
        }
        System.out.println(answer);
    }
}
