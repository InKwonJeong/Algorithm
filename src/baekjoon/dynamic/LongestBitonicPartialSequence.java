package baekjoon.dynamic;

import java.util.Scanner;

public class LongestBitonicPartialSequence {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int n = input.nextInt();
        int[] a = new int[n + 1];
        int[] d = new int[n + 1];
        int[] d1 = new int[n + 1];
        int[] d2 = new int[n + 1];

        for(int i = 1; i <= n; i++)
            a[i] = input.nextInt();

        d1[1] = 1;
        for(int i = 2; i <= n; i++) {
            int length = 0;
            for(int j = 1; j < i; j++) {
                if(a[i] > a[j] && length < d1[j])
                    length = d1[j];
            }
            d1[i] = length + 1;
        }

        d2[n] = 1;
        for(int i = n - 1; i >= 1; i--) {
            int length = 0;
            for(int j = n; j > i; j--) {
                if(a[i] > a[j] && length < d2[j])
                    length = d2[j];
            }
            d2[i] = length + 1;
        }

        for(int i = 1; i <= n; i++)
            d[i] = d1[i] + d2[i] - 1;

        int answer = d[1];
        for(int i = 2; i <= n; i++) {
            if(answer < d[i])
                answer = d[i];
        }
        System.out.println(answer);
    }
}
