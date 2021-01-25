package baekjoon.stage.bisection;

import java.util.Arrays;
import java.util.Scanner;

public class FindNumber {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[] a = new int[n];
        for(int i = 0; i < n; i++)
            a[i] = input.nextInt();

        int m = input.nextInt();
        int[] b = new int[m];
        for(int i = 0; i < m; i++)
            b[i] = input.nextInt();

        Arrays.sort(a);

        for(int i = 0; i < m; i++) {
            boolean finish = false;
            int start = 0;
            int end = n - 1;

            while (start <= end) {
                int mid = (start + end) / 2;
                if (b[i] == a[mid]) {
                    finish = true;
                    break;
                } else if(b[i] > a[mid]) {
                    start = mid + 1;
                } else if(b[i] < a[mid]) {
                    end = mid - 1;
                }
            }

            if(finish)
                System.out.println(1);
            else
                System.out.println(0);
        }
    }
}
