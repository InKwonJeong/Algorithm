package baekjoon.dynamic;

import java.util.Scanner;

public class MakeItOne {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int[] d = new int[1000001];
        int n = input.nextInt();
        d[1] = 0;

        for(int i = 2; i <= n; i++) {
            if(i % 3 == 0 && i % 2 == 0)
                d[i] = 1 + min(d[i / 3], d[i / 2], d[i - 1]);
            else if(i % 3 == 0)
                d[i] = 1 + min(d[i / 3], d[i - 1]);
            else if(i % 2 == 0)
                d[i] = 1 + min(d[i / 2], d[i - 1]);
            else
                d[i] = d[i - 1] + 1;
        }

        System.out.println(d[n]);
    }

    static int min(int... a) {
        int min = a[0];
        for(int i = 1; i < a.length; i++) {
            if(min > a[i])
                min = a[i];
        }
        return min;
    }
}
