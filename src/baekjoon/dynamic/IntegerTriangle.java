package baekjoon.dynamic;

import java.util.Scanner;

public class IntegerTriangle {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int n = input.nextInt();
        int m = (n + 1) * n / 2;
        int[] a = new int[m + 1];
        int[] d = new int[m + 1];

        for(int i = 1; i <= m; i++)
            a[i] = input.nextInt();

        d[0] = 0;
        int level = 0;
        for(int i = 1; i <= m; i += level) {
            for(int j = 0; j <= level; j++) {
                int index = i + j;
                if(j == 0)
                    d[index] = d[index - level] + a[index];
                else if(j == level)
                    d[index] = d[index - level - 1] + a[index];
                else
                    d[index] = Math.max(d[index - level - 1], d[index - level]) + a[index];
            }
            level++;
        }

        int answer = d[m];
        for(int i = 1; i < level; i++) {
            if(answer < d[m - i])
                answer = d[m - i];
        }
        System.out.println(answer);
    }
}
