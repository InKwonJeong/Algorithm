package baekjoon.implementation;

import java.util.Scanner;

public class BlackJack {

    private static int n, m, answer;
    private static int[] a;
    private static boolean[] visit;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        n = input.nextInt();
        m = input.nextInt();
        a = new int[n + 1];
        visit = new boolean[n + 1];
        for (int i = 1; i <= n; i++) {
            a[i] = input.nextInt();
        }

        dfs(1, 0, 0);
        System.out.println(answer);
    }

    private static void dfs(int start, int count, int total) {
        if (total > m)
            return;

        if (count == 3) {
            if (answer < total)
                answer = total;
            return;
        }

        for (int i = start; i <= n; i++) {
            if (!visit[i]) {
                visit[i] = true;
                dfs(i + 1, count + 1, total + a[i]);
                visit[i] = false;
            }
        }
    }
}
