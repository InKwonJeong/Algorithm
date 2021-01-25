package baekjoon.stage.recursive;

import java.util.Scanner;

public class HanoiTower {

    private static int count;
    private static StringBuilder builder;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        builder = new StringBuilder();
        int n = input.nextInt();
        move(1, 3, n);
        System.out.println(count);
        System.out.println(builder);
    }

    private static void move(int start, int end, int n) {
        count++;

        if(n == 1) {
            builder.append(start).append(" ").append(end).append("\n");
            return;
        }

        move(start, 6 - start - end, n - 1);
        builder.append(start).append(" ").append(end).append("\n");
        move(6 - start - end, end, n - 1);
    }
}
