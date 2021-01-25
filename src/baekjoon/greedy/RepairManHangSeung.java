package baekjoon.greedy;

import java.util.Arrays;
import java.util.Scanner;

public class RepairManHangSeung {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int n = input.nextInt();
        int l = input.nextInt();
        int[] a = new int[n];
        for(int i = 0; i < n; i++)
            a[i] = input.nextInt();

        Arrays.sort(a);
        int end = a[0] + l;
        int count = 1;
        for(int i = 1; i < n; i++) {
            if(end <= a[i]) {
                count++;
                end = a[i] + l;
            }
        }
        System.out.println(count);
    }
}
