package baekjoon.greedy;

import java.util.Scanner;

public class SemiconductorDesign {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int n = input.nextInt();
        int[] a = new int[n + 1];
        int[] d = new int[n + 1];

        for(int i = 1; i <= n; i++)
            a[i] = input.nextInt();

        d[1] = 1;
        for(int i = 2; i <= n; i++) {
            int value = 0;
            for(int j = 1; j < i; j++) {
                if(a[i] > a[j] && value < d[j])
                    value = d[j];
            }
            d[i] = value + 1;
        }

        int answer = d[1];
        for(int i = 2; i <= n; i++) {
            if(answer < d[i])
                answer = d[i];
        }
        System.out.println(answer);
    }
}
