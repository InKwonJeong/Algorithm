package baekjoon.stage.bisection;

import java.util.Scanner;

public class MinimizeTheDifference {

    private static int[] a;
    private static int[] copy;
    private static int n, t;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        n = input.nextInt();
        t = input.nextInt();

        int[] answer = new int[n];
        copy = new int[n];
        a = new int[n];
        for(int i = 0; i < n; i++)
            a[i] = input.nextInt();

        int start = 0;
        int end = 1_000_000_000;
        while (start <= end) {
            int mid = (start + end) / 2;
            if(check(mid)) {
                copyArray(copy, answer);
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        for(int b : answer)
            System.out.printf("%d ", b);
    }

    private static void copyArray(int[] a1, int[] a2) {
        for(int i = 0; i < a1.length; i++)
            a2[i] = a1[i];
    }

    private static boolean check(int diff) {
        copyArray(a, copy);

        int count = 0;
        for(int i = 0; i < n - 1; i++) {
            if(copy[i + 1] - copy[i] > diff) {
                count += copy[i + 1] - (copy[i] + diff);
                copy[i + 1] = copy[i] + diff;
            }
        }

        for(int i = n - 1; i > 0; i--) {
            if(copy[i - 1] - copy[i] > diff) {
                count += copy[i - 1] - (copy[i] + diff);
                copy[i - 1] = copy[i] + diff;
            }
        }

        return count <= t;
    }
}
