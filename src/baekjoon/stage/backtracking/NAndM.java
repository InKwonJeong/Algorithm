package baekjoon.stage.backtracking;

import java.util.Scanner;

public class NAndM {
    private static int n, m;
    private static boolean[] visit;
    private static int[] nums;
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        n = input.nextInt();
        m = input.nextInt();
        visit = new boolean[n + 1];
        nums = new int[m];

        permutation(0);
    }

    private static void permutation(int depth) {
        if(depth == m) {
            for(int num : nums)
                System.out.print(num + " ");
            System.out.println();
            return;
        }

        for(int i = 1; i <= n; i++) {
            if(!visit[i]) {
                visit[i] = true;
                nums[depth] = i;
                permutation(depth + 1);
                visit[i] = false;
            }
        }
    }
}
