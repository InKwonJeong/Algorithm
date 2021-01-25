package baekjoon.stage.lowestcommonancestor;

import java.util.Scanner;

public class CompositeFunctionsAndQueries {

    private static final int MAX = 500001;
    private static final int K = 20;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[][] d = new int[MAX][K];
        for(int i = 1; i <= n; i++)
            d[i][0] = input.nextInt();

        for(int j = 1; j < K; j++) {
            for(int i = 1; i <= n; i++) {
                d[i][j] = d[d[i][j - 1]][j - 1];
            }
        }

        int q = input.nextInt();
        while (q --> 0) {
            int m = input.nextInt();
            int x = input.nextInt();
            for(int i = 0; m > 0; i++) {
                if((m & 1) == 1) // m이 홀수일 때
                    x = d[x][i];
                m >>= 1; // m을 2로 나눈다
            }
            System.out.println(x);
        }
    }
}
