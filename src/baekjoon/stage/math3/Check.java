package baekjoon.stage.math3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Check {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());

        int[] arr = new int[size];

        for (int i = 0; i < size; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);

        int gcd = arr[1] - arr[0];

        for (int i = 2; i < size; i++) {
            int dist1 = arr[i] - arr[i - 1];

            gcd = getGCD(gcd, dist1);
        }

        dividers(gcd);
    }

    public static int getGCD(int a, int b) {
        if (b == 0) return 0;

        while (b > 0) {
            int tmp = a;
            a = b;
            b = tmp % b;
        }
        return a;
    }

    private static void dividers(int num) {
        List<Integer> list = new LinkedList<>();
        list.add(num);

        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                if (i == num / i)
                    list.add(i);
                else {
                    list.add(i);
                    list.add(num / i);
                }
            }
        }
        Collections.sort(list);

        StringBuilder sb = new StringBuilder();
        for (Integer integer : list)
            sb.append(integer).append(" ");
        System.out.println(sb.toString());
    }
}

