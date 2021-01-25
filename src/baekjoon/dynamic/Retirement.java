package baekjoon.dynamic;

import java.util.Scanner;

public class Retirement {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int n = input.nextInt();
        int[] t = new int[n + 1];
        int[] p = new int[n + 1];
        int[] d = new int[n + 1];
        for(int i = 1; i <= n; i++) {
            t[i] = input.nextInt();
            p[i] = input.nextInt();
        }

        for(int i = n; i >= 1; i--) {
            int time = i + t[i];
            if(time - 1 <= n) {
                int max = 0;
                for(int j = time; j <= n; j++) {
                    if(max < d[j])
                        max = d[j];
                }
                d[i] = p[i] + max;
            }
        }

        int answer = 0;
        for(int i = 1; i <= n; i++) {
            if(answer < d[i])
                answer = d[i];
        }
        System.out.println(answer);

    }
}
