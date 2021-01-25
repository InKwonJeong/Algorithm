package baekjoon.dynamic;

import java.util.Scanner;

public class ParkSeongWon {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();

        String[] strs = new String[n];
        int[] nums = new int[n];
        int[] lens = new int[n];
        int[] ten = new int[51];

        for (int i = 0; i < n; i++) {
            strs[i] = input.next();
            lens[i] = strs[i].length();
        }

        int k = input.nextInt();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < lens[i]; j++) {
                nums[i] = nums[i] * 10 + (strs[i].charAt(j) - '0');
                nums[i] %= k;
            }
        }

        ten[0] = 1;
        for (int i = 1; i <= 50; i++)
            ten[i] = ten[i - 1] * 10 % k;

        long[][] d = new long[(1 << n)][k];
        d[0][0] = 1;
        for (int i = 0; i < (1 << n); i++) {
            for (int j = 0; j < k; j++) {
                for (int l = 0; l < n; l++) {
                    if ((i & (1 << l)) == 0) {
                        int next = j * ten[lens[l]] % k;
                        next += nums[l];
                        next %= k;
                        d[i | (1 << l)][next] += d[i][j];
                    }
                }
            }
        }

        long t1 = d[(1 << n) - 1][0];
        long t2 = 1;
        for(int i = 1; i <= n; i++) t2 *= i;
        long gcd = gcd(t1, t2);
        t1 /= gcd;
        t2 /= gcd;
        System.out.println(t1 + "/" + t2);
    }

    private static long gcd(long a, long b) {
        if(a % b == 0)
            return b;

        return gcd(b, a % b);
    }
}
