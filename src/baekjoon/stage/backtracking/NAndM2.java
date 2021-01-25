package baekjoon.stage.backtracking;

import java.util.Scanner;

public class NAndM2 {
    private static int n, m;
    private static boolean[] visit;
    private static int[] nums;
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        n = input.nextInt();
        m = input.nextInt();
        visit = new boolean[n + 1];
        nums = new int[m];

        combination(1, 0);
    }

    private static void combination(int start, int depth) {
        if(depth == m) {
            for(int num : nums)
                System.out.print(num + " ");
            System.out.println();
            return;
        }

        for(int i = start; i <= n; i++) {
            if(!visit[i]) {
                visit[i] = true;
                nums[depth] = i;
                combination(i + 1, depth + 1);
                visit[i] = false;
            }
        }
    }
}
