package baekjoon.dynamic;

import java.util.Scanner;

public class EasyNumberOfStairs {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int n = input.nextInt();
        int[][] d = new int[n + 1][10];

        for(int i = 0; i <= 9; i++) {
            if(i == 0)
                d[1][i] = 0;
            else
                d[1][i] = 1;
        }

        for(int i = 2; i <= n; i++) {
            for(int j = 0; j <= 9; j++) {
                if(j == 0)
                    d[i][j] = d[i - 1][1] % 1000000000;
                else if(j == 9)
                    d[i][j] = d[i - 1][8] % 1000000000;
                else
                    d[i][j] = (d[i - 1][j - 1] + d[i - 1][j + 1]) % 1000000000;
            }
        }

        int answer = 0;
        for(int i = 0; i <= 9; i++) {
            answer += d[n][i];
            answer %= 1000000000;
        }
        System.out.println(answer);
    }
}
