package baekjoon.greedy;

import java.util.Scanner;

public class Procession {

    private static int n, m, count;
    private static int[][] a, b;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        n = input.nextInt();
        m = input.nextInt();
        a = new int[n][m];
        b = new int[n][m];

        for(int i = 0; i < n; i++) {
            String str = input.next();
            for(int j = 0; j < m; j++) {
                a[i][j] = str.charAt(j) - '0';
            }
        }

        for(int i = 0; i < n; i++) {
            String str = input.next();
            for(int j = 0; j < m; j++) {
                b[i][j] = str.charAt(j) - '0';
            }
        }

        for(int i = 0; i < n - 2; i++) {
            for(int j = 0; j < m - 2; j++) {
                if(a[i][j] != b[i][j])
                    flip(i, j);
            }
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(a[i][j] != b[i][j]) {
                    System.out.println(-1);
                    return;
                }
            }
        }

        System.out.println(count);
    }

    private static void flip(int x, int y) {
        count++;
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                a[x + i][y + j] = 1 - a[x + i][y + j];
            }
        }
    }
}
