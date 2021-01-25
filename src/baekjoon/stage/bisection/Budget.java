package baekjoon.stage.bisection;

import java.util.Scanner;

public class Budget {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[] cost = new int[n];

        int max = 0;
        for(int i = 0; i < n; i++) {
            cost[i] = input.nextInt();
            if(max < cost[i])
                max = cost[i];
        }
        int budget = input.nextInt();

        int answer = 0;
        int start = budget / n;
        int end = max;
        while (start <= end) {
            int mid = (start + end) / 2;
            if(check(cost, mid, budget)) {
                answer = mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        System.out.println(answer);
    }

    private static boolean check(int[] cost, int mid, int budget) {
        int total = 0;
        for(int c : cost) {
            if(mid < c)
                total += mid;
            else
                total += c;
        }
        return total <= budget;
    }
}
