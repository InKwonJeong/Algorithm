package baekjoon.implementation;

import java.util.Scanner;

public class ChristmasParty {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int m = input.nextInt();
        int n = input.nextInt();
        int[] targets = new int[n];
        int[] points = new int[m];

        for (int i = 0; i < n; i++) {
            targets[i] = input.nextInt();
        }

        for (int i = 0; i < n; i++) {
            int target = targets[i];
            for (int j = 0; j < m; j++) {
                int pred = input.nextInt();
                if (target == pred) {
                    points[j]++;
                } else {
                    points[target - 1]++;
                }
            }
        }

        for (int point : points) {
            System.out.println(point);
        }

    }
}
