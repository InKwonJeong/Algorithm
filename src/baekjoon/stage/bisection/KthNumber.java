package baekjoon.stage.bisection;

import java.util.Scanner;

public class KthNumber {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int k = input.nextInt();
        int answer = 0;

        int start = 1;
        int end = k;
        while (start <= end) {
            int mid = (start + end) / 2;
            int sum = 0;
            for(int i = 1; i <= n; i++)
                sum += Math.min(mid / i, n);

            if(sum >= k) {
                answer = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        System.out.println(answer);
    }
}
