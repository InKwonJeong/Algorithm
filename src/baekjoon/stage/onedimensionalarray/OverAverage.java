package baekjoon.stage.onedimensionalarray;

import java.util.Scanner;

public class OverAverage {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int t = input.nextInt();
        while (t > 0) {
            int n = input.nextInt();
            int[] a = new int[n];
            int total = 0;
            for(int i = 0; i < n; i++) {
                int p = input.nextInt();
                total += p;
                a[i] = p;
            }

            double average = (double) total / n;
            double count = 0;
            for(int i = 0; i < n; i++) {
                if(average < a[i])
                    count++;
            }

            System.out.printf("%.3f%s\n", (count / n * 100), "%");

            t--;
        }
    }
}
