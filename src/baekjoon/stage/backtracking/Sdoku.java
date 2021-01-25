package baekjoon.stage.backtracking;

import java.util.*;

public class Sdoku {

    private static int[][] graph;
    private static boolean[][] row, column, rectangle;
    private static boolean finish;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        graph = new int[9][9];
        for(int i = 0; i < 9; i++) {
            for(int j = 0; j < 9; j++) {
                graph[i][j] = input.nextInt();
            }
        }

        row = new boolean[9][10];
        column = new boolean[9][10];
        rectangle = new boolean[9][10];

        for(int i = 0; i < 9; i++) {
            for(int j = 0; j < 9; j++) {
                row[i][graph[i][j]] = true;
            }
        }

        for(int i = 0; i < 9; i++) {
            for(int j = 0; j < 9; j++) {
                column[i][graph[j][i]] = true;
            }
        }

        for(int k = 0; k < 9; k++) {
            for(int i = (k / 3) * 3; i < (k / 3 + 1) * 3; i++) {
                for(int j = (k % 3) * 3; j < (k % 3 + 1) * 3; j++) {
                    rectangle[k][graph[i][j]] = true;
                }
            }
        }

        set(0, 0);
        for(int i = 0; i < 9; i++) {
            for(int j = 0; j < 9; j++) {
                System.out.print(graph[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void set(int i, int j) {
        if(finish)
            return;

        if(graph[i][j] == 0) {
            for(int k = 1; k <= 9; k++) {
                if(!row[i][k] && !column[j][k] && !rectangle[(i / 3) * 3 + (j / 3)][k]) {
                    row[i][k] = true;
                    column[j][k] = true;
                    rectangle[(i / 3) * 3 + (j / 3)][k] = true;
                    graph[i][j] = k;
                    if(i == 8 && j == 8) {
                        finish = true;
                        return;
                    } else if(j == 8) {
                        set(i + 1, 0);
                    } else {
                        set(i, j + 1);
                    }
                    if(!finish) {
                        row[i][k] = false;
                        column[j][k] = false;
                        rectangle[(i / 3) * 3 + (j / 3)][k] = false;
                        graph[i][j] = 0;
                    }
                }
            }
        } else {
            if(i == 8 && j == 8) {
                finish = true;
            } else if(j == 8) {
                set(i + 1, 0);
            } else {
                set(i, j + 1);
            }
        }
    }
}
