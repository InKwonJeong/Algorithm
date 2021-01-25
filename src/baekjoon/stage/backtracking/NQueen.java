package baekjoon.stage.backtracking;

import java.util.Scanner;

public class NQueen {

    private static boolean[] row, cross1, cross2;
    private static int n, answer;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        n = input.nextInt();
        row = new boolean[n];
        cross1 = new boolean[2 * n - 1];
        cross2 = new boolean[2 * n - 1];

        set(0);
        System.out.println(answer);
    }

    private static void set(int j) {
        if(j == n) {
            answer++;
            return;
        }

        for(int i = 0; i < n; i++) {
            if(!row[i] && !cross1[i + j] && !cross2[i + n - (j + 1)]) {
                row[i] = true;
                cross1[i + j] = true;
                cross2[i + n - (j + 1)] = true;
                set(j + 1);
                row[i] = false;
                cross1[i + j] = false;
                cross2[i + n - (j + 1)] = false;
            }
        }
    }
}
