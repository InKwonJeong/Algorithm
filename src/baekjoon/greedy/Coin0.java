package baekjoon.greedy;

import java.util.Scanner;

public class Coin0 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int n = input.nextInt();
        int k = input.nextInt();
        int[] coins = new int[n];
        for(int i = 0; i < n; i++) {
            coins[(n - 1) - i] = input.nextInt();
        }

        int answer = 0;
        for(int i = 0; i < n; i++) {
            answer += k / coins[i];
            k %= coins[i];
        }
        System.out.println(answer);
    }
}
