package baekjoon.dynamic;

import java.util.Scanner;

public class BiggestSquare {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int n = input.nextInt();
        int m = input.nextInt();
        int[][] graph = new int[n][m];
        int[][] d = new int[n][m];
        for (int i = 0; i < n; i++) {
            String str = input.next();
            for (int j = 0; j < m; j++) {
                graph[i][j] = str.charAt(j) - '0';
                if (graph[i][j] == 1)
                    d[i][j] = 1;
            }
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if(d[i][j] == 1)
                    d[i][j] = d[i][j] + min(d[i - 1][j], d[i][j - 1], d[i - 1][j - 1]);
            }
        }

        int answer = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(answer < d[i][j])
                    answer = d[i][j];
            }
        }
        System.out.println(answer * answer);
    }

    private static int min(int... nums) {
        int min = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (min > nums[i])
                min = nums[i];
        }
        return min;
    }
}
