package baekjoon.stage.sorting;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Treasure {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        Integer[] a = new Integer[n];
        Integer[] b = new Integer[n];

        for(int i = 0; i < n; i++)
            a[i] = input.nextInt();

        for(int i = 0; i < n; i++)
            b[i] = input.nextInt();

        Arrays.sort(a);
        Arrays.sort(b, Comparator.reverseOrder());

        int answer = 0;
        for(int i = 0; i < n; i++) {
            answer += a[i] * b[i];
        }

        System.out.println(answer);
    }
}
