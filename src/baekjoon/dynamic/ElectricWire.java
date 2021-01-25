package baekjoon.dynamic;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class ElectricWire {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        Pair[] pairs = new Pair[n];
        int[] d = new int[n];

        for(int i = 0; i < n; i++) {
            int x = input.nextInt();
            int y = input.nextInt();
            pairs[i] = new Pair(x, y);
        }

        Arrays.sort(pairs, Comparator.comparingInt(o -> o.x));

        int answer = 0;
        for(int i = 0; i < n; i++) {
            int value = 0;
            for(int j = 0; j < i; j++) {
                if(pairs[i].y > pairs[j].y)
                    value = Math.max(d[j], value);
            }

            d[i] = value + 1;
            if(answer < d[i])
                answer = d[i];
        }
        System.out.println(n - answer);
    }

    static class Pair {
        int x, y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
