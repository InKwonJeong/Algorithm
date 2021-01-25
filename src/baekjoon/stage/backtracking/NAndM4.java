package baekjoon.stage.backtracking;

import java.util.Scanner;

public class NAndM4 {
    private static int n, m;
    private static int[] nums;
    private static StringBuilder builder;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        n = input.nextInt();
        m = input.nextInt();
        nums = new int[m];
        builder = new StringBuilder();

        permutation(1, 0);
        System.out.println(builder);
    }

    private static void permutation(int start, int depth) {
        if (depth == m) {
            for (int num : nums)
                builder.append(num).append(" ");
            builder.append("\n");
            return;
        }

        for (int i = start; i <= n; i++) {
            nums[depth] = i;
            permutation(i, depth + 1);
        }
    }
}
