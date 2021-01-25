package baekjoon.stage.backtracking;

import java.util.Scanner;

public class NAndM3 {
    private static int n, m;
    private static int[] nums;
    private static StringBuilder builder;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        n = input.nextInt();
        m = input.nextInt();
        nums = new int[m];
        builder = new StringBuilder();

        permutation(0);
        System.out.println(builder);
    }

    private static void permutation(int depth) {
        if (depth == m) {
            for (int num : nums)
                builder.append(num).append(" ");
            builder.append("\n");
            return;
        }

        for (int i = 1; i <= n; i++) {
            nums[depth] = i;
            permutation(depth + 1);
        }
    }
}
