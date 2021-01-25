package baekjoon.greedy;

import java.util.Arrays;
import java.util.Scanner;

public class Scale {

    private static int n;
    private static int[] a;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        n = input.nextInt();
        a = new int[n];
        for(int i = 0; i < n; i++) {
            a[i] = input.nextInt();
        }
        Arrays.sort(a);
        int sum = 0;
        for(int i = 0; i < n; i++) {
            if(a[i] <= sum + 1) {
                sum += a[i];
            } else {
                break;
            }
        }
        System.out.println(sum + 1);
    }
}
