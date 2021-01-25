package baekjoon.stage.recursive;

import java.util.Scanner;

public class PrintStar10 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        StringBuilder builder = new StringBuilder();
        int n = input.nextInt();
        for(int i = 0; i < n; i++) {
            builder.append(print(n, i)).append("\n");
        }
        System.out.println(builder);
    }

    private static StringBuilder print(int n, int line) {
        StringBuilder builder = new StringBuilder();

        if(n == 3) {
            if(line % n == 1) {
                builder.append("* *");
            } else {
                builder.append("***");
            }
            return builder;
        }

        if(line % n >= n / 3 && line % n < 2 * n / 3) {
            builder.append(print(n / 3, line));
            builder.append(printSpace(n / 3));
            builder.append(print(n / 3, line));
        } else {
            builder.append(print(n / 3, line));
            builder.append(print(n / 3, line));
            builder.append(print(n / 3, line));
        }
        return builder;
    }

    private static StringBuilder printSpace(int n) {
        StringBuilder builder = new StringBuilder();
        for(int i = 0; i < n; i++)
            builder.append(" ");
        return builder;
    }
}
