package baekjoon.greedy;

import java.util.Scanner;

public class Change {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int[] coins = {500, 100, 50, 10, 5, 1};
        int answer = 0;
        int money = 1000 - input.nextInt();

        for (int coin : coins) {
            answer += (money / coin);
            money %= coin;
        }

        System.out.println(answer);
    }
}
