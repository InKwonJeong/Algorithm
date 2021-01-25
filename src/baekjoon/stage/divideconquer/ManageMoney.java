package baekjoon.stage.divideconquer;

import java.util.Scanner;

public class ManageMoney {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int m = input.nextInt();
        int[] cost = new int[n];

        int max = 0;
        int total = 0;
        for(int i = 0; i < n; i++) {
            cost[i] = input.nextInt();
            total += cost[i];
            if(max < cost[i])
                max = cost[i];
        }

        int answer = 0;
        int start = max;
        int end = total;
        while (start <= end) {
            int mid = (start + end) / 2;
            if(check(cost, m, mid)) {
                answer = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        System.out.println(answer);
    }

    private static boolean check(int[] cost, int m, int k) {
        int count = 1;
        int amount = k;
        for(int c : cost) {
            if(amount >= c) {
                amount -= c;
            } else {
                count++;
                amount = k - c;
            }
        }

        return count <= m;
    }
}
