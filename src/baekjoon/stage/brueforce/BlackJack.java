package baekjoon.stage.brueforce;

import java.util.Scanner;

public class BlackJack {

    private static int n, m, answer;
    private static int[] a;
    private static boolean[] visit;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        n = input.nextInt();
        m = input.nextInt();
        a = new int[n];
        visit = new boolean[n];

        for(int i = 0; i < n; i++)
            a[i] = input.nextInt();

        combination(0, 0, 0);
        System.out.println(answer);
    }

    private static void combination(int start, int depth, int total) {
        if(depth == 3) {
            if(total <= m && answer < total)
                answer = total;
            return;
        }

        for(int i = start; i < n; i++) {
            if(!visit[i]) {
                visit[i] = true;
                combination(i + 1, depth + 1, total + a[i]);
                visit[i] = false;
            }
        }
    }
}
