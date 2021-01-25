package baekjoon.stage.bisection;

import java.util.Arrays;
import java.util.Scanner;

public class InstallRouter {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int c = input.nextInt();
        int answer = 0;
        int[] houses = new int[n];
        for(int i = 0; i < n; i++)
            houses[i] = input.nextInt();

        Arrays.sort(houses);
        int start = 1;
        int end = houses[n - 1] - houses[0];
        while (start <= end) {
            int mid = (start + end) / 2;
            int count = check(houses, mid);
            if(count >= c) {
                answer = mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        System.out.println(answer);
    }

    private static int check(int[] houses, int distance) {
        int prev = houses[0];
        int count = 1;
        for(int house : houses) {
            if(house - prev >= distance) {
                count++;
                prev = house;
            }
        }

        return count;
    }
}
