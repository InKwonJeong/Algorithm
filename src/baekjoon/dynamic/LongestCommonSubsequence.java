package baekjoon.dynamic;

import java.util.Scanner;

public class LongestCommonSubsequence {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        String a = input.next();
        String b = input.next();

        int n = a.length();
        int m = b.length();
        int[][] d = new int[n + 1][m + 1];

        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= m; j++) {
                if(a.charAt(i - 1) != b.charAt(j - 1))
                    d[i][j] = Math.max(d[i][j - 1], d[i - 1][j]);
                else
                    d[i][j] = d[i - 1][j - 1] + 1;
            }
        }
        System.out.println(d[n][m]);
    }
}
