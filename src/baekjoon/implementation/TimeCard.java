package baekjoon.implementation;

import java.util.Scanner;

public class TimeCard {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int[][][] card = new int[3][2][3];
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 2; j++) {
                for(int k = 0; k < 3; k++) {
                    card[i][j][k] = input.nextInt();
                }
            }
        }
        int[][] answer = new int[3][3];
        for(int i = 0; i < 3; i++) {
            for(int j = 2; j >= 0; j--) {
                int time = card[i][1][j] - card[i][0][j];
                if (time < 0) {
                    time += 60;
                    card[i][1][j - 1]--;
                }
                answer[i][j] = time;
            }
        }

        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                System.out.printf("%d ", answer[i][j]);
            }
            System.out.println();
        }
    }
}
