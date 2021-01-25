package baekjoon.greedy;

import java.util.Arrays;
import java.util.Scanner;

public class Rope {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int n = input.nextInt();
        int[] d = new int[n];
        for(int i = 0; i < n; i++) {
            d[i] = input.nextInt();
        }

        Arrays.sort(d);

        int answer = 0;
        for(int i = 0; i < n; i++) {
            int weight = d[i] * (n - i);
            if(answer < weight)
                answer = weight;
        }
        System.out.println(answer);
    }
}
