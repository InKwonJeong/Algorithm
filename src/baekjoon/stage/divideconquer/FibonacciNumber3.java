package baekjoon.stage.divideconquer;

import java.util.Scanner;

public class FibonacciNumber3 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        long n = input.nextLong();
        int pisano = 1500000;
        long[] arr = new long[pisano];
        arr[0] = 0;
        arr[1] = 1;

        for (int i = 2; i < pisano && i <= n; i++) {
            arr[i] = (arr[i - 1] + arr[i - 2]) % 1000000;  // 피보나치 수를 1,000,000 으로 나눈 나머지 값을 저장
        }

        if (n >= pisano) {
            n %= pisano;
        }

        System.out.println(arr[(int) n]);

    }
}
