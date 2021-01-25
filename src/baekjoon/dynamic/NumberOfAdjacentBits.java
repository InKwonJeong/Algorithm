package baekjoon.dynamic;

import java.util.Scanner;

public class NumberOfAdjacentBits {
    public static void main(String[] args) {
        Scanner input = new Scanner((System.in));
        int[][][] nums = new int[101][100][2];

        nums[1][0][0] = nums[1][0][1] = 1;

        int T = input.nextInt();
        for (int t = 0; t < T; t++) {
            int n = input.nextInt();
            int k = input.nextInt();

            for (int i = 2; i <= n; i++) {
                for (int j = 0; j <= k; j++) {
                    nums[i][j][0] = nums[i - 1][j][0] + nums[i - 1][j][1];
                    if (j > 0)
                        nums[i][j][1] = nums[i - 1][j][0] + nums[i - 1][j - 1][1];
                    else
                        nums[i][j][1] = nums[i - 1][j][0];
                }
            }

            System.out.println(nums[n][k][0] + nums[n][k][1]);
        }
    }
}
