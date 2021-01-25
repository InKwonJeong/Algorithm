package baekjoon.stage.brueforce;

import java.util.Scanner;

public class RepaintChessboard {

    private static boolean[][] board;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int m = input.nextInt();
        int n = input.nextInt();

        board = new boolean[m][n];
        for(int i = 0 ; i < m; i++) {
            String str = input.next();
            for(int j = 0; j < n; j++) {
                if(str.charAt(j) == 'W') {
                    board[i][j] = true;
                } else {
                    board[i][j] = false;
                }
            }
        }

        int answer = Integer.MAX_VALUE;
        for(int i = 0; i <= m - 8; i++) {
            for(int j = 0; j <= n - 8; j++) {
                int count = repaint(i, j);
                if(answer > count)
                    answer = count;
            }
        }
        System.out.println(answer);
    }

    private static int repaint(int x, int y) {
        int count1 = 0;
        int count2 = 0;
        boolean paint = true;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (paint != board[i + x][j + y])
                    count1++;
                else
                    count2++;

                if (j != 7)
                    paint = !paint;
            }
        }

        if (count1 > count2)
            return count2;
        else
            return count1;
    }
}
