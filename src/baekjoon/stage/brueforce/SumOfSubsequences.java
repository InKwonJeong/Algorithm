package baekjoon.stage.brueforce;

import java.util.Scanner;

public class SumOfSubsequences {

    private static int n, m, answer;
    private static int[] nums;
    private static boolean[] visit;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        n = input.nextInt();
        m = input.nextInt();
        nums = new int[n];
        visit = new boolean[n];

        for(int i = 0; i < n; i++)
            nums[i] = input.nextInt();

        combination(0, 0, 0);
        if(m == 0)
            answer--;

        System.out.println(answer);
    }

    private static void combination(int start, int depth, int sum) {
        if(sum == m)
            answer++;

        if(depth == n) {
            return;
        }

        for(int i = start; i < n; i++) {
            if(!visit[i]) {
                visit[i] = true;
                combination(i + 1, depth + 1, sum + nums[i]);
                visit[i] = false;
            }
        }
    }
}
